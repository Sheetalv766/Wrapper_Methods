package com.crio.QKART_TestNG;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import org.openqa.selenium.WebElement;

public class WrapperClass {

    // sort an array
    public static void main(String[] args) {
        int[] arr = {5, -2, 23, 7, 87, -42, 509};
        arr = sortWrapper(arr);
        System.out.println("\nThe sorted array is: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] sortWrapper(int a[]) {
        /*
         * TODO: Implement Wrapper to: print first and last elements before sort SORT the Array
         * print first and last elements after sort print time taken for sort
         */

        // class of java --> part of java time library--> current time of the java system
        Instant start = Instant.now();

        // print first and last elements before sort
        System.out.println(
                String.format("First and Last element of the array are %d and %d respectively",
                        a[0], a[a.length - 1]));

        // SORT the Array
        Arrays.sort(a);

        Instant end = Instant.now();

        // print first and last elements after sort
        // %2d --> if we pass run time or dynamical value --> we pass the specific value at specific
        // position--> %1$s --> first value of an array , || %2%s --> second value of an array
        // %d --> digits of an array
        System.out.println(
                String.format("First and Last element of the array are %d and %d respectively",
                        a[0], a[a.length - 1]));

        // print time taken for sort
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken to Sort : " + timeElapsed.toMillis() + " milliseconds");

        // return a;
        // Delete after implementation
        return a;
    }

}
