import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCode {

    static class HuffmanNode {
        char ch;
        int freq;
        HuffmanNode left;
        HuffmanNode right;

        public HuffmanNode(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        String text = "example text"; // input text
        int[] freq = new int[256]; // array to store frequency of each character
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new Comparator<HuffmanNode>() {
            @Override
            public int compare(HuffmanNode o1, HuffmanNode o2) {
                return o1.freq - o2.freq;
            }
        });

        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                pq.add(new HuffmanNode((char) i, freq[i]));
            }
        }

        // build Huffman tree
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.freq + right.freq);
            parent.left = left;
            parent.right = right;
            pq.add(parent);
        }

        // print Huffman codes
        printCodes(pq.poll(), new StringBuilder());
    }

    static void printCodes(HuffmanNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        // leaf node, print code
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + ": " + sb);
            return;
        }

        // recursive calls to left and right subtrees
        sb.append('0');
        printCodes(root.left, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append('1');
        printCodes(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
