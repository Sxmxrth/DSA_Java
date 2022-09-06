import java.util.*;
public class StackImplementation {
    public static void main(String[] args) {
        Stacks s1 = new Stacks();
        s1.push(13);
        s1.push(24);
        s1.push(48);

        System.out.println("the item popped is "+ s1.pop());
        //System.out.println("the item popped is "+ s1.pop());
        //System.out.println("the item popped is "+ s1.pop());
        System.out.println("the topmost element is "+s1.peek());

        s1.display();
    }
}

class Stacks{
    int top = -1;
    int MAX = 5;
    int[] st = new int[MAX];

    public void push(int n){
        if(top >= MAX-1){
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

    public int peek(){
        if(top<0){
            System.out.println("the stack is empty ");
            return 0;
        }
        return st[top];
    }


    public void display(){
        if (top <0){
            System.out.println("the stack is empty");
        }
        else{
            for (int i = 0; i <=top ; i++) {
                System.out.print(st[i] + " ");

            }
        }

    }
}