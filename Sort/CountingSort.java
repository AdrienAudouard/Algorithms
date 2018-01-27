import java.util.Random;
import java.util.Scanner;

/**
 * @author Adrien Audouard
 * Counting Sort Algorithm
 * https://en.wikipedia.org/wiki/Counting_sort
 */


public class CountingSort {

    /**
     * Apply the counting sort on an array
     * @param arr Array to sort
     * @return Sorted Array
     */
    static int[] countingSort(int[] arr) {
        int[] minMax = findMinMax(arr);

        int[] count = new int[minMax[1] - minMax[0] + 1];
        int[] sortArr = new int[arr.length];

        for (int i : arr) {
            count[i - minMax[0]] ++;
        }

        int k = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;

            for (int j = 0; j < count[i]; j++) {
                sortArr[k] = i + minMax[0];
                k++;
            }
        }

        return sortArr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = createArray(n);

        printArray(arr);

        int[] result = countingSort(arr);

        printArray(result);

        in.close();
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

    /**
     * Find the max and the min in a array
     * @param arr Array where to find
     * @return Array containing the max and the min
     */
    public static int[] findMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int i : arr) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        return new int[]{min, max};
    }
}
