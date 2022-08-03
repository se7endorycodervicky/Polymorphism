package tree;

public class MinimumCameras {

    static int EDGE_NODE  = 0;
    static int CAMERA_NODE = 1;
    static int NULL_NODE = 2;


    static int cameraCount = 0;

    public static int minCameraCover(Node root) {

        if ( dfs(root) == EDGE_NODE ) {   //to handle returned note type
            return 1 + cameraCount;
        } else {
            return cameraCount;
        }
    }


    public static int dfs(Node root) {
        if (root == null) {
            return  NULL_NODE;
        }

        int left = dfs(root.lptr);
        int right = dfs(root.rptr);

        if (left == EDGE_NODE || right == EDGE_NODE ) {
            cameraCount++;
            return CAMERA_NODE;
        } else if ( left == CAMERA_NODE || right == CAMERA_NODE ) {
            return NULL_NODE;
        } else {
            return EDGE_NODE;
        }

    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.lptr = new Node(2);
        root.lptr.lptr = new Node(3);
        root.lptr.lptr.lptr = new Node(4);
        root.lptr.lptr.lptr.lptr = new Node(5);


        minCameraCover(root);

        System.out.println("Min Camera : " + cameraCount);

    }
}
