package tree;

public class TreeCreator {

    public Node createTree(int arr[]) {
        if ( arr == null || arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            prev.rptr = node;
            prev = node;
        }

        return head;
    }


}
