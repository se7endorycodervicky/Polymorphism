package string;
/*
Suppose a string S is given and a regular expression R, write a function to check whether a string S matches a regular expression R.
Assume that S contains only letters and numbers.

A regular expression consists of:

Letters A-Z
Numbers 0-9
'*': Matches 0 or more characters
'.': Matches one character
 */

public class RegExMatching {

    //O(mxn) time
    public static boolean crudeRegEx(String str, String pattern) {

        for (int i = 0; i < str.length(); i++) {
            int patIndex = 0;
            int strIndex = i;
            boolean abort = false;
            //Initialize two pointers

            while (patIndex < pattern.length() && strIndex < str.length()) {
                //For pattern as '.' or exact match, increment pointer on both strings
                if (pattern.charAt(patIndex) == '.' || pattern.charAt(patIndex) == str.charAt(strIndex)) {
                    patIndex++;
                    strIndex++;
                } else if (pattern.charAt(patIndex) == '*') {
                    //For pattern as '*' move index to next character on str and pattern

                    //Find next character in pattern which is not .
                    if (patIndex + 1 == pattern.length()) {
                        return true; //last * will match everything
                    }
                    patIndex++;
                    int dotCount = 0;
                    while (patIndex < pattern.length() && pattern.charAt(patIndex) < 'a' && pattern.charAt(patIndex) > 'z') {
                        if (pattern.charAt(patIndex) == '.') {
                            dotCount++;
                        }
                        patIndex++;
                    }
                    if (patIndex >= pattern.length()) {
                        abort = true;
                        break;
                    }

                    //Find next char in string untill it matches pattern
                    while (strIndex < str.length() && str.charAt(strIndex) != pattern.charAt(patIndex)) {
                        strIndex++;
                        dotCount--;
                    }
                    if (dotCount > 0) {
                        abort = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            //If both the strings have ended then it matches
            if (!abort && patIndex == pattern.length() && strIndex == str.length()) return true;

            //If string has ended and patten last character is * than it matches
            if (!abort && strIndex == str.length() && patIndex + 1 == pattern.length() && pattern.charAt(patIndex) == '*')
                return true;
        }
        return false;
    }

    public static void main(String args[]) {
        System.out.println(RegExMatching.crudeRegEx("greats", "g...t*"));  //true
        System.out.println(RegExMatching.crudeRegEx("aabbbac", ".*a*"));   //true
        System.out.println(RegExMatching.crudeRegEx("aabbbac", "a*b*c*"));   //true
        System.out.println(RegExMatching.crudeRegEx("aabbbac", "a*b*c."));   //false
        System.out.println(RegExMatching.crudeRegEx("aabbbac", "a*c*b"));   //false
        System.out.println(RegExMatching.crudeRegEx("starxwing", "s.*r*g"));   //true
        System.out.println(RegExMatching.crudeRegEx("starxwing", "s.*r*n"));   //false
        System.out.println(RegExMatching.crudeRegEx("starxwing", "s.*r*n."));   //true
    }
}