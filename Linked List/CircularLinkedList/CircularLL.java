package CircularLinkedList;
public class CircularLL {
    public static void main(String[] args) {

        CircularLL cll = new CircularLL();

        cll.add(12);
        cll.add(32);
        cll.add(45);
        cll.add(0);
        cll.add(1);

        cll.InsertAfter(cll.head.next.next.next, 100 );

        cll.display();

    }

    Node head = null, tail = null;

    public void add(int data){
        Node new_node = new Node(data);

        if (head == null) {

            head = new_node;
            tail = new_node;
            new_node.next = head;

        }

        else {

            tail.next = new_node; //tail will point to new node
            tail = new_node; // the new node will become the new tail
            new_node.next = head; // the tail (new node) will point to the head since circular;

        }

    }

    public void InsertAfter(Node prev_node, int key){

        Node new_node = new Node(key);
        new_node.next = prev_node.next;
        prev_node.next = new_node;

    }

    public void display(){
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }while (temp != head);
    }

}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }

}
