package arrays.twoD;

public class RobotGridAllPaths {
    final static int M = 4;
    final static int N = 4;

    public static void main(String args[]) {
        int pathCount [][]= new int[M][N];

        System.out.println("Path Count: " + new RobotGridAllPaths().getPathCount(M-1, N-1, pathCount));
    }

    public int getPathCount(int i, int j,int pathCount[][]) {
        if ( i < 0 || j < 0 ) return 0;

        if ( i == 0 && j == 0 ) return 1;

        pathCount[i][j] = getPathCount(i-1, j, pathCount) +
                getPathCount(i,j-1, pathCount) ;

        return pathCount[i][j];
    }

}

