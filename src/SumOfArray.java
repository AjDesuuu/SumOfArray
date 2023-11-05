import java.util.*;

public class SumOfArray {

    public static void main(String[] args){

        Scanner console = new Scanner(System.in);
        System.out.print("Enter S: ");
        int s = console.nextInt();
        boolean isPossible= false;
        int max = 20;
        int min = -20;
        int range = max - min + 1;

        int[] sum = new int[5];

        HeapSort heapSort = new HeapSort();

        System.out.print("\n[");
        for(int i=0; i< sum.length;i++){
            sum[i] = (int)(Math.random() * range + min);
            System.out.print(sum[i]+",");
        }

        System.out.print("]");
        //QuickSort.Sort(sum, 0, sum.length-1);
        heapSort.Sort(sum);

        System.out.print("\n[");
        for(int i=0; i< sum.length;i++){
            System.out.print(sum[i]+",");
        }
        System.out.print("]");

        int left = 0;
        int right = sum.length - 1;

        while (left < right) {
            int currentSum = sum[left] + sum[right];
            if (currentSum == s) {
                isPossible = true;
                break;
            } else if (currentSum < s) {
                left++;
            } else {
                right--;
            }
        }

        System.out.print("\nS: " );
        if(isPossible)
            System.out.print("yes");
        else
            System.out.print("no");


    }


}
class QuickSort{

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void Sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            Sort(arr, low, pi - 1);
            Sort(arr, pi + 1, high);
        }
    }

}

class HeapSort {
    public void Sort(int arr[]) {
        int N = arr.length;

        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        for (int i = N - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;


            heapify(arr, i, 0);
        }
    }


    void heapify(int arr[], int N, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;


        if (l < N && arr[l] > arr[largest])
            largest = l;

        if (r < N && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;


            heapify(arr, N, largest);
        }
    }
}