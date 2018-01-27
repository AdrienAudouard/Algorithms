import java.util.Random;
import java.util.Scanner;

/**
 * @author Adrien Audouard
 * QuickSort Algorithm
 * https://en.wikipedia.org/wiki/Quicksort
 */

public class QuickSort {
    /**
     * Apply Quick sort between start and end on an array
     * @param arr Array to be sort
     * @param start
     * @param end
     */
    static void sort(int[] arr, int start, int end) {
        if (start >= end) return;

        final int pivot = arr[start];

        int left = start;
        int right = end;

        while(true) {
            while(arr[right] > pivot) {
                right--;
            }

            while (arr[left] < pivot) {
                left++;
            }

            if (left < right) {
                switchValue(arr, left, right);
            } else break;
        }

        sort(arr, start, right);
        sort(arr, right + 1, end);

    }

    /**
     * Switch two values in an array
     * @param arr Array that contains the value
     * @param a Index of the first value
     * @param b Index of the second value
     */
    static void switchValue(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * Apply QuickSort on an array
     * @param arr array to sort
     * @return Sorted array
     */
    static int[] quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);

        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = createArray(n);

        in.close();

        printArray(arr);

        int[] result = quickSort(arr);

        printArray(result);
    }

    /**
     * Create an array with random int between [Ø ; 100[
     * @param n Size of the array
     * @return Array created
     */
    public static int[] createArray(int n) {
        int[] arr = new int[n];

        Random r = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt() % 100;
        }

        return arr;
    }

    /**
     * Print an array
     * @param arr Array to print
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("");
    }
}
