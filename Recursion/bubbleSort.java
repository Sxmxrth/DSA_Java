import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        System.out.println("The sorted array is " + Arrays.toString(bubble(arr, 5)));
        
    }
    public static int[] bubble(int[] arr, int x){
        if(x == 0){
            return arr;
        }
        for (int i = 0; i < x - 1; i++) {
            if(arr[i] > arr[i + 1]){
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        return bubble(arr, x - 1);
    }
}
