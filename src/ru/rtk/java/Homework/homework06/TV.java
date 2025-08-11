package src.ru.rtk.java.Homework.homework06;

import java.util.ArrayList;
import java.util.Objects;

public class TV {

    private String name_channel; // название канала
    private int number_channel; // номер канала
    private ArrayList<TV_program> channelList; /* список каналов */

    public TV(String name_channel, int number_channel) {
        this.name_channel = name_channel;
        this.number_channel = number_channel;
        this.channelList = new ArrayList<>(); // ✅ Инициализация списка
    }

    // геттер
    public String getName_channel() {
        return name_channel;
    }

    public ArrayList<TV_program> getChannelList() {
        return channelList;
    }

    // сеттер
    public void setName_channel(String name_channel) {
        this.name_channel = name_channel;
    }

    public int getNumber_channel() {
        return number_channel;
    }

    public void setNumber_channel(int number_channel) {
        this.number_channel = number_channel;
    }

    public void setChannelList(ArrayList<TV_program> channelList) {
        this.channelList = channelList;
    }

    public void addChannel(TV_program channel) {
        if (channel != null) {
            channelList.add(channel);
        }
    }

    public void showCurrentProgram() {
    for (TV_program program : channelList) {
        System.out.println(program);
    }
}



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Канал: " + name_channel + ", Номер: " + number_channel + "\n");
        for (TV_program program : channelList) {
            sb.append(program).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TV tv = (TV) o;
        return Objects.equals(name_channel, tv.name_channel) &&
               number_channel == tv.number_channel &&
               Objects.equals(channelList, tv.channelList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name_channel, number_channel, channelList);
    }
}
