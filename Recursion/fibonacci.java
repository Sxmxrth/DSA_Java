import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        // find nth fibonacci number
        Scanner sc = new Scanner(System.in);
        System.out.print("enter n: ");
        int n = sc.nextInt();
        System.out.println(fibRec(n - 1));
    }

    public static int fibRec(int n){
        if(n < 2){
            return n;
        }
        return fibRec(n-1) + fibRec(n-2);
    }
}
