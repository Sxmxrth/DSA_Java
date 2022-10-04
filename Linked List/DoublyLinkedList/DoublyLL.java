package DoublyLinkedList;

public class DoublyLL {
    public static void main(String[] args) {

        DoublyLL d = new DoublyLL();

        d.push(12);
        d.push(1);
        d.push(14);
        d.push(-9);
        d.push(10);

        //d.InsertAfter(null, 100);

        d.Delete(-9);
        d.Delete(12);

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

    public void InsertAfter(Node prev_node, int key){

        Node new_node = new Node(key);

        if( prev_node == null ) {

            new_node.next = head;
            head.prev = new_node;
            head = new_node;
            return;

        }

        else if(prev_node.next == null){

            new_node.prev = prev_node;
            prev_node.next = new_node;
            new_node.next = null;
            tail = new_node;
            return;

        }


        new_node.next = prev_node.next;
        new_node.prev = prev_node.next.prev;
        prev_node.next.prev = new_node;
        prev_node.next = new_node;

    }

    public void Delete(int key){

        Node temp = head;
        while ( temp != null && temp.data != key){
            temp = temp.next;
        }

        if(temp.next == null){

            temp.prev.next = null;
            tail = temp.prev;
            return;
        }
        else if (temp.prev == null) {

            temp.next.prev = null;
            head = temp.next;
            return;

        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

    }

    public void RemoveDup(){
        Node temp = head;
        Node pointer = temp.next;

        while ( temp != null ){

            while( pointer != null ) {

                if (temp.data == pointer.data){

                    if(pointer.next == null){
                        pointer.prev.next = null;
                        tail = pointer.prev;
                        return;
                    }

                    pointer.prev.next = pointer.next;
                    pointer.next.prev = pointer.prev;
                    pointer = pointer.next;

                }
                else {
                    pointer = pointer.next;
                }

            }

            temp = temp.next;
            pointer = temp.next;

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
