package DoublyLinkedList;

public class DoublyLL {
    public static void main(String[] args) {

        DoublyLL d = new DoublyLL();

        d.push(12);
        d.push(1);
        d.push(14);
        d.push(-9);
        d.push(10);

        d.display();

    }

    Node head = null, tail = null;
    public void push( int key ){

        Node new_node = new Node(key);

        if(head == null){

            head = tail =  new_node;
            head.prev = null;
            tail.next = null;

        }

        else {

            new_node.prev = tail;
            tail.next = new_node;
            tail = new_node;
            tail.next = null;

        }
    }

    public void display(){

        Node temp = head;

        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
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
