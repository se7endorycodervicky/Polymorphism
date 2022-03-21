package sort;

public class HeapSort {

    public void sort(int arr[]) {

        for (int i = 0; i < arr.length /2; i++) {
            heapify(arr, arr.length, i);
        }

        //As this is max heap...remove from end
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, i, 0);
        }


    }

    public void heapify(int arr[], int n, int i ) {
        int largest = i;
        int left = 2*i +1;
        int right = 2*i + 2;

        if ( left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if  ( right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if ( largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n,largest);
        }

    }



    public static void main(String args[])  {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        new HeapSort().sort(arr);
        for (int i  = 0; i < arr.length; i++) {
            System.out.print("  " +  arr[i]);
        }
    }

}
