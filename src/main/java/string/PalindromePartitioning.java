package string;

import java.util.Arrays;

/*
Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.

For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.

Determine the fewest cuts needed for a palindrome partitioning of a given string. For example, minimum of 3 cuts are needed for “ababbbabbababa”.

The three cuts are “a|babbbab|b|ababa”. If a string is a palindrome, then minimum 0 cuts are needed. If a string of length n containing all different characters, then minimum n-1 cuts are needed.

 */
public class PalindromePartitioning {

    public static boolean isPalindrome(String str, int i, int j) {
        while ( i < j) {
            if ( str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int recursionCuts(String str, int i , int j) {
        if ( isPalindrome(str, i, j) || i >= j) {
            return 0;
        }
        int maxCuts = Integer.MAX_VALUE;
        for (int k = i;  k < j; k++) {
            int cuts = recursionCuts(str, i, k) + recursionCuts(str, k+1, j) + 1;
            maxCuts = Math.min(maxCuts, cuts);
        }
        return maxCuts;

    }

    public static int dpCuts(String str, int i, int j, int [][]dp) {
        if ( isPalindrome(str, i, j) || i >= j) {
            dp[i][j] = 0;
            return  dp[i][j];
        }

        if ( dp[i][j] != -1)
            return  dp[i][j];//revisit resolved

        int maxCuts = Integer.MAX_VALUE;

        for (int k = i;  k < j; k++) {
            int cuts = dpCuts(str, i, k, dp) + dpCuts(str, k+1, j, dp) + 1;
            maxCuts = Math.min(maxCuts, cuts);
        }

        dp[i][j] = maxCuts;

        return dp[i][j];
    }



    public static void main(String args[]) {
        String input = "ababbbabbababa";

        System.out.println("Recursion Cuts: " + recursionCuts(input, 0, input.length()-1));


        int n = input.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("DP Cuts: " + dpCuts(input, 0, n - 1, dp));
    }
}
