import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static double getMaxValue(int[] wt, int[] val, int capacity) {
        ItemValue[] iVal = new ItemValue[wt.length];

        for (int i = 0; i < wt.length; i++) {
            iVal[i] = new ItemValue(wt[i], val[i], i);
        }

        // sorting items by value/weight ratio in descending order
        Arrays.sort(iVal, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });

        double totalValue = 0d;

        for (ItemValue i : iVal) {
            int curWt = (int) i.wt;
            int curVal = (int) i.val;

            if (capacity - curWt >= 0) {
                capacity -= curWt;
                totalValue += curVal;
                System.out.printf("Adding item %d (weight: %d, value: %d) completely.%n", i.ind + 1, curWt, curVal);
            } else {
                double fraction = ((double) capacity / (double) curWt);
                totalValue += (curVal * fraction);
                System.out.printf("Adding %.2f fraction of item %d (weight: %d, value: %d).%n", fraction, i.ind + 1,
                        curWt, curVal);
                capacity = (int) (capacity - (curWt * fraction));
                break;
            }
        }

        return totalValue;
    }

    static class ItemValue {
        Double cost;
        double wt, val, ind;

        public ItemValue(int wt, int val, int ind) {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = (double) val / (double) wt;
        }
    }

    public static void main(String[] args) {
        int[] wt = { 10, 40, 20, 30 };
        int[] val = { 60, 40, 100, 120 };
        int capacity = 50;

        double maxValue = getMaxValue(wt, val, capacity);

        System.out.printf("Maximum value we can obtain = %.2f", maxValue);
    }
}
