import java.lang.reflect.Array;
import java.util.Arrays;

public class heap {
    public int[] Heap;
    public int size;
    public int maxsize;

    // Constructor to initialize an
    // empty max heap with given maximum
    // capacity
    public heap(int maxsize)
    {
        // This keyword refers to current instance itself
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
    }

    // Method 1
    // Returning position of parent
    private int parent(int key) {
        return (key - 1) / 2;
    }

    // Method 2
    // Returning left children
    private int leftChild(int key) {
        return (2 * key) + 1;
    }

    // Method 3
    // Returning right children
    private int rightChild(int key) {
        return (2 * key) + 2;
    }

    // Method 4
    // Returning true if given node is leaf
    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // Method 5
    // Swapping nodes
    private void swap(int fpos, int spos) {
        int temp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = temp;
    }

    // Method 6
    // Recursive function to max heapify given subtree
    private void maxHeapify(int pos)
    {
        if (isLeaf(pos))
            return;

        if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {

            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }

        }
    }

    public void sort(int arr[])
    {
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            maxHeapify(i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            maxHeapify(0);
        }
    }
    // Method 7
    // Inserts a new element to max heap
    public void insert(int element)
    {
        Heap[size] = element;

        // Traverse up and fix violated property
        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        System.out.println("intermediate Array is :" + Arrays.toString(Heap));
        size++;
    }

    // Method 8
    // To display heap
    public void print()
    {
//        System.out.println(Arrays.toString(Heap));
        for (int i = 0; i < size / 2; i++) {

            System.out.print("Parent Node : " + Heap[i]);

            if (leftChild(i) < size){
                // if the child is out of the bound of the array
                System.out.print(" Left Child Node: " + Heap[leftChild(i)]);
            }

            if (rightChild(i) < size) {
                // if the right child index must not be out of the index of the array
                System.out.print(" Right Child Node: " + Heap[rightChild(i)]);
            }

            System.out.println();
        }
    }

    // Method 9
    // Remove an element from max heap
    public int extractMax(){
        int popped = Heap[0];
        Heap[0] = Heap[--size];
        maxHeapify(0);
        return popped;
    }

    // Method 10
    // main driver method
    public static void main(String[] arg)
    {
        // Display message for better readability
        System.out.println("The Max Heap is ");

        heap maxHeap = new heap(15);

        // Inserting nodes
        // Custom inputs
        int[] Heap = {4,10,3,5,1};
        for (int i = 0; i < Heap.length ; i++) {
            maxHeap.insert(Heap[i]);
        }

        // Calling maxHeap() as defined above
        maxHeap.print();

        // Print and display the maximum value in heap
        System.out.println("The max val is " + maxHeap.extractMax());
    }
}
