package sort;

public class BinarySearch {

    public static int search(int arr[], int start, int end, int searchElement) {
        if (end >= start) {

            int mid = start + ((end - start) / 2);
            if (arr[mid] == searchElement) return mid;

            if (arr[mid] > searchElement) return search(arr, start, mid - 1, searchElement);
            else if (arr[mid] < searchElement) return search(arr, mid + 1, end, searchElement);
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = new int[]{1, 4, 9, 100, 323, 838, 999, 1023, 3183, 4413, 8932, 9099, 10233};

        System.out.println("Binary Search: " + search(arr, 0, arr.length, 323));
    }
}
