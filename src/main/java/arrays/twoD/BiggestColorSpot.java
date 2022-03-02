package arrays.twoD;

public class BiggestColorSpot {

    static final int M = 6;
    static final int N = 6;

    static int maxColorCellCount = 0;
    static int maxColorCell = 0;
    static int colorCount = 0;

    public void getColorCount(int x, int y, int grid[][], int color) {
        if ( x >= M || y >= N || x < 0 || y < 0) return;

        if ( grid[x][y] < 0 || grid[x][y] != color) return;
        grid[x][y] *= -1;
        colorCount++;
        getColorCount(x-1, y, grid, color); //up
        getColorCount(x+1, y, grid, color); //down
        getColorCount(x, y-1, grid, color); //left
        getColorCount(x, y+1, grid, color); //right
    }

    public void calculateBiggestSpot(int grid[][]) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                colorCount = 0;
                if ( grid[i][j] < 0) continue;
                int thisColor = grid[i][j];
                getColorCount(i,j, grid, grid[i][j]);
                if ( colorCount > maxColorCellCount) {
                    maxColorCellCount = colorCount;
                    maxColorCell = thisColor;
                }
            }
        }
    }

    public static void main(String args[]) {
        int grid[][] = new int[M][N];
        grid[0] = new int[]{ 1, 4, 4, 4, 3, 3};
        grid[1] = new int[]{ 0, 4, 4, 4, 5, 3};
        grid[2] = new int[]{ 3, 4, 4, 1, 3, 3};
        grid[3] = new int[]{ 2, 3, 4, 1, 3, 8};
        grid[4] = new int[]{ 4, 2, 4, 1, 3, 8};
        grid[5] = new int[]{ 9, 1, 4, 3, 3, 9};

        new BiggestColorSpot().calculateBiggestSpot(grid);
        System.out.println("Bigger Color Code is: " + maxColorCell + " with adjacent cell count: " + maxColorCellCount);
    }
}
