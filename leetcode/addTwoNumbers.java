public class addTwoNumbers {
    public static void main(String[] args) {
        addTwoNumbers l1 = new addTwoNumbers();
        addTwoNumbers l2 = new addTwoNumbers();

        l1.insert(9);
        l1.insert(9);
        l1.insert(9);
        l1.insert(9);
        l1.insert(9);
        l1.insert(9);
        l1.insert(9);

        l2.insert(9);
        l2.insert(9);
        l2.insert(9);
        l2.insert(9);

        l1.add(l1, l2);
    }
    listNode head = null, tail = null;
    public void insert(int key){
        listNode newNode = new listNode(key);
        if(head == null){
            head = tail = newNode;
            tail.next = null;
        }
        else{
            tail.next = newNode;
            tail = newNode;
            newNode.next = null;
        }
    }

    public void add(addTwoNumbers l1, addTwoNumbers l2){
        addTwoNumbers l3 = new addTwoNumbers();
        listNode temp1 = l1.head;
        listNode temp2 = l2.head;
        int n1 = 0, n2 = 0;
        while (temp1 != null){
            n1 = (n1 * 10) + temp1.value;
            temp1 = temp1.next;
        }
        while (temp2 != null){
            n2 = (n2 * 10) + temp2.value;
            temp2 = temp2.next;
        }
        int k = n1 + n2;
        while (k > 0){
            l3.insert(k % 10);
            k = k / 10;
        }
        print(l3);

    }

    public void print(addTwoNumbers l3){
        listNode temp = l3.head;
        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
}
class listNode{
    int value;
    listNode next;
    listNode(int d){
        value = d;
    }
}
