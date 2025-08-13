package src.ru.rtk.java.Homework.homework06;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;


public class App {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>(); // Список продуктов
        ArrayList<Person> people = new ArrayList<>(); // Список покупателей

        // Создание продуктов
        Product bread = new Product("Хлеб", 40);
        Product milk = new Product("Молоко", 50);

        Product test1 = new Product("", 50); // Пустая название
        Product test2 = new Product("Пе", 50); // Вводимая строка меньше 3 символов

        DiscountProduct coffee = new DiscountProduct("Кофе", 879, 20, LocalDate.of(2025, 12, 31));
        DiscountProduct cookie = new DiscountProduct("Печенье", 50, 30, LocalDate.of(2025, 12, 31));

        // Создание покупателя
        Person person = new Person("Павел Андреевич", 10000);



        // Выполнение покупок
        person.buy_groceries(bread);     // 40 руб
        person.buy_groceries(coffee);    // 703.20 руб (скидка 20%)
        person.buy_groceries(cookie);


        System.out.println(person);
        System.out.println("Общая сумма покупок: " + person.getMoney() + " руб");
        //System.out.println(coffee.name,person.toString() );

        // Выводим информацию о нем
        System.out.println(coffee);

//        // Ввод покупателей
//        System.out.println("Введите покупателей (Имя = Деньги): \nВведите END для завершения ввода покупателей:");
//        while (true) {
//            String line = scanner.nextLine().trim(); // Считываем строку
//            if (line.equals("END")) break;
//
//            // Разделяем по ";"
//            String[] entries = line.split(";"); // Разделяем по ";"
//            for (String entry : entries) {
//                String[] parts = entry.split("=");
//                if (parts.length != 2) continue; // Пропускаем, если не равно 2
//
//                String name = parts[0].trim(); // Убираем пробелы
//                int money = Integer.parseInt(parts[1].trim()); // Преобразуем в число
//
//                people.add(new Person(name, money)); // Добавляем покупателя в список
//            }
//        }
//
//        // Ввод продуктов
//        System.out.println("Введите продукты (Название = Цена): \nВведите END для завершения ввода продуктов:");
//        while (true) {
//            String line = scanner.nextLine().trim(); // Считываем строку
//            if (line.equals("END")) break;  // Проверяем, если строка равна "END", выходим
//
//            String[] entries = line.split(";"); // Разделяем по ";"
//            for (String entry : entries) { // Перебираем строки
//                String[] parts = entry.split("=");
//                if (parts.length != 2) continue; // Пропускаем, если не равно 2
//
//                String name = parts[0].trim(); // Убираем пробелы
//                int price = Integer.parseInt(parts[1].trim());  // Преобразуем в число
//
//                products.add(new Product(name, price)); // Добавляем продукт в список
//            }
//        }
//
//        // Ввод покупок
//        System.out.println("Введите покупки (Имя покупателя - Название продукта): \nВведите END для завершения ввода покупок:");
//        while (true) {
//            String line = scanner.nextLine().trim();  // Считываем строку
//            if (line.equals("END")) break;  // Проверяем, если строка равна "END", выходим
//
//            String[] entries = line.split(";");  // Разделяем по ";"
//            for (String entry : entries) {  // Перебираем строки
//                String[] parts = entry.split("-");  // Разделяем по "-"
//                if (parts.length != 2) continue;  // Пропускаем, если не равно 2
//
//                String personName = parts[0].trim();  // Убираем пробелы
//                String productName = parts[1].trim();  // Убираем пробелы
//
//                Person person = null;  // Создаем переменную для покупателя, равно null
//                for (Person p : people) {  // Перебираем покупателей
//                    if (p.getName().equals(personName)) {  // Если имя покупателя равно имени из строки
//                        person = p;
//                        break;  // Выходим из цикла
//                    }
//                }
//
//                Product product = null;
//                for (Product p : products) {
//                    if (p.getName().equals(productName)) {
//                        product = p;
//                        break;
//                    }
//                }
//
//                if (person != null && product != null) { // Если покупатель и продукт не равны null
//                    person.buy_groceries(product); // Выполняем покупку
//                }
//            }
//        }
//
//        // Вывод результатов
//        for (Person person : people) {// Перебираем покупателей
//            System.out.println(person); // Выводим покупателя
//        }
   }



}
