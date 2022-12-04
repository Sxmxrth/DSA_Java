import java.util.Arrays;

public class ChainingProbing {
    static hashNode[] arr = new hashNode[7];
    static int[] qp = new int[5];
    public static void main(String[] args) {
        Chaining(arr, 12);
        Chaining(arr, 7);
        Chaining(arr, 5);
        Chaining(arr, 8);
        Chaining(arr, 18);
        Chaining(arr, 24);
        Chaining(arr, 29);

        System.out.println(arr[1].next.value);
        System.out.println(searchChaining(arr, 7));

        deleteNode(arr, 12);
        displayChaining(arr);

        System.out.println("---------------------------------");

        quadraticProbing(qp,2);
        quadraticProbing(qp,4);
        quadraticProbing(qp,6);
        quadraticProbing(qp,9);
        quadraticProbing(qp,5);

        System.out.println(Arrays.toString(qp));
        System.out.println(searchProbing(qp, 78));

        deleteProbing(qp, 5);
        System.out.println(Arrays.toString(qp));

    }

    public static int hashFunction(int value, int divisor){
        return value % divisor;
    }

    public static void Chaining(hashNode[] arr, int value){
        int possibleKey = hashFunction(value, 7);
        if (arr[possibleKey] == null){
            arr[possibleKey] = new hashNode(value);
        }
        else {
            System.out.println("collision has happened at index " + possibleKey);
            hashNode temp = arr[possibleKey];
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new hashNode(value);
        }
    }

    public static boolean searchChaining(hashNode[] arr, int value){
        int possibleKey = hashFunction(value, 7);
        hashNode temp = arr[possibleKey];
        while(value != temp.value && temp.next != null){
            temp = temp.next;
        }
        if (temp.value == value){
            return true;
        }
        return false;

    }

    public static void deleteNode(hashNode[] arr, int value){
        if(!searchChaining(arr, value)){
            System.out.println("The value is already not there.");
        }
        else {
            int key = hashFunction(value, 7);
            hashNode head = arr[key];
            hashNode temp = head;
            hashNode prev = temp;
            if (temp.value == value){
                head = temp.next;
                //System.out.println(head.value);
                arr[key] = head;
                return;
            }
            while (value != temp.value){
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;

        }
    }

    public static void displayChaining(hashNode[] arr){
        for (int i = 0; i < 7; i++) {

            hashNode temp = arr[i];
            if (temp != null){
                System.out.print(temp.value + " ");
            }
            else {
                System.out.print(-1);
                System.out.println();
                continue;
            }
            while (temp.next != null){
                temp = temp.next;
                System.out.print(temp.value + " ");
            }
            System.out.println();

        }
    }

    public static void quadraticProbing(int[] arr, int value){
        for (int i = 0; i < 7; i++) {
            int possibleKey = hashFunction(value + i + 2*(i*i), 5);
            if (arr[possibleKey] == 0){
                arr[possibleKey] = value;
                break;
            }
        }
    }

    public static int searchProbing(int[] arr, int value){
        for (int i = 0; i < 7; i++) {
            int possibleKey = hashFunction(value + i + 2*(i*i), 5);
            if (arr[possibleKey] == value){
                return possibleKey;
            }
        }
        return -1;
    }

    public static void deleteProbing(int[] arr, int value){
        if (searchProbing(arr, value) != -1){
            arr[searchProbing(arr, value)] = -1;
            return;
        }
        System.out.println("Cant delete because not found");
    }
}

class hashNode{
    int value;
    hashNode next;

    hashNode(int value){
        this.value = value;
        next = null;
    }
}
