public class BinaryTree {
    public static void main(String[] args) {

        BinaryTree b = new BinaryTree();
        Nodes root = new Nodes(5);

        b.insert(root, 4);
        b.insert(root, 23);
        b.insert(root, 2);
        b.insert(root, 8);
        b.insert(root, 6);
        b.insert(root, 7);
        b.insert(root, 3);
        b.insert(root, 9);

        b.InOrder(root);
        System.out.println();

        System.out.println(b.search(root, 12));

        b.findMin(root);

        b.findMax(root);

        b.predecessor(root, 5);
        b.successor(root, 6);

    }

    public void insert(Nodes node, int value){

        if(value < node.key){
            if(node.left != null){
                insert(node.left, value);
            }
            else {
                node.left = new Nodes(value);
            }
        }

        else if (value > node.key) {
            if (node.right != null){
                insert(node.right, value);
            }
            else{
                node.right = new Nodes(value);
            }
        }

    }

    public Nodes search(Nodes root, int target){

        if(root == null || root.key == target){
            return root;
        }

        if (root.key < target) {
            return search(root.right, target);
        }

        return search(root.left, target);

    }

    public void findMin(Nodes root){

        if(root.left == null){
            System.out.println("Min is " + root.key);
        }

        else {
            findMin(root.left);
        }
    }

    public void findMax(Nodes root){

        if (root.right == null){
            System.out.println("Max is " + root.key);
        }

        else {
            findMax(root.right);
        }

    }

    public void predecessor(Nodes root, int target){

        if (root == null){
            return;
        }

        else if(root.key == target){
            Nodes temp = root.left;
            if (temp == null){
                System.out.println("there is no predecessor");
                return;
            }
            while (temp.right != null){
                temp = temp.right;
            }

            System.out.println(temp.key);
        }

        if(root.key > target){
            predecessor(root.left, target);
        }

        else {
            predecessor(root.right, target);
        }

    }

    public void successor(Nodes root, int target){

        if (root == null){
            return;
        }

        if (root.key > target){
            successor(root.left, target);
        }

        else if (root.key < target) {
            successor(root.right, target);
        }

        if(root.key == target){

            Nodes temp = root.right;
            if (temp == null){
                System.out.println("there is no predecessor");
                return;
            }
            while (temp.left != null){
                temp = temp.left;
            }

            System.out.println(temp.key);

        }


    }

    public void InOrder(Nodes node){
        if(node != null){
            InOrder(node.left);
            System.out.print(node.key + " ");
            InOrder(node.right);
        }
    }

}

class Nodes{
    int key;
    Nodes left, right, parent;

    Nodes(int d){
        key = d;
        left = right = null;
    }
}
