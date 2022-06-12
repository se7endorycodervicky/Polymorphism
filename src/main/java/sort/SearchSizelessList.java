package sort;



public class SearchSizelessList {
    static class SizelessList {
        private final int[] arr;
        public SizelessList(int[] arr) {
            this.arr = arr.clone();
        }

        public int peekAt(int index) {
            if (index >= arr.length) {
                return -1;
            }
            return arr[index];
        }

    }

    public static int binarySearch(SizelessList list, int start, int end, int searchElement) {
        if ( end >= start ) {

            int mid =  start + (( end - start )/2);
            if (list.peekAt(mid) == searchElement) return mid;

            if (list.peekAt(mid) > searchElement) return binarySearch(list, start, mid-1, searchElement);
            else if (list.peekAt(mid) < searchElement) return binarySearch(list, mid + 1, end, searchElement);
        }
        return -1;
    }


    public static void main(String args[]) {
        int arr[] = new int[]{1,4,9,100,323,838, 999, 1023, 3183, 4413, 8932, 9099, 10233};
        SizelessList list  = new SizelessList(arr);
        int searchElement = 4413;

        int startScanIndex = 0;
        int endIndex = 1;
        while ( list.peekAt(endIndex) != -1 && list.peekAt(endIndex) < searchElement) {
            startScanIndex = endIndex;
            endIndex = endIndex * 2;
        }

        System.out.println("Search Element Index:  " + binarySearch(list, startScanIndex, endIndex, searchElement));
    }


}
