import java.util.*;

public class knapsack {
    static class Item {
        int weight;
        int value;
        double bound;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.bound = 0.0;
        }
    }

    static class Node {
        int level;
        int profit;
        int weight;
        boolean[] include;

        public Node(int level, int profit, int weight, boolean[] include) {
            this.level = level;
            this.profit = profit;
            this.weight = weight;
            this.include = Arrays.copyOf(include, include.length);
        }
    }

    public static int knapsackBB(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], values[i]);
        }
        Arrays.sort(items, (a, b) -> Double.compare(b.bound, a.bound));
        LinkedList queue = new LinkedList();
        boolean[] initialInclude = new boolean[n];
        queue.add(new Node(-1, 0, 0, initialInclude));
        int maxProfit = 0;
        while (!queue.isEmpty()) {
            Node node = (Node) queue.poll();
            if (node.level == n - 1) {
                maxProfit = Math.max(maxProfit, node.profit);
            } else {
                int nextLevel = node.level + 1;
                Item item = items[nextLevel];
                boolean[] include = Arrays.copyOf(node.include, node.include.length);
                include[nextLevel] = true;
                int newWeight = node.weight + item.weight;
                if (newWeight <= capacity) {
                    queue.add(new Node(nextLevel, node.profit + item.value, newWeight, include));
                }
                double bound = bound(node, items, capacity);
                if (bound > maxProfit) {
                    queue.add(new Node(nextLevel, node.profit, node.weight, node.include));
                }
            }
        }
        return maxProfit;
    }

    private static double bound(Node node, Item[] items, int capacity) {
        int n = items.length;
        int level = node.level + 1;
        int profit = node.profit;
        int weight = node.weight;
        while (level < n && weight + items[level].weight <= capacity) {
            profit += items[level].value;
            weight += items[level].weight;
            level++;
        }
        if (level < n) {
            profit += (int) ((capacity - weight) * items[level].bound);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] weights = { 10, 20, 30 };
        System.out.println("weight : " + Arrays.toString(weights));
        int[] values = { 60, 100, 120 };
        System.out.println("values : " + Arrays.toString(values));
        int capacity = 50;
        System.out.println("capacity : " + capacity);
        int maxProfit = knapsackBB(weights, values, capacity);
        System.out.println("max profit : " + maxProfit);
    }
}