import java.util.Scanner;

public class RomanToInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(romanToInt(s));
    }
    public static int romanToInt(String s){
        int I = 1;
        int V = 5;
        int X = 10;
        int L = 50;
        int C = 100;
        int D = 500;
        int M = 1000;
        int n = 0;
        int l = s.length();
        for (int i = 0; i < l-2 ; i++) {
            if(s.charAt(i) == 'I'){
                if()
            }
        }
    }
}
