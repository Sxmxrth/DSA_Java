import java.util.Scanner;

public class centauri {
    public static void main(String[] args) {
        System.out.print("enter the name of a kingdom : ");
        Scanner sc = new Scanner(System.in);
        String kingdom = sc.nextLine();
        centauriPrime(kingdom);
    }
    public static void centauriPrime(String s){
        if(s.charAt(s.length()-1) == 'y'){
            System.out.println("the kingdom is ruled by nobody");
        } else if (s.charAt(s.length()-1) == 'a' || s.charAt(s.length()-1) == 'e' ||  s.charAt(s.length()-1) == 'i' ||  s.charAt(s.length()-1) == 'o' ||  s.charAt(s.length()-1) == 'u' ) {
            System.out.println("the kingdom is ruled by Bob");
        }
        else {
            System.out.println("the system is ruled by Alice");
        }
    }
}
