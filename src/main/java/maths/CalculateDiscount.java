package maths;

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
