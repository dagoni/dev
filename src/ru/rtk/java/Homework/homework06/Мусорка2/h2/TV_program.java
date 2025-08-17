package src.ru.rtk.java.Homework.homework06.Мусорка2.h2;

import java.util.Objects;

public class TV_program {

    private String name_program; // название программы
    private Integer Ranngge; // рейтинг программы
    private Integer coount_viewers; // количество зрителей

    public TV_program(String name_program, Integer Ranngge, Integer coount_viewers) {
        this.name_program = name_program;
        this.Ranngge = Ranngge;
        this.coount_viewers = coount_viewers;
    }

    // Геттеры
    public String getName_program() {
        return name_program;
    }

    public void setName_program(String name_program) {
        this.name_program = name_program;
    }

    public Integer getRanngge() {
        return Ranngge;
    }

    public void setRanngge(Integer ranngge) {
        Ranngge = ranngge;
    }

    public Integer getCoount_viewers() {
        return coount_viewers;
    }

    public void setCoount_viewers(Integer coount_viewers) {
        this.coount_viewers = coount_viewers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TV_program program = (TV_program) o;
        return Objects.equals(name_program, program.name_program) &&
               Objects.equals(Ranngge, program.Ranngge) &&
               Objects.equals(coount_viewers, program.coount_viewers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name_program, Ranngge, coount_viewers);
    }

    @Override
    public String toString() {
        return "Программа: " + name_program +
               ", Рейтинг: " + Ranngge +
               ", Зрители: " + coount_viewers;
    }
}
