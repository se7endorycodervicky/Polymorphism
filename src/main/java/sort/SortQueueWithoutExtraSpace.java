package sort;

import java.util.ArrayDeque;
import java.util.Queue;

public class SortQueueWithoutExtraSpace {

    public static void main (String args[]) {
        Queue queue = new ArrayDeque();
        queue.add(1);
        queue.add(9);
        queue.add(3);
        queue.add(5);
        queue.add(8);


        int swapCount = 0;
        int N = queue.size();
        int temp;

        while ( swapCount < N ) {
            swapCount  = 0;
            temp = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                int val = (Integer) queue.remove();
                if ( val > temp) {
                    if ( temp != Integer.MIN_VALUE) {
                        queue.add(temp);
                    }
                    temp = val;
                    swapCount++;
                } else {
                    queue.add(val);
                }
            }
            queue.add(temp);

        }


        for (int i = 0; i < N; i++) {
            System.out.print(" " + queue.remove());
        }

    }


}
