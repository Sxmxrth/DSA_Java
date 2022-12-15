public class removeNode {
    public static void main(String[] args) {
        removeNode l = new removeNode();
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
        l.insert(5);

        int n = 4;

        l.remove(n, l.head);
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

    public void remove(int n, listNode head){
        int c = 0, i = 0;
        listNode temp = head;
        while (temp != null){
            c++;
            temp = temp.next;
        }
        temp = head;
        listNode prev = temp;
        while (i < (c-n)){
            prev = temp;
            temp = temp.next;
            i++;
        }
        if(temp == head){
            head = head.next;
        }
        else {
            prev.next = temp.next;
        }


        temp = head;
        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
}
