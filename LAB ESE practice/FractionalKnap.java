public class FractionalKnap {    public static void main(String[] args) {        int[] w = { 3, 3, 2, 5, 1};        int[] p = {10, 15, 10, 12, 8};        int n = 5;        int W = 10;        knapsack(w, p, n, W);    }    public static void knapsack(int[] p, int[] w, int n, int W){        int currW = W;        float tot_v = 0;        int[] used = new int[10];        for (int i = 0; i < n ; i++) {            used[i] = 0;        }        while (currW > 0){            int maxi = -1;            for (int i = 0; i < n; i++) {                if(used[i] == 0 && (maxi == -1 || (float)p[i]/w[i] > (float)p[maxi]/w[maxi]) ){                    maxi = i;                }                used[maxi] = 1;                currW -= w[maxi];                tot_v += p[maxi];            }        }    }}