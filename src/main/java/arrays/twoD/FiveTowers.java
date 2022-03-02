package arrays.twoD;

import java.util.ArrayList;
import java.util.List;

public class FiveTowers {

    private static int M = 5;  //row
    private static int N = 5;  //col

    public static void buildTowers(int row, int columns[], List<int[]> solutionList) {
        if ( row == M ) {
            solutionList.add(columns.clone());
            return;
        }

        for (int col = 0; col < N; col++) {
            if ( isValidPos(row, col, columns)) {
                columns[row] = col;
                buildTowers(row+1, columns, solutionList);
            }
        }
    }

    private static boolean isValidPos(int row, int col, int columns[]) {
        for (int i = 0; i < row; i++) {
            int j = columns[i];

            if ( j == col) return false;

            int colDistance = Math.abs(j - col);
            int rowDistance = Math.abs(i  - row);
            if ( colDistance == rowDistance) return false;
        }
        return true;
    }


    public static void main(String args[]) {
        int columns[] = new int[M];

        List<int[]> solution = new ArrayList<int[]>();


        buildTowers(0, columns, solution);
        for (int [] sol : solution) {
            for (int i = 0; i < sol.length; i++) {
                System.out.print(i+"," + sol[i] + "              ");
            }
            System.out.println("-------------------------\n");
        }

    }
}
