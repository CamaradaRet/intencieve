package ru.aston.plugin_ki;


import java.util.HashMap;
import java.util.Optional;

public class CheckForOrder {

    public static String isSorted(int[] elements){

        if(elements.length < 2){
            return "Ok";
        }
        for (int i = 0; i < elements.length-1; i++){
            if (elements[i] > elements[i+1]){
                return "Please, try again";
            }
        }

        return "Ok";
    }

    public static int[] sharper(int[] elements){

        int tmp = elements[0];
        elements[0] = elements[elements.length-1];
        elements[elements.length-1] = tmp;

        return elements;

    }

    public static Optional<Integer> theOnlyOne(int[] elements) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : elements) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num : elements) {
            if (countMap.get(num) == 1) {
                return Optional.of(num);
            }
        }

        return Optional.empty();
    }

    public static int[] orderlyMerging(int[] elements){
         if(elements.length < 2){
             return elements;
         }

         int middle = elements.length/2;
         int[] first = new int[middle];
         int[] second = new int[elements.length - middle];


        for (int i = 0; i < middle; i++) {
            first[i] = elements[i];
        }
        for (int i = middle; i < elements.length; i++) {
            second[i - middle] = elements[i];
        }

        orderlyMerging(first);
        orderlyMerging(second);

        return reunion(elements, first, second);

    }

    private static int[] reunion(int[] main, int[] first, int[] second) {

       int i=0,
           j=0,
           k=0;

       while (i<first.length && j<second.length){
           if(first[i] <= second[j]){
               main[k++] = first[i++];
           }else {
               main[k++] = second[j++];
           }
       }

       while (i<first.length){
           main[k++] = first[i++];
       }

       while (j<second.length){
           main[k++] = second[j++];
       }

       return main;
    }
}


