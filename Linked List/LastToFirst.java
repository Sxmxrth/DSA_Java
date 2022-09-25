public class LastToFirst {
    public static void main(String[] args) {

        SingleLinkedList ll2 = new SingleLinkedList();

        ll2.push(3);
        ll2.push(-9);
        ll2.push(12);
        ll2.push(23);
        ll2.push(2);
        ll2.push(0);

        ll2.lastToFirst();

        ll2.printList();

    }
}
