package tree;

public class Flatten {
    Node last = null;

    public void preOrder(Node node) {
        if ( node == null && last == null ) return;

        if ( node.lptr == null && node.rptr == null) {
            last  = node;
            return;
        }

        Node right = node.rptr;;
        if ( node.lptr != null ) {
            node.rptr = node.lptr;
            node.lptr = null;
            preOrder(node.rptr);
        }
        if ( last != null) {
            last.rptr = right;
            last.lptr = null;
            last = null;
        }  
        preOrder(right);

    }


    public static void main(String args[]) {
        Node tree = createTree();

        new Traversal().InOrder(tree);

        new Flatten().preOrder(tree);
        System.out.println("\n");
        Node tmp = tree;
        while ( tmp != null) {
            System.out.print(" " + tmp.getVal());
            tmp = tmp.rptr;
        }

    }

    private static Node createTree() {
        Node tree = new Node(1);
        tree.lptr = new Node(10);
        tree.rptr = new Node(3);

        tree.rptr.rptr = new Node(5);
        tree.rptr.rptr.lptr  = new Node(11);
        tree.rptr.rptr.rptr = new Node(12);
        tree.rptr.rptr.rptr.rptr = new Node(13);
        tree.rptr.rptr.rptr.rptr.rptr = new Node(14);
        tree.rptr.rptr.rptr.rptr.rptr.lptr = new Node(15);

        return tree;
    }


}
