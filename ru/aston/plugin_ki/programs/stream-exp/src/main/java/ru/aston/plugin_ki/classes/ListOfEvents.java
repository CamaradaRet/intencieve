package ru.aston.plugin_ki.classes;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class ListOfEvents {
    private  static List<LocalDate> dates = List.of(
                                                    LocalDate.of(2023, Month.JANUARY, 15),
                                                    LocalDate.of(2023, Month.FEBRUARY, 20),
                                                    LocalDate.of(2023, Month.APRIL, 10),
                                                    LocalDate.of(2023, Month.JULY, 5),
                                                    LocalDate.of(2023, Month.SEPTEMBER, 30),
                                                    LocalDate.of(2023, Month.DECEMBER, 25)
                                                    );

    public static List<LocalDate> getDates(){
        return dates;
    }

}
