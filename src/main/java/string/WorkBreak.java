package string;

/*
Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words.

Examples:
{ i, like, sam, sung, samsung, mobile, ice, cream, icecream, man, go, mango}

Input:  ilike

Output: Yes
The string can be segmented as "i like".

Input:  ilikesamsung

Output: Yes
The string can be segmented as "i like samsung"  or "i like sam sung".
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WorkBreak {

    static class Range {
        int start;
        int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + " - " + end;
        }
    }
    public static List<Range> checkDictionary(List<String> dict, String input) {

        List<Range> words = new LinkedList<>();

        int start = 0;
        int end = 0;
        boolean resolved = false;
        while ( end <= input.length()) {
            if ( dict.contains(input.substring(start, end))) {
                words.add(new Range(start,end));
                if ( end+1 > input.length()) {
                    resolved = true;
                    break;
                }
                start = end;
            }

            if ( end+1 > input.length() && words.size() > 0) { //we couldn't match the string..so go back to earlier range
                Range range = words.remove(words.size()-1);
                start = range.start;
                end = range.end;
            }
            end++;
        }

        if ( resolved )
            return words;
        else
            return new ArrayList<>();

    }


    public static void main(String args[]) {
        List<String> dict = Arrays.asList(new String []{ "mobile", "samsung",  "sam",  "sung", "man",   "mango",  "icecream", "and",  "go",   "i",  "like",   "ice",      "cream" });  //i like sam sung
        String input = "ilikesamsung";
        List<Range> result = checkDictionary(dict, input);
        for (Range range : result) {
            System.out.print( input.substring(range.start, range.end) + " ");
        }

        System.out.println("\n");

        dict = Arrays.asList(new String []{ "mobile", "samsung",  "sam", "man",   "mango",  "icecream", "and",  "go",   "i",  "like",   "ice",      "cream" });   //i like samsung
        input = "ilikesamsung";
        result = checkDictionary(dict, input);
        for (Range range : result) {
            System.out.print( input.substring(range.start, range.end) + " ");
        }



        System.out.println("\n");

        dict = Arrays.asList(new String []{"cat","cats","and","sand","dog" });  //cat sand dog

        input = "catsanddog";
        result = checkDictionary(dict, input);
        for (Range range : result) {
            System.out.print( input.substring(range.start, range.end) + " ");
        }

        System.out.println("\n");

        dict = Arrays.asList(new String []{"apple","pen","applepen","pine","pineapple" }); //pine apple pen apple
        input = "pineapplepenapple";
        result = checkDictionary(dict, input);
        for (Range range : result) {
            System.out.print( input.substring(range.start, range.end) + " ");
        }

        System.out.println("\n");

        dict = Arrays.asList(new String []{"cats","dog","sand","and","cat" });    // NO-RESULT
        input = "catsandog";
        result = checkDictionary(dict, input);
        for (Range range : result) {
            System.out.print( input.substring(range.start, range.end) + " ");
        }

     }


}
