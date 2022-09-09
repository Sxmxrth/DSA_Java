import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
}

class Stack{
    int max = 100;
    char[] ch = new char[max];
    int top = -1;

    public void push(char a){
        if(top >= max-1){
            System.out.println("Stack Overflow");

        }
        else {
            ch[++top] = a;
        }
    }

    public char pop(){
        if (top < 0){
            System.out.println("Stack Underflow");
            return 0;
        }
        else{
            return ch[top--];
        }
    }

    public boolean isEmpty(){
        if(top < 0){
            return true;
        }
        return false;
    }

    public char peek(){
        return ch[top];
    }
}
