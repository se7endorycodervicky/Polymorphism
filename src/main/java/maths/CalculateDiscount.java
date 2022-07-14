package maths;
/*
Problem: Given the array prices where prices[i] is the price of the i'th item in a shop.
There is a special discount for items in the shop, if you buy the i'th item,
then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i],
otherwise, you will not receive any discount at all.
 */

public class CalculateDiscount {

    public static void main(String args[]) {
        int price [] = new int [] {10,1,1,6};
        int finalPrice[] = new int[price.length];

        for (int i = 0; i < price.length; i++) {
            int j = i + 1;
            while ( j < price.length && price[j] > price[i]) {
                j++;
            }
            if ( j >= price.length) {
                finalPrice[i] = price[i];
            } else {
                finalPrice[i] = price[i] - price[j];
            }
        }

        for (int i = 0; i < finalPrice.length; i++) {
            System.out.print(" " + finalPrice[i]);
        }

    }
}
