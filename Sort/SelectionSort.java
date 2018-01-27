import java.util.Random;
import java.util.Scanner;

/**
 * @author Adrien Audouard
 * Selection Sort Algorithm
 * https://en.wikipedia.org/wiki/Selection_sort
 */

public class SelectionSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = createArray(n);

        printArray(arr);

        selectionSort(n, arr);

        printArray(arr);
    }

    /**
     * Apply the selection sort on an array
     * @param n Size of the array
     * @param arr Array to sort
     */
    public static void selectionSort(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j]) min = j;
            }

            if (min != i) swap(arr, i , min);
        }
    }

    /**
     * Switch two values in an array
     * @param arr Array that contains the value
     * @param a Index of the first value
     * @param b Index of the second value
     */
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * Create an array with random int between [-100 ; 100[
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
     * @param arr
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("");
    }
}
