import java.util.Arrays;
import java.util.Random;

/**
 * @author Adrien Audouard
 * Binary Search Algorithm
 * https://en.wikipedia.org/wiki/Binary_search_algorithm
 */

public class BinarySearch {

    public static int binarySearch(int[] arr, int n, int value) {
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int middle = (end + start) / 2;

            if (arr[middle] == value) return middle;
            else if (arr[middle] < value) start = middle + 1;
            else end = middle - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 20;
        int[] arr = createArray(n);
        int s = randomSearchedValue(arr);

        printArray(arr);

        int i = binarySearch(arr, n, s);

        System.out.println(s);
        System.out.println(i);
    }

    public static int randomSearchedValue(int[] arr) {
        return arr[(int) (Math.random() * arr.length)];
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

        Arrays.sort(arr);

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
