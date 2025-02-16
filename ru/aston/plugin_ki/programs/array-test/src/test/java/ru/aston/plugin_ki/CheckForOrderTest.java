package ru.aston.plugin_ki;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CheckForOrderTest {

    @Test
    void testIsSorted(){
        int[] a = {11, 13, 25, 69, 51};

        assertEquals("Please, try again", CheckForOrder.isSorted(a));
    }

    @Test
    void testSharper(){
        int[] a = {5, 6, 7, 2};

        assertEquals(a = new int[]{2, 6, 7, 5}, CheckForOrder.sharper(a));
    }

    @Test
    void testTheOnlyOne(){
        int[] a = {1, 2, 3, 1, 2, 4};
        Optional<Integer> obj = CheckForOrder.theOnlyOne(a);

        assertTrue(obj.isPresent());
        assertEquals(3, obj.get());

//        assertFalse(obj.isPresent());
    }



    @Test
    void  testOrderlyMerging(){
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt();
        }
        int[] expect = Arrays.copyOf(array, array.length);
        Arrays.sort(expect);
        int[] sortedArray = CheckForOrder.orderlyMerging(array);

        assertArrayEquals(expect, sortedArray);
    }
}
