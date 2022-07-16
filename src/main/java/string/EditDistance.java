package string;
/*
Given two strings str1 and str2 and below operations that can be performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

Insert
Remove
Replace
 */

public class EditDistance {

    public static int dynamicProgramming(String source, String target) {
        int array [][] = new int[source.length()][target.length()];

        for (int i = 0; i < source.length(); i++) {
            for (int j = 0; j < target.length() ; j++) {
                if  ( i == 0)
                    array[i][j] = j;
                else if  ( j == 0 )
                    array[i][j] = j;
                else if ( source.charAt(i-1) == target.charAt(j-1))
                    array[i][j] = array[i-1][j-1];
                else {
                    array[i][j] = 1 + Math.min( array[i-1][j], Math.min(array[i][j-1], array[i-1][j-1]));
                }
            }
        }
        return array[source.length()-1][target.length()-1];
    }

    public static int recursion(String source, String target, int i, int j) {
        if  ( i == 0 )  //source has reached end...now need target length to change the source
            return j;

        if ( j ==  0) //target has reached the end, so need source length to be removed
            return i;

        if ( source.charAt(i) == target.charAt(j)) {
            return recursion(source, target, i-1, j-1);
        }

        return 1 + Math.min(recursion(source, target, i, j-1),
                       Math.min(recursion(source, target, i-1, j),
                       recursion(source, target, i-1, j-1)));


    }




    public static void main(String args[]) {
        String source =  "sunday";
        String target =  "saturday";

        System.out.println(recursion(source, target, source.length()-1, target.length()-1));

        System.out.println(dynamicProgramming(source, target));

    }
}
