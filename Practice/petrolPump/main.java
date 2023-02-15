package petrolPump;

public class main {
    public static void main(String[] args) {
        circularQueue petrol = new circularQueue();
        circularQueue distance = new circularQueue();
        int[][] info = {{4, 6}, {4, 5}, {7, 3}, {4, 5}};
        for (int i = 0; i < 4 ; i++) {

            petrol.enqueue(info[i][0]);
            distance.enqueue(info[i][1]);

        }
        int i = 0;
        int flag = 0;

        int acc = 0;

        while((petrol.cqueue[i] - distance.cqueue[i]) < 0){
            i++;
            flag = i;
        }

        while (acc >= 0){
            acc += petrol.cqueue[i] - distance.cqueue[i];
            i = (i + 1) % 4;
            if(i == flag){
                System.out.println("we can traverse from " + i);
                break;
            }
        }
    }
}

class circularQueue{
    int size = 4;
    int petrol;
    int front, rear, pointer1 = 0, pointer2 = 0;
    int[] cqueue = new int[size];

    circularQueue(){
        front = rear = -1;
    }

    public boolean isEmpty(){
        if (front == -1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(front == rear + 1 || front == 0 && rear == size - 1){
            return true;
        }
        return false;
    }

    public void enqueue(int value){
        if(isFull()){
            System.out.println("The queue is full");
        }
        else if (isEmpty()) {
            front ++;
            cqueue[++rear] = value;

        }
        else {
            rear = (rear + 1) % size;
            cqueue[rear] = value;
        }
    }

    public int dequeue(){
       if(isEmpty()){
           System.out.println("The queue is Empty");
           return -1;
       }
       else {
           int temp = cqueue[front];
           if (front == rear){
               front = rear = -1;
           }
           else {
               front = (front + 1) % size;
           }
           return temp;
       }

    }
}
