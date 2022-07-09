package string;

import java.util.HashMap;
import java.util.Map;

/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in
complexity O(n).

Example:
Input: S = “ADOBECODEBANC”, T = “ABC”
Output: “BANC”

Note:If there is no such window in S that covers all characters in T, return the empty string “”.
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

T never has string repetitions
*/
public class MinWindowSubstring {

    public static String getMinSubstring(String input, String uniqueString) {


        int uniqueCharCount = uniqueString.length();

        //Create a map of unique characters
        Map<Character, Integer> map = new HashMap<>();
        for ( int i = 0; i < uniqueString.length(); i++) {
            if ( map.get(uniqueString.charAt(i) ) == null) {
                map.put(uniqueString.charAt(i),0);
            }
        }


        int minX = 0;
        int minY = input.length()+1;


        int windowCount = 0;
        int start = 0;
        int end = 0;
        while ( end < input.length()) {
            if ( map.get(input.charAt(end)) != null ) {
                if ( map.get(input.charAt(end)) == 0) {
                    windowCount++;
                }
                map.put(input.charAt(end), map.get(input.charAt(end))+1);
            }
            if ( windowCount == uniqueCharCount) {
                if ( end - start == uniqueCharCount) { /** We have smallest window **/
                    return input.substring(start, end+1);
                } else {
                    while ( start < end) {//try to squeez the window
                        if (map.get(input.charAt(start)) == null) {
                            start++;
                        } else if ( map.get(input.charAt(start)) > 1) {
                            map.put(input.charAt(start),map.get(input.charAt(start))-1);
                            start++;
                        } else break;
                    }
                    if ( (end - start) < (minY - minX)) {
                        minY = end;
                        minX = start;
                    }
                    windowCount--;
                    if ( map.get(input.charAt(start)) > 0) {
                        map.put(input.charAt(start),map.get(input.charAt(start))-1);
                    }
                    start++;
                }
            }
            end++;
        }

        if ( minY > input.length()) return "<NO-SOLUTION>";
        else return input.substring(minX, minY+1);

    }

    public static void main(String args[]) {
        System.out.println(getMinSubstring("this is a test string","tig"));  //"tring"
        System.out.println(getMinSubstring("ADBCE","AE"));  //ADBCE
        System.out.println(getMinSubstring("ADBCE","ABC"));  //ADBC
        System.out.println(getMinSubstring("ADOBECODEBANC","ABC"));  //BANC
        System.out.println(getMinSubstring("a","a"));  //a
        System.out.println(getMinSubstring("a","aa"));  //""

        System.out.println(getMinSubstring("geeksforgeeks","ork"));  //"ksfor"
    }
}


