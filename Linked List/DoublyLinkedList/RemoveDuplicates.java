package DoublyLinkedList;

public class RemoveDuplicates {
    public static void main(String[] args) {

        DoublyLL dll = new DoublyLL();
        dll.push(12);
        dll.push(1);
        dll.push(16);
        dll.push(1);
        dll.push(16);
        dll.push(13);
        dll.push(11);
        dll.push(18);
        dll.push(18);

        dll.RemoveDup();
        dll.EvenFirst();

        //dll.display();

    }
}
