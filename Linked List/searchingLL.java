import java.util.*;
public class searchingLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SingleLinkedList sll = new SingleLinkedList();

        sll.push(3);
        sll.push(-9);
        sll.push(12);
        sll.push(23);
        sll.push(2);
        sll.push(0);

        System.out.print("enter a number to be searched in the Linked List: ");
        int n = sc.nextInt();
        System.out.println(sll.SearchInLL(n));

    }
}
