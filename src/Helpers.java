import javax.swing.*;
import java.math.BigDecimal;
import java.util.Random;

public class Helpers {
    static int[] randomIntegers(int items, int min, int max) {
        Random rng = new Random();


        int[] arr = new int[items];

        for (int i = 0; i < items; i++) {
            arr[i] = Math.abs(rng.nextInt() % (max-min)) + min;
        }

        return arr;

    }

    public static void printArr(int[] arr){
        for (int var : arr) {
            System.out.print(var + " ");

        }
        System.out.println(" ");
    }

    public static double timeExecution(Runnable func){
        long startTime = System.nanoTime();
        func.run();
        long endTime = System.nanoTime();

        return (double)(endTime - startTime) / 1000000;
    }

    public static void RandomizeArray(int[] array){
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

    }

    static public void swap(int[] arr, int i, int j){
        int swapValue = arr[j];
        arr[j] = arr[i];
        arr[i] = swapValue;
    }
}
