public class SingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedList ll = new SingleLinkedList();

        ll.push(4);
        ll.push(5);
        ll.push(2);
        ll.push(1);
        ll.push(9);
        ll.push(12);
        ll.push(-4);

        ll.InsertAfter(ll.head.next.next, 14);
        ll.append(25);
        System.out.println("the number of elements in the linked list are " + ll.getCount());

        ll.printList();
        System.out.println();

        ll.deleteNode(4);
        ll.deleteNode(25);
        ll.printList();

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

    public void InsertAfter(Node prev_node, int new_data){

        if(prev_node == null){
            System.out.println("the prev node cannot be null");
            return;
        }

        Node new_node = new Node(new_data);
        new_node.next = prev_node.next; // the new node gets the address of the next node which the prev node was pointing to.
        prev_node.next = new_node; // the prev node now points to the new node made.

    }

    public void append(int new_data){

        Node last = head;
        while (last.next != null){
            last = last.next;
        }

        Node new_node = new Node(new_data);
        new_node.next = null;
        last.next = new_node;

    }

    public void deleteNode(int key){

        Node temp = head, prev = null;

        if(temp.data == key){
            head = temp.next;
            return;
        }

        while(temp.data != key){
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;
    }

    public boolean SearchInLL(int key){
        Node temp = head;
        while (temp.data != key && temp.next != null){
            temp = temp.next;
        }
        return temp.data == key;
    }

    public void printList(){

        Node tnode = head;
        while (tnode != null){
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }

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