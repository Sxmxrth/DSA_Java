import java.util.*;

public class InfixToPostfix {
    static Stack operators = new Stack();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("enter the expression in infix: ");
        String infix = sc.nextLine();
        //String postfix = "";
        System.out.println("the expression in postfix is: " + toPostfix(infix));

    }

    public static String toPostfix(String infix){
        char symbol;
        String postfix = "";
        for (int i = 0; i < infix.length() ; ++i) {
            symbol = infix.charAt(i);
            if(Character.isLetter(symbol)){
                postfix = postfix + symbol;
            }

            else if(symbol == '('){
                operators.push(symbol);
            }

            else if (symbol == ')') {
                while(operators.peek() != '('){
                    postfix = postfix + operators.pop();
                }
                operators.pop();
            }

            else {
                while(!operators.isEmpty() && !(operators.peek() == '(') && (prec(symbol) <= prec(operators.peek()))){
                    postfix = postfix + operators.pop();
                }
                operators.push(symbol);
            }
        }

        while (!operators.isEmpty()){
            postfix = postfix + operators.pop();
        }

        return postfix;

    }

    public static int prec(char symbol){
        if (symbol == '+' || symbol == '-'){
            return 1;
        }
        else if (symbol == '*' || symbol =='/' || symbol == '%') {
            return 2;
        }
        return 0;
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
