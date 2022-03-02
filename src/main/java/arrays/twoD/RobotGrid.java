package arrays.twoD;

import java.util.ArrayList;
import java.util.List;

class Point {
    private int x;
    private int y;

     Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class RobotGrid {

    final static int M = 4;
    final static int N = 4;


    public static void main(String args[]) {
        List<Point> path = new ArrayList<Point>();

        new RobotGrid().getPath(M-1,N-1,path);
        for ( Point point : path) {
            System.out.println(">> " + point.getX() + "," + point.getY());
        }
    }

    public boolean getPath(int i, int j, List<Point> path) {
        if ( i < 0 || j < 0) return false;
        if ( (i == 0 && j == 0) || getPath(i,j-1,path) || getPath(i-1, j,path)) {
            path.add(new Point(i, j));
            return true;
        }
        return false;
    }
}
