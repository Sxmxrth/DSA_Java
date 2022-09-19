public class CircularQueue {
    public static void main(String[] args) {
        CQueue c = new CQueue();

        c.enqueue(10);
        c.enqueue(1);
        c.enqueue(6);
        c.enqueue(12);
        c.enqueue(8);

        c.dequeue();
        c.dequeue();

        c.display();

    }
}

class CQueue{
    int size = 5;
    int front, rear;
    int[] cqueue = new int[size];

    CQueue(){
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
        if(front == 0 && rear == size-1){
            return true;
        }
        if(front == rear+1){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(front == -1){
            return true;
        }
        return false;
    }

    public void enqueue(int x){

        if(isEmpty()){
            front++;
            cqueue[++rear] = x;
        }

        else if (isFull()) {
            System.out.println("the queue is full");
        }

        else{
            rear = (rear+1) % size;
            cqueue[rear] = x;
        }

    }

    public int dequeue(){
        if (isEmpty()){
            System.out.println("queue is empty");
            return -1;
        }
        else{
            int temp = cqueue[front];
            if(front == rear){
                front = -1;
                rear = -1;
            }
            else {
                front = (front+1) % size;
            }
            return temp;

        }
    }

    public void display(){
        if (isEmpty()){
            System.out.println("the queue is empty");
        }
        while (front != rear+1){
            System.out.println(cqueue[front++]);
        }
    }
}