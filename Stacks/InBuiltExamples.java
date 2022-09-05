import java.util.Stack;

public class InBuiltExamples {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(43);
        s.push(23);
        s.push(21);
        s.push(16);

        for (int i = 0; i <4 ; i++) {
            System.out.println(s.pop());
        }

    }
}
