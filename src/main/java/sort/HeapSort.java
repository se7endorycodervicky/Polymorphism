package sort;

/**
This program can be used for following. Below code will implement a max. heap

1. Sort an array using heap sort
2. Find Kth minimum from an array
**/
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

        //For Kth's element from min heap
        /*
        for (int i = K /2 -1 ; i >= 0; i--) {
            heapify(arr, K, i);        
        }

        for (int i = K;  i < arr.length; i++) {
            if ( arr[i] > arr[0]) {
                arr[0] = arr[i];
                heapify(arr, K, 0);
            }
        }
        */

    }

    public void heapify(int arr[], int n, int i ) {
        int largest = i;                  
        int left = 2*i +1;
        int right = 2*i + 2;

        if ( left < n && arr[left] > arr[largest]) {      //for min heap, check for minimum
            largest = left;
        }

        if  ( right < n && arr[right] > arr[largest]) {    //for min heap, check for minimum
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
        //if we want to get Kth minimum, access arr[k]
    }

}
