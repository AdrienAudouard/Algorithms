import java.util.Random;
import java.util.Scanner;

/**
 * @author Adrien Audouard
 * Insertion Algorithm
 * https://en.wikipedia.org/wiki/Insertion_sort
 */

public class InsertionSort {
    /**
     * Apply insertion sort on a array
     * @param n Size of the array
     * @param arr Array to sort
     */
    static void insertionSort(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                for (int j = i; j > 0; j--) {
                    if (arr[j] > arr[j - 1]) break;

                    int temp = arr[j];

                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = createArray(n);

        printArray(arr);

        insertionSort(n, arr);

        printArray(arr);
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
     * @param arr
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("");
    }
}
