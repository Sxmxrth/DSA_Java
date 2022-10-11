public class BinaryTree {
    public static void main(String[] args) {

        BinaryTree b = new BinaryTree();
        Node root = new Node(5);

        b.insert(root, 4);
        b.insert(root, 23);
        b.insert(root, 2);
        b.insert(root, 8);
        b.insert(root, 6);
        b.insert(root, 7);
        b.insert(root, 3);
        b.insert(root, 9);

        b.InOrder(root);

        System.out.println(b.search(root, 12));

        b.findMin(root);

        b.findMax(root);



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

    public Node search(Node root, int target){

        if(root == null || root.key == target){
            return root;
        }

        if (root.key < target) {
            return search(root.right, target);
        }

        return search(root.left, target);

    }

    public void findMin(Node root){

        if(root.left == null){
            System.out.println("Min is " + root.key);
        }

        else {
            findMin(root.left);
        }
    }

    public void findMax(Node root){

        if (root.right == null){
            System.out.println("Max is " + root.key);
        }

        else {
            findMax(root.right);
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
