public class AVL {
    public static void main(String[] args) {

        AVL a = new AVL();
        AVLNode root = new AVLNode(5);
//        System.out.println(a.height(root));
        a.insertNode(root,12);
        a.insertNode(root,1);
        a.insertNode(root,23);
        a.insertNode(root,9);
        a.insertNode(root,2);
        a.insertNode(root,52);

        a.inOrder(root);



    }

    public int height(AVLNode node){

        if(node == null){
            return 0;
        }
        int ldepth = height(node.left);
        int rdepth = height(node.right);

        return (ldepth > rdepth) ? ldepth + 1 : rdepth + 1;
    }

    public int balanceFactor(AVLNode node){

        return height(node.left) - height(node.right);

    }

    public void insertNode(AVLNode root, int key){

        if( key < root.data ){
            if(root.left != null){
                insertNode(root.left, key);
            }
            else {
                root.left = new AVLNode(key);
            }

        }

        else if (key > root.data) {
            if(root.right != null){
                insertNode(root.right, key);
            }
            else {
                root.right = new AVLNode(key);
            }

        }

    }

    public void inOrder(AVLNode node){

        if(node != null){

            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);

        }

    }

}

class AVLNode{
    AVLNode left, right;
    int data, h;

    AVLNode(int d){

        data = d;
        h = 0;
        left = right = null;

    }
}