package src.ru.rtk.java.Homework.homework06.h2;

import java.util.ArrayList;

public class Television {

    private boolean isOn;
    private TV currentChannel;
    private ArrayList<TV> channels;

    public Television(boolean isOn, TV currentChannel, ArrayList<TV> channels) {
        this.isOn = isOn;
        this.currentChannel = currentChannel;
        this.channels = channels;
    }

    // Включение/выключение телевизора
    public void togglePower() {
        isOn = !isOn;
        System.out.println("Телевизор " + (isOn ? "включен" : "выключен"));
    }

    // Переключение канала по номеру
    public void changeChannel(int channelNumber) {
        if (!isOn) {
            System.out.println("Сначала включите телевизор!");
            return;
        }

        for (TV channel : channels) {
            if (channel.getNumber_channel() == channelNumber) {
                currentChannel = channel;
                System.out.println("Переключено на канал: " + channel.getName_channel());
                return;
            }
        }
        System.out.println("Канал " + channelNumber + " не найден");
    }

    // Показать текущий канал
    public void showCurrentChannel() {
        if (!isOn) {
            System.out.println("Телевизор выключен");
            return;
        }

        if (currentChannel != null) {
            System.out.println("Текущий канал: " + currentChannel.getName_channel());
            currentChannel.showCurrentProgram();
        } else {
            System.out.println("Канал не выбран");
        }
    }

    // Геттеры и сеттеры
    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public TV getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(TV currentChannel) {
        this.currentChannel = currentChannel;
    }



    public ArrayList<TV> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<TV> channels) {
        this.channels = channels;
    }
}
