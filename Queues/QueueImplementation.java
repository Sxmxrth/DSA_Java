public class QueueImplementation {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(1);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println();
        queue.display();

    }
}

class Queue{
    int size = 5;
    int[] q = new int[size];
    int front = -1;
    int rear = -1;

    public boolean isFull(){
        if(front == 0 && rear == size-1){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(front == -1 ){
            return true;
        }
        return false;
    }

    public void enqueue(int x){
        if(isFull()){
            System.out.println("the queue is already full");
        }
        if (isEmpty()){
            q[++front] = x;
            rear = 0;
        }

        else {
            q[++rear] = x;
        }
    }

    public int dequeue(){
        if(isEmpty()){
            return 0;
        }
        else {
            int element = q[front];
            if(front >= rear){
                front = -1;
                rear = -1;
            }
            else {
                front++;
            }
            return element;
        }

    }

    public void display(){
        for (int i = front; i <= rear ; i++) {
            System.out.println(q[i]);
        }
    }
}
