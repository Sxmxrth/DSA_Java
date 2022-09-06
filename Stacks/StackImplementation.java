import java.util.*;
public class StackImplementation {
    public static void main(String[] args) {
        Stacks s1 = new Stacks();
        s1.push(13);
        s1.push(24);
        s1.push(48);

        s1.pop();
        s1.display();
    }
}

class Stacks{
    int top = -1;
    int MAX = 5;
    int[] st = new int[MAX];

    public void push(int n){
        if(top >= MAX){
            System.out.println("The stack has overflown");
        }
        else {
            st[++top] = n;
        }

    }

    public int pop(){
        if(top < 0){
            System.out.println("Stack has underflown");
            return 0;
        }
        return st[top--];
    }


    public void display(){
        for (int i = 0; i <=top ; i++) {
            System.out.print(st[i] + " ");

        }
    }
}