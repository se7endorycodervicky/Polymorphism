package sort;

public class MergeTwoSortedArrays {

    public static void mergeArrays(int arr1[], int arr2[]) {
        int insertIndex = arr1.length-1;
        int arr1Index = 0;
        int arr2Index = arr2.length-1;
        for (int i = 0; i < arr1.length; i++) {
            if ( arr1[i] == -1) {
                arr1Index = i-1;
                break;
            }
        }

        while ( arr1Index >= 0 && arr2Index >=0 ) {
            if ( arr1[arr1Index] > arr2[arr2Index]) {
                arr1[insertIndex] = arr1[arr1Index];
                arr1Index--;
            } else {
                arr1[insertIndex] = arr2[arr2Index];
                arr2Index--;
            }
            insertIndex--;
        }

        if ( arr2Index >= 0 && insertIndex >= 0) {
            for (; insertIndex >=0; insertIndex--) {
                arr1[insertIndex] = arr2[arr2Index];
                arr2Index--;
            }
        }

    }

    public static void main(String args[]) {
        int [] arr1 = new int[] { 1,23,24, 29, 210, -1,-1,-1,-1,-1};
        int [] arr2 = new int[] {0,2,5,7,8,11};

        mergeArrays(arr1, arr2);
        for (int i = 0 ; i < arr1.length; i++ ) {
            System.out.print(" " + arr1[i]);
        }

    }
}
