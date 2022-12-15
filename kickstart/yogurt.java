public class yogurt {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,3,3,3,3,3,4};
        int k = 3;
        System.out.println("The max number of yogurt consumed is " + maxYogurt(arr, k));
    }

    public static int maxYogurt(int[] arr, int k){
        int c = 0, day = 0, y = 0;
        for (int i = 0; i < arr.length; i++) {
            if(day < arr[i] && c < k){
                c++;
                y++;
            }
            else if (c == k) {
                day++;
                c = 0;
            }
        }
        return y + 1;
    }
}