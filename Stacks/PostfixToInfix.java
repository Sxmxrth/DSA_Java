import java.util.Scanner;

public class PostfixToInfix {
    static Stack2 inf = new Stack2();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a Postfix string: ");
        String postfix = sc.nextLine();
        System.out.println("the infix for this is "+PostToIn(postfix));
    }

    public static String PostToIn(String postfix){
        char symbol;
        String infix = "";
        for (int i = 0; i < postfix.length() ; i++) {
            symbol = postfix.charAt(i);
            if(Character.isLetter(symbol)){
                inf.push(String.valueOf(symbol));

            }
            else{
                String a = inf.pop();
                String b = inf.pop();

                inf.push(b+symbol+a);
                System.out.println(inf.peek());

            }
        }
        return inf.pop();
    }
}


class Stack2{
    int max = 100;
    String[] ch = new String[max];
    int top = -1;

    public void push(String a){
        if(top >= max-1){
            System.out.println("Stack Overflow");

        }
        else {
            ch[++top] = a;
        }

    }

    public String pop(){
        if (top < 0){
            System.out.println("Stack Underflow");
            return null;
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

    public String peek(){
        return ch[top];
    }
}

