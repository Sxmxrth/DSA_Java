package SinglyLinkedList;

public class PolynomialExp {
    public static void main(String[] args) {

        int[] c1 = {5, 4, 2, 1};
        int[] e1 = {4, 3, 1, 0};

        PolynomialExp p1 = new PolynomialExp();

        for (int i = 0; i < 4; i++) {

            p1.push(c1[i], e1[i]);

        }

        int[] c2 = {6, 2, 7};
        int[] e2 = {3, 2, 0};

        PolynomialExp p2 = new PolynomialExp();

        for (int i = 0; i < 3; i++) {

            p2.push(c2[i], e2[i]);

        }

        PolynomialExp ans = new PolynomialExp();

        p1.add(p1, p2, ans);


        //System.out.println(p1.head.next.exp);

    }

    Node1 head = null, tail = null;

    public void push(int coeff, int exp){
        Node1 new_node = new Node1(coeff, exp);

        if(head == null){
            head = new_node;
            tail = new_node;
        }

        else {
            tail.next = new_node;
            tail = new_node;
            tail.next = null;
        }
    }

    public void add(PolynomialExp p1, PolynomialExp p2, PolynomialExp ans){
        Node1 temp1 = p1.head;
        Node1 temp2 = p2.head;

        while(temp1 != null && temp2 != null){

            if (temp1.exp == temp2.exp){

                ans.push((temp1.coeff + temp2.coeff), temp1.exp);
                temp1 = temp1.next;
                temp2 = temp2.next;

            }

            else if (temp1.exp > temp2.exp){

                ans.push(temp1.coeff, temp1.exp);
                temp1 = temp1.next;

            }

            else {

                ans.push(temp2.coeff, temp2.exp);
                temp2 = temp2.next;

            }

        }

        while(temp1 != null){

            ans.push(temp1.coeff, temp1.exp);
            temp1 = temp1.next;

        }

        while(temp2 != null){

            ans.push(temp2.coeff, temp2.exp);
            temp2 = temp2.next;

        }

        PrintAns(ans);

    }

    public void PrintAns(PolynomialExp ans){

        Node1 temp = ans.head;

        while (temp != null){
            System.out.print(temp.coeff + "x^" + temp.exp+" ");
            temp = temp.next;
        }

    }

}

class Node1{
    int coeff, exp;
    Node1 next;

    Node1(int c, int e){

        coeff = c;
        exp = e;

    }
}
