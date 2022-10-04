package DoublyLinkedList;

public class RemoveDuplicates {
    public static void main(String[] args) {

        DoublyLL dll = new DoublyLL();
        dll.push(12);
        dll.push(1);
        dll.push(1);
        dll.push(1);
        dll.push(16);
        dll.push(1);

        dll.RemoveDup();

        dll.display();

    }
}
