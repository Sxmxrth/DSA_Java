import java.util.*;

public class yogurt {
    public static void main(String[] args) {
        int[] arr = {3,3,2,1,3,1,1};
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        int k = 2;
        System.out.println("The max number of yogurt consumed is " + maxYogurt(arr, k));
    }

    public static int maxYogurt(int[] arr, int k){
        int c = 0, day = 0, y = 0;
        for (int i = 0; i < arr.length; i++) {
            if(day < arr[i] && c < k){
                c++;
                y++;
                if(c == k){
                    day ++;
                    c = 0;
                }
            }
        }
        return y ;
    }
}