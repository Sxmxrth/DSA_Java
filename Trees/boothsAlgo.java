import java.util.Scanner;

public class boothsAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the multiplicand: ");
        int b = sc.nextInt();
        System.out.print("Enter the multiplier: ");
        int q = sc.nextInt();
        boothMultiply(decimalToBinary(b), decimalToBinary(q));
    }

    public static void boothMultiply(int b, int q){

    }

    public static int decimalToBinary(int x){
        if( x < 0 ){
            x = -1 * x;
            String s = "";
            int[] bin = new int[4];
            int i = 0;
            while ( x != 0 ){
                bin[i++] = x % 2;
                x = x / 2;
            }
            for (int j = bin.length - 1 ; j >= 0 ; j--) {
                if( bin[j] == 0 ){
                    bin[j] = 1;
                }
                else {
                    bin[j] = 0;
                }
            }
            for (int j = 0; j < bin.length ; j++) {
                if (bin[j] == 1){
                    bin[j] = 0;
                }
                else {
                    bin[j] = 1;
                    break;
                }

            }
            for (int j = bin.length - 1 ; j >= 0 ; j--) {
                s = s + bin[j];
            }
            return Integer.parseInt(s);

        }
        String s = "";
        int[] bin = new int[5];
        int i = 0;
        while ( x != 0 ){
            bin[i++] = x % 2;
            x = x / 2;
        }
        for (int j = bin.length - 1 ; j >= 0 ; j--) {
            s = s + bin[j];
        }
        return Integer.parseInt(s);
    }
}
