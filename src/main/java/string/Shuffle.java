package string;
/**
 * You are given two things a string “S” and an Array “indices”. Array indices will contain index .
 * Now you have to shuffle the string s such that the character at ith index in string s is moved to indices[i]th position in the shuffle string.
 */

public class Shuffle {

    public static void main(String args[]) {
        int indexes [] = new int [] {2,4,5,0,1,3};
        String input = "MEDIUM";
        char charArray [] = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            while (i != indexes[i]) {
                swap(charArray, i, indexes[i]);   //swap(s[i],s[indices[i]]);
                swap(indexes, i, indexes[i]);    //swap(indices[i],indices[indices[i]]);
            }
        }

        System.out.println(String.valueOf(charArray));

    }

    private static void swap(char str[], int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    private static void swap(int str[], int i, int j) {
        int temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
