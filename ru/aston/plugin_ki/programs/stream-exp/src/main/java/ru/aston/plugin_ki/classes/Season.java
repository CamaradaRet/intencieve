package ru.aston.plugin_ki.classes;

import java.time.LocalDate;
import java.time.Month;

public enum Season {
    WINTER("Зима"),
    SPRING("Весна"),
    SUMMER("Лето"),
    AUTUMN("Осень");

    private final String title;
    private Season(String title){
        this.title = title;
    }

    public static Season getSeason(LocalDate date) {
        Month month = date.getMonth();
        if (month == Month.DECEMBER || month == Month.JANUARY || month == Month.FEBRUARY) {
            return Season.WINTER;
        } else if (month == Month.MARCH || month == Month.APRIL || month == Month.MAY) {
            return Season.SPRING;
        } else if (month == Month.JUNE || month == Month.JULY || month == Month.AUGUST) {
            return Season.SUMMER;
        } else {
            return Season.AUTUMN;
        }
    }

    @Override
    public String toString() {
        return title;
    }
}
