//package hackerrank;
//public class BSTLowestCommonAncestor
//{
//    public static Node getMinNode(Node node,int v1,int v2, Node minValueNode){
//        Node tempNode;
//        Node tempNode1;
//        Node tempNode2;
//        if(node.data<=v2 && node.data>=v1 )
//        {
//            tempNode1=getMinNode(node.left)
//            tempNode=
//        }
//    }
//    public static Node lca(Node root, int v1, int v2) {
//
//    }
//
//    public static Node insert(Node root, int data) {
//        if(root == null) {
//            return new Node(data);
//        } else {
//            Node cur;
//            if(data <= root.data) {
//                cur = insert(root.left, data);
//                root.left = cur;
//            } else {
//                cur = insert(root.right, data);
//                root.right = cur;
//            }
//            return root;
//        }
//    }
//}
//class Node {
//    Node left;
//    Node right;
//    int data;
//
//    Node(int data) {
//        this.data = data;
//        left = null;
//        right = null;
//    }
//}
