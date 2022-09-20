import java.util.Scanner;

public class PetrolPump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CQueue1 c = new CQueue1();
//        System.out.println("enter number of petrol pumps: ");
//        int n = sc.nextInt();

        System.out.println("you can start from here: "+ tour(4));

    }

    public static int tour(int n){
        int[][] pp = { {4,6}, {6,5}, {7,3}, {4,5} };
        int i, acc = 0;
        int start = 0;
        int end = 1;
        for ( i = 0; i < 4; i++) {
            if(pp[i][0] >= pp[i][1]){
                acc = pp[i][0] - pp[i][1];
                break;
            }
        }
        start = i;
        end = (start+1) % 4;
        while (end != start || acc < 0){

            while(acc<0 && start != end){

                acc -= pp[start][0] - pp[start][1];
                start = (start+1) % 4;

                if(start == i){
                    return -1;
                }
            }

            acc += pp[end][0] - pp[end][1];
            end = (end+1) % 4;
        }
        return start+1;
    }
}

class CQueue1{
    int size = 4;
    int front, rear;
    int[] cqueue = new int[size];

    CQueue1(){
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