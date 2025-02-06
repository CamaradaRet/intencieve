package ru.aston.plugin_ki;

import java.util.Arrays;
import java.util.Comparator;

public class StringEquilibrist {

    public static String findTheLongest(String string){
        String[] strings = string.split("\\s");
        Arrays.sort(strings, Comparator.comparingInt(String::length));

        return strings[strings.length-1]; //если самых длинны слов несколько, то выведет самое последнее из встречающихся
    }

    public static boolean isPalindrome(String string){     //проверяет только если нет знаков препинания
        String[] strings = string.split("\\s");
        StringBuilder stringBuilder = new StringBuilder();

        for(String s : strings){
            stringBuilder.append(s);
        }

        String straight = stringBuilder.toString();
        stringBuilder.reverse();
        String reverse = stringBuilder.toString();

        return straight.equalsIgnoreCase(reverse);
    }

    public static String censorship(String string){
        return  string.replaceAll("бяка", "[вырезано цензурой]");
    }


    public static int howManyTimes(String string, String subString){
        int count = 0;

        for (String str : string.split("\\s")){
            if(str.equalsIgnoreCase(subString)){ //можно без игнорирования регистра просто equals(),
                count += 1;                      //тогда будет сравнивать только точное совпадение
            }
        }

        return count; //проверяет только если нет знаков препинания
    }

    public static String wouldULikeToReverse(String string){

        String str = "";
        StringBuilder result = new StringBuilder();
        for (String tmp : string.split("\\s")) {
            str = new StringBuilder(tmp).reverse() + " ";
            result.append(str);
        }

        return result.toString();
    }
}
