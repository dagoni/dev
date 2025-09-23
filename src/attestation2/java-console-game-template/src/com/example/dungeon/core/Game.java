package com.example.dungeon.core;

import com.example.dungeon.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
public class Game {
    private final GameState state = new GameState();
    private final Map<String, Command> commands = new LinkedHashMap<>();
    static {
        WorldInfo.touch("Game");
    }

    public Game() {
        registerCommands();
        bootstrapWorld();
    }

    private void registerCommands() {

        // Пример ошибки компиляции (раскомментируйте для проверки):
        // String str = 12356456456456; // Ошибка компиляции: несовместимые типы

        // Пример ошибки выполнения:
        //int zero = 0;
        //int result = 100 / zero; // Ошибка выполнения: ArithmeticException - деление на ноль



        commands.put("help", (ctx, a) -> System.out.println("Команды: " + String.join(", ", commands.keySet())));
        commands.put("gc-stats", (ctx, a) -> { //статистика
            Runtime rt = Runtime.getRuntime();
            long free = rt.freeMemory(), total = rt.totalMemory(), used = total - free;
            System.out.println("Память: used=" + used + " free=" + free + " total=" + total);
        });
        commands.put("look", (ctx, a) -> System.out.println(ctx.getCurrent().describe())); //обзор

        commands.put("move", (ctx, a) -> {

            if (a.isEmpty()) {//если пусто
                throw new InvalidCommandException("Укажите направление: north, south, east или west");
            }

            String direction = a.get(0).toLowerCase();
            Room currentRoom = ctx.getCurrent();
            Room nextRoom = currentRoom.getNeighbors().get(direction);

            if (nextRoom == null) { //если нет пути
                throw new InvalidCommandException("Нет пути в этом направлении");
            }

            ctx.setCurrent(nextRoom);   //перемещение
            System.out.println("Вы перешли в: " + nextRoom.getName()); //вывод
            System.out.println(nextRoom.describe()); //описание


        }); //перемещение

        commands.put("take", (ctx, a) -> {
            if (a.isEmpty()) {
                throw new InvalidCommandException("Укажите предмет");
            }
            String itemName = String.join(" ", a); //объединение всех элементов в строку
            Room current = ctx.getCurrent(); //текущая комната
            Optional<Item> item = current.getItems().stream() //поиск предмета
                    .filter(i -> i.getName().equalsIgnoreCase(itemName))
                    .findFirst(); //найти первый

            if (item.isEmpty()) { //если предмета нет
                throw new InvalidCommandException("В этой комнате нет такого предмета");
            }

            Item found = item.get(); //найденный предмет
            current.getItems().remove(found); //удаление из комнаты
            ctx.getPlayer().getInventory().add(found); //добавление в инвентарь
            System.out.println("Взято: " + found.getName()); //вывод
        }); //взять

        commands.put("inventory", (ctx, a) -> {
            Player player = ctx.getPlayer(); //игрок
            if (player.getInventory().isEmpty()) {//если инвентарь пуст
                System.out.println("Инвентарь пуст");//вывод
                return;
            }

            // Группируем предметы по типу с использованием Stream
            player.getInventory().stream()
                    .collect(Collectors.groupingBy(item -> item.getClass().getSimpleName())) //группировка
                    .forEach((type, items) -> {
                        String itemNames = items.stream()
                                .map(Item::getName)
                                .collect(Collectors.joining(", "));
                        System.out.println(type + " (" + items.size() + "): " + itemNames);
                    });
        }); //инвентарь

        commands.put("use", (ctx, a) -> {
            if (a.isEmpty()) { //если пусто
                throw new InvalidCommandException("Укажите предмет для использования");
            }

            String itemName = String.join(" ", a); //объединение всех элементов в строку
            Player player = ctx.getPlayer(); //игрок

            // Находим предмет в инвентаре
            Optional<Item> item = player.getInventory().stream() //поиск
                    .filter(i -> i.getName().equalsIgnoreCase(itemName))
                    .findFirst();

            if (item.isEmpty()) { //если предмета нет
                throw new InvalidCommandException("У вас нет такого предмета");
            }

            // Используем предмет
            item.get().apply(ctx);
        }); //использование

        commands.put("fight", (ctx, a) -> {
            Room currentRoom = ctx.getCurrent();
            Player player = ctx.getPlayer();
            Monster monster = currentRoom.getMonster();

            if (monster == null) {
                throw new InvalidCommandException("В этой комнате нет монстра");
            }

            // Проверяем, не побежден ли уже монстр
            if (monster.getHp() <= 0) {
                System.out.println(monster.getName() + " уже побежден!");
                return;
            }

            while (monster.getHp() > 0 && player.getHp() > 0) {
                // Атака игрока
                monster.setHp(monster.getHp() - player.getAttack());
                System.out.println("Вы бьёте " + monster.getName() + " на " + player.getAttack()
                        + ". HP монстра: " + Math.max(monster.getHp(), 0));

                if (monster.getHp() <= 0) {
                    System.out.println("Вы победили " + monster.getName() + "!");

                    // ВЫПАДЕНИЕ ЛУТА - ключевое изменение!
                    if (!monster.getLoot().isEmpty()) {
                        System.out.println(monster.getName() + " оставил после себя:");
                        for (Item item : monster.getLoot()) {
                            currentRoom.getItems().add(item);
                            System.out.println("  - " + item.getName());
                        }
                    }

                    currentRoom.setMonster(null);
                    break;
                }

                // Атака монстра
                player.setHp(player.getHp() - monster.getLevel());
                System.out.println(monster.getName() + " отвечает на " + monster.getLevel()
                        + ". Ваше HP: " + player.getHp());

                if (player.getHp() <= 0) {
                    System.out.println("Вы погибли! Игра окончена.");
                    System.exit(0);
                }
            }
        }); //бой  //атака

        commands.put("save", (ctx, a) -> SaveLoad.save(ctx)); // сохранение

        commands.put("load", (ctx, a) -> { // загрузка
            // Создаем новое состояние перед загрузкой
            GameState newState = new GameState();
            SaveLoad.load(newState);
            // Загружаем данные
            state.setPlayer(newState.getPlayer()); //игрок
            state.setCurrent(newState.getCurrent());//комната
            state.setScore(newState.getScore());//баллы
        });

        commands.put("scores", (ctx, a) -> SaveLoad.printScores()); // баллы

        commands.put("about", (ctx, a) -> {// о программе
            System.out.println("DungeonMini v1.1 - текстовая игра");
            System.out.println("Разработано для промежуточной аттестации 2");
        });

        commands.put("exit", (ctx, a) -> {

            System.out.println("Пока!");
            System.exit(0);
        });
    }

