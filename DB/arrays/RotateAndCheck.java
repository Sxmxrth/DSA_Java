import java.util.*;

class RotateAndCheck {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(checkIfSorted(rotate(arr)));

    }

    public static int[] rotate(int[] arr) {
        int n = arr.length;
        int temp1 = arr[0];
        arr[0] = arr[n - 1];
        int temp2 = 0;
        for (int i = 1; i < arr.length; i++) {
            temp2 = temp1;
            temp1 = arr[i];
            arr[i] = temp2;
        }
        // System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static boolean checkIfSorted(int[] arr) {
        int i = 0;
        while (arr[i] < arr[i + 1] && i < arr.length - 1) {
            i++;
            if (i == arr.length - 1) {
                return true;
            }
        }
        return false;
    }
}