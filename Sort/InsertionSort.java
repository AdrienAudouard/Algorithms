import java.util.Scanner;

public class InsertionSort {
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

            printArray(arr);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        insertionSort(n, arr);
        in.close();
    }


    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("");
    }
}
