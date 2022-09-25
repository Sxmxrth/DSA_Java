public class LinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.push(4);
        ll.push(5);
        ll.push(2);
        ll.push(1);
        ll.push(9);
        ll.push(12);
        ll.push(-4);

        System.out.println("the number of elements in the linked list are " + ll.getCount());

    }

    Node head;
    // to push an element in the front of the linked list*******
    public void push(int data){
        Node new_node = new Node(data); //gives the data to the new node built.
        new_node.next = head; // the next of the new node gets the value of the head.
        head = new_node; // the head gets the address of the new node.
    }

    public int getCount(){
        Node temp = head;
        int count = 0;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
}

class Node{
    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
}