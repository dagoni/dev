package src.ru.rtk.java.Homework.homework06.Мусорка2.h2;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Создание каналов
        TV channel1 = new TV("Смех TV", 101);
        channel1.getChannelList().add(new TV_program("Комики на кухне", 30, 900));
        //channel1.getChannelList().add(new TV_program("Шутки с подвохом", 45, 935));
        //channel1.getChannelList().add(new TV_program("Вечерний хохот", 60, 1025));

        TV channel2 = new TV("Юмор 24/7", 202);
        channel2.getChannelList().add(new TV_program("Утренний кофе с юмором", 40, 700));
        //channel2.getChannelList().add(new TV_program("Анекдоты про тещу", 25, 745));
       // channel2.getChannelList().add(new TV_program("Стендап для сонных", 50, 815));

        TV channel3 = new TV("Смех без причины", 808);
        channel3.getChannelList().add(new TV_program("Детский юмор", 20, 1500));
        //channel3.getChannelList().add(new TV_program("Школьные приколы", 35, 1525));
        //channel3.getChannelList().add(new TV_program("Студенческий смех", 50, 1605));

        TV channel4 = new TV("Комик-станция", 1010);
        channel4.getChannelList().add(new TV_program("Импровизация на кухне", 55, 1400));
        //channel4.getChannelList().add(new TV_program("Юморные интервью", 45, 1500));
        //channel4.getChannelList().add(new TV_program("Стендап-битва", 60, 1550));

        //TV channel5 = new TV("Discovery", 15);
        //TV_program program = new TV_program("Новости", 7, 1005);

        // Создаем список каналов
        ArrayList<TV> channels = new ArrayList<>();
        channels.add(channel1);
        channels.add(channel2);
        channels.add(channel3);
        channels.add(channel4);
        //channels.add(channel5);

        // Создаем телевизор
        Television tv = new Television(false, channel4, channels);

        // Тестирование
        tv.togglePower();             // Включить
        tv.changeChannel(101);        // Переключиться на Смех TV
        tv.showCurrentChannel();      // Показать текущий канал
        tv.changeChannel(202);        // Переключиться на Юмор 24/7
        tv.showCurrentChannel();      // Показать текущий канал
        tv.changeChannel(2020);        // Переключиться на несуществующий канал
        tv.showCurrentChannel();      // Показать текущий канал
        tv.togglePower();             // Выключить
    }
}
