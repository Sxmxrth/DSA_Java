public class LinkedList {
    public static void main(String[] args) {

    }
}

class LL{
    Node head, tail;
    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
