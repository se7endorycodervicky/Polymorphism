package tree;
/*
Binary Tree Maximum Path Sum

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class MaximumPathSum {

    static int maxPathSum = 0;

    private static  int getMaxPathSum(Node node) {
        if ( node == null) return 0;


        int maxL = Math.max(getMaxPathSum(node.lptr), 0);
        int maxR = Math.max(getMaxPathSum(node.rptr), 0);

        int maxPath = node.getVal() + maxR + maxL;
        maxPathSum = Math.max(maxPathSum, maxPath);

        return node.getVal() + Math.max(maxR, maxL);

    }

    public static void main(String args[]) {
        Node root = new Node(-10);
        root.lptr = new Node(9);
        root.rptr = new Node(20);
        root.rptr.lptr = new Node(15);
        root.rptr.rptr = new Node(7);

        getMaxPathSum(root);

        System.out.println("Max Path Sum: " + maxPathSum);

    }

}
