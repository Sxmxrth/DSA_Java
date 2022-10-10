public class BinaryTree {
    public static void main(String[] args) {

        BinaryTree b = new BinaryTree();
        Node root = new Node(5);

        b.insert(root, 1);
        b.insert(root, 4);
        b.insert(root, 2);
        b.insert(root, 8);
        b.insert(root, 6);
        b.insert(root, 7);
        b.insert(root, 3);
        b.insert(root, 9);

        b.InOrder(root);

    }

    public void insert(Node node, int value){

        if(value < node.key){
            if(node.left != null){
                insert(node.left, value);
            }
            else {
                node.left = new Node(value);
            }
        }

        else if (value > node.key) {
            if (node.right != null){
                insert(node.right, value);
            }
            else{
                node.right = new Node(value);
            }
        }

    }

    public void InOrder(Node node){
        if(node != null){
            InOrder(node.left);
            System.out.println(node.key + " ");
            InOrder(node.right);
        }
    }

}

class Node{
    int key;
    Node left, right;

    Node(int d){
        key = d;
        left = right = null;
    }
}
