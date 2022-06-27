package tree;

public class Mirror {

    public boolean isMirror(Node node1, Node node2) {
        if ( node1 == null && node2 != null) return false;   
        if ( node1 != null && node2 == null) return false;
        if ( node1 == null && node2== null) return true;
        if (node1.getVal() != node2.getVal()) return false;

        return isMirror(node1.lptr, node2.rptr) && isMirror(node1.rptr, node2.lptr);
    }

    public static void main(String args[]) {
        Node node1 = new Node(1);
        node1.lptr= new Node(2);

        node1.rptr= new Node(3);
        node1.rptr.lptr = new Node(100);
        node1.rptr.rptr = new Node(200);

        Node node2  =  new Node(1);
        node2.lptr= new Node(3);
        node2.rptr= new Node(2);
        node2.lptr.rptr = new Node(100);
        node2.lptr.lptr = new Node(200);

        System.out.println(">>  " + new Mirror().isMirror(node1, node2));
    }
}
