package arrays.twoD;

public class NCents {

    public static int compute(int amount, int coins[], int coinPosition, int cache[][]) {

        if ( coinPosition >= coins.length ) {
            return (amount == 0) ? 1 : 0;
        }

        if ( cache[amount][coinPosition] >= 0) {
            return cache[amount][coinPosition];
        }

        int count = 0;
        int coinValue = coins[coinPosition];

        for (int i = 0; ( i * coinValue) <= amount; i++) {
            int remAmount = amount - ( i * coinValue);
            count += compute(remAmount,coins,coinPosition+1, cache);
        }
        cache[amount][coinPosition] = count;
        return count;
    }

    public static void main(String args[]) {
        int X = 50;
        int coins[] = new int[]{25,10,5,1};
        int cache[][] = new int[X+1][coins.length];
        for(int  i = 0;i < X+1; i++) {
            for(int  j = 0;j <coins.length; j++) {
                cache[i][j] = -1;
            }
        }

        System.out.println("Count : " + compute(50,coins, 0, cache));

    }
}
