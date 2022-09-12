public class QueueImplementation {
    public static void main(String[] args) {

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
        if(isFull()){
            return q[front];
        }

    }
}
