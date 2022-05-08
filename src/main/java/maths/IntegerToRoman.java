package maths;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    static int [] intKeys = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    static String [] roman = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };

    private static int findHighestLowestIndex(int array[], int val, int prevLowestIndex) {
        int index = 0;
        int endIndex = ( prevLowestIndex < 0 ) ? array.length : prevLowestIndex;
        for (int i = 0; i < endIndex; i++) {
            if (  array[i] > val) break;
            index = i;
        }
        return ( index != 0 ) ? index : 0;
    }

    private static String getRoman(int val) {

        int multiplier = 1;
        Map<Integer, String> romanMapping = new HashMap<Integer, String>();
        for ( int i = 0; i < intKeys.length ; i++) {
            romanMapping.put(intKeys[i], roman[i]);
        }
        String output = "";
        while ( val != 0) {
            int rem = val % 10;
            int newVal = multiplier * rem;
            if (romanMapping.containsKey(newVal)) {
                output = romanMapping.get(newVal) + output;
            } else {
                String newOutput = "";
                int prevLowest = -1;
                while ( newVal  > 0) {
                    int lowestIndex = 0;
                    if (prevLowest >= 0) {
                        lowestIndex = findHighestLowestIndex(intKeys, newVal, -1);
                    } else {
                        lowestIndex = findHighestLowestIndex(intKeys, newVal, prevLowest);
                    }
                    int repeater = newVal / intKeys[lowestIndex];
                    for (int i = 0; i < repeater; i++) {
                        newOutput =  newOutput + romanMapping.get(intKeys[lowestIndex]) ;
                    }
                    newVal = newVal - (repeater * intKeys[lowestIndex]);
                }
                output = newOutput + output;
            }
            val = val / 10;
            multiplier = multiplier * 10;

        }

        return output;
    }

    public static void main(String args[]) {

        int input[]  = new int[] { 73, 558, 145, 34, 49 };

        for (int i = 0; i < input.length; i++) {
            System.out.println("\n " + input[i] + " => " + getRoman(input[i]));
        }
    }


}
