package DoublyLinkedList;

public class DoublyLL {
    public static void main(String[] args) {

    }

    Node head = null, tail = null;
    public void push( int key ){

        Node new_node = new Node(key);
        if(head == null){

            head = tail =  new_node;
            head.prev = null;
            tail.next = null;

        }


    }
}

class Node{
    int data;
    Node next, prev;

    Node(int d){
        data = d;
    }
}
