package tree;

public class Node {
    private int val;
    Node lptr = null;
    Node rptr = null;

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return this.val;
    }

    @Override
    public String toString() {
        return val+"";
    }

}
