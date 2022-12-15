public class candy {
    public static void main(String[] args) {
        int[] c = {1,2,3,4,5,6,7};
        int m = 3;
        System.out.println("the remaining candies are " + maxCandy(c, m));

    }

    public static int maxCandy(int[] arr, int m){
        int x = 0;
        for (int i = 0; i < arr.length ; i++) {
            x+=arr[i];
        }
        return x%m;
    }
}
