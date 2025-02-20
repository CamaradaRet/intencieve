package ru.aston.plugin_ki;

import ru.aston.plugin_ki.classes.ListOfEvents;
import ru.aston.plugin_ki.classes.Season;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExercises {

    //вывести все четные числа в диапазоне от 1 до 100
    public static void allEven(int element){
        IntStream.rangeClosed(1, element)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }

    //умножить каждое число в массиве [1, 2, 3, 4, 5] на 2
    public static int[] multByTwo(int[] elements){

        return Arrays.stream(elements)
                .map(n -> n * 2)
                .toArray();
    }

    //посчитать сумму чисел в массиве [1, 2, 3, 4, 5], используя reduce()
    public static int getSum(int[] elements){

        return Arrays.stream(elements)
                .reduce(0, (a, b) -> a + b);
    }

    //вывести числа в диапазоне от 1 до 50 с шагом 2
    public static void everySecond(int element){
        IntStream.rangeClosed(1, element)//.filter(n -> n % 2 != 0) //можно ещё так, если map не закомментировать, а
                .map(n -> n - 1)                                    //filter раскомментировать то будет выводить четные,
                .forEach(System.out::println);                      //а если map убрать filter оставить то результат будет такой же, как и сейчас
    }

    //Найти первый четный элемент в списке [1, 2, 3, 4, 5]
    public static int firstEven(List<Integer> listElements){
        Optional<Integer> firstEven = listElements.stream()
                .filter(n -> n % 2 == 0)
                .findFirst();

        return firstEven.orElse(-1);
    }

    //Отсортировать элементы массива [1, 3, 5, 7, 9] по возрастанию
    public static int[] ascendingOrder(int[] elements){

        return Arrays.stream(elements)
                .sorted()
                .toArray();
    }

    //вывести первые 10 чисел в списке [0, 1, 2, … 99]
    public static void firstTen(List<Integer> listElements){
        if(listElements.size() <= 10){
            listElements.forEach(System.out::println);
        }else {
            listElements.subList(0, 10).forEach(System.out::println);
        }
    }

    //пропустить первые 10 элементов списка [0, 1, 2,.., 99] и начать выводить с 11-го элемента, выводя каждый 10-й элемент
    public static void everyTenth(List<Integer> listElements){
        listElements.stream()
                    .skip(11)
                    .filter(n -> n % 10 == 0)
                    .forEach(System.out::println);
    }

    //выведите на экран все числа в диапазоне от 1 до 100, которые делятся на 3
    public static void everyThirdFromHundred(){
        IntStream.rangeClosed(0, 100)
                .filter(n -> n % 3 == 0)
                .forEach(System.out::println);
    }

    //выведите на экран только те элементы списка, которые больше заданного числа
    public static void onlyGreater(List<Integer> listElements, int reference){
        listElements.stream()
                .filter(n -> n > reference)
                .forEach(System.out::println);
    }

    //отфильтруйте все элементы списка, которые меньше 0
    public static void onlyPositive(List<Integer> listElements){
        listElements.stream()
                .filter(n -> n < 0)
                .forEach(System.out::println);
    }

    //выведите на экран строки, которые начинаются с заданной подстроки
    public static void fromMyString(String strings, String subString){
        Arrays.stream(strings.trim().split("\\s+"))
                .filter(s -> s.startsWith(subString))
                .forEach(System.out::println);
    }

    //создать два стрима: один из чисел от 0 до 10, другой из чисел от 10 до 20:
    // объединить их в один стрим и вывести на экран числа больше 10.
    public static void greaterThenTen(){
        IntStream stream1 = IntStream.rangeClosed(0, 10);
        IntStream stream2 = IntStream.rangeClosed(10, 20);

        IntStream.concat(stream1, stream2)
                .filter(e -> e > 10)
                .forEach(System.out::println);
    }

    //создать стрим чисел от 0 до 100;
    // умножить их на 2 и вывести на экран результат, ограничиться первыми 10 результатами
    public static void mulByTwoFirstTen(){
        IntStream.rangeClosed(0,10)
                .map(e -> e * 2)
                .limit(10)
                .forEach(System.out::println);
    }

    //создать стрим, который выводит числа от 1 до 10. Найти среднее арифметическое этих чисел и вывести его на экран
    public static void mean(){
        int[] elements = IntStream.rangeClosed(1, 10).toArray();

        System.out.println( Arrays.stream(elements)
                .mapToObj(String::valueOf)
                .collect( Collectors.toList() )) ;

        OptionalDouble average = Arrays.stream(elements).asDoubleStream().average();

         if (average.isPresent()){
            System.out.println("\nСреднее арифметическое: " + average.getAsDouble());
         }
    }

    //разделить даты в Stream на четыре группы по временам года, посчитать количество событий в каждом времени года
    public static void getNumberEvents(){
        List<LocalDate> eventsAndDate = ListOfEvents.getDates();

        Map<Season, Long> eventBySeason = eventsAndDate.stream()
                .collect(Collectors.groupingBy(Season :: getSeason,
                        Collectors.counting()));

        eventBySeason.forEach((season, count) ->
                System.out.println(season + ": " + count + " событий"));

    }

    //разделить файлы в Stream на два списка: с расширением .txt и с расширением .doc, посчитать количество файлов в каждом списке
    public static void differentFiles(){
        List<String> files = List.of(
                "file1.txt",
                "file2.zip",
                "file3.txt",
                "file4.doc",
                "file5.txt",
                "file6.pdf",
                "file7.mp4",
                "file8.doc"
        );

        Map<Boolean, Long> filesCount = files.stream()
                .filter(file -> file.endsWith(".txt") || file.endsWith(".doc"))
                .collect(Collectors.partitioningBy(file -> file.endsWith(".txt"),
                        Collectors.counting()));

        System.out.println("Файлов с расширением \".txt\": " + filesCount.get(true));
        System.out.println("Файлов с расширением \".doc\": " + filesCount.get(false));
    }

}
