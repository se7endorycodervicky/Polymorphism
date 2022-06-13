package sort;

public class MergeSort {

    public static void merge(int arr[],final  int start, final int mid, final int end) {
        int temp [] = new int[end-start+1];

        int left = start;
        int right = mid+1;
        int insertIndex = 0;

        while ( left <= mid && right <= end ) {
            if ( arr[left] < arr[right]) {
                temp[insertIndex++] = arr[left];
                left++;
            } else {
                temp[insertIndex++] = arr[right];
                right++;
            }
        }

        for (; left <= mid; left++) {
            temp[insertIndex++] = arr[left];
        }
        for (; right <= end; right++) {
            temp[insertIndex++] = arr[right];

        }

        insertIndex = 0;
        for (int i = start; i <= end;i++) {
            arr[i] = temp[insertIndex++];
        }


    }

    public static void sort(int arr[], int start, int end) {
        if ( start >= end) return;

        int mid = ( start + end) / 2;
        sort(arr, start, mid);
        sort(arr, mid+1, end);

        merge(arr, start, mid, end);
    }

    public static void main(String args[] ) {
        int arr[] = new int[] { 0,1,4,234,23,11,0,13,2244};

        sort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }

    }
}