    private void bootstrapWorld() {
        Player hero = new Player("Герой", 20, 5);
        state.setPlayer(hero);

        Room square = new Room("Площадь", "Каменная площадь с фонтаном.");
        Room forest = new Room("Лес", "Шелест листвы и птичий щебет.");
        Room cave = new Room("Пещера", "Темно и сыро.");
        square.getNeighbors().put("north", forest);
        forest.getNeighbors().put("south", square);
        forest.getNeighbors().put("east", cave);
        cave.getNeighbors().put("west", forest);

        forest.getItems().add(new Potion("Малое зелье", 5));


        // Создаем монстра с лутом
        List<Item> wolfLoot = new ArrayList<>();
        wolfLoot.add(new Potion("Зелье здоровья", 10));
        wolfLoot.add(new Key("Ржавый ключ"));
        wolfLoot.add(new Weapon("Клык волка", 2)); // можно добавить оружие


        //System.out.println("Зелья в Лесу: " + forest.getItems());


        forest.setMonster(new Monster("Волк", 1, 8, wolfLoot));
        state.setCurrent(square);
    }

    public void run() {
        System.out.println("DungeonMini (TEMPLATE). 'help' — команды.");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("> ");
                String line = in.readLine();
                if (line == null) break;
                line = line.trim();
                if (line.isEmpty()) continue;
                List<String> parts = Arrays.asList(line.split("\s+"));
                String cmd = parts.getFirst().toLowerCase(Locale.ROOT);
                List<String> args = parts.subList(1, parts.size());
                Command c = commands.get(cmd);
                try {
                    if (c == null) throw new InvalidCommandException("Неизвестная команда: " + cmd);
                    c.execute(state, args);
                    state.addScore(1);
                } catch (InvalidCommandException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Непредвиденная ошибка: " + e.getClass().getSimpleName() + ": " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.getMessage());
        }
    }
}
