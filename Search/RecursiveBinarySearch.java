import java.util.Arrays;
import java.util.Random;

/**
 * @author Adrien Audouard
 * Recursive Binary Search Algorithm
 * https://en.wikipedia.org/wiki/Binary_search_algorithm
 */


public class RecursiveBinarySearch {
    public static int recursiveBinarySearch(int[] arr, int n, int value) {
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int middle = (end + start) / 2;

            if (arr[middle] == value) return middle;
            else if (arr[middle] < value)
                return middle + recursiveBinarySearch(Arrays.copyOfRange(arr, middle, n  - 1), n - middle, value);
            else
                return recursiveBinarySearch(Arrays.copyOfRange(arr, 0, middle), middle + 1, value);
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 20;
        int[] arr = createArray(n);
        int s = randomSearchedValue(arr);

        printArray(arr);

        int i = recursiveBinarySearch(arr, n, s);

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
