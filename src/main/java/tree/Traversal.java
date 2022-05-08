package tree;

public class Traversal {

    public void InOrder(Node node) {
        if ( node == null) return;
        InOrder(node.lptr);
        System.out.print(" " + node.getVal());
        InOrder(node.rptr);
    }


    public static void main(String args[]) {
        int arr[] = new int[] {1,2,3,4,5,6};
        System.out.println("\n");
        Node head = new TreeCreator().createTree(arr);
        Traversal traversal = new Traversal();
        traversal.InOrder(head);
    }

}
