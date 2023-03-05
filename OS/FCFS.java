import java.util.Scanner;

public class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, j;
        float avgWT = 0, avgTAT = 0;
        System.out.print("Enter the number of processes: ");
        n = sc.nextInt();
        int[] burstTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        System.out.println("Enter Burst Time for each process: ");
        for (i = 0; i < n; i++) {
            System.out.print("Process " + (i + 1) + ": ");
            burstTime[i] = sc.nextInt();
        }
        waitingTime[0] = 0;
        for (i = 1; i < n; i++) {
            waitingTime[i] = 0;
            for (j = 0; j < i; j++) {
                waitingTime[i] += burstTime[j];
            }
        }
        System.out.println("\nProcess\t  Burst Time\t  Waiting Time\t  Turnaround Time");
        for (i = 0; i < n; i++) {
            turnaroundTime[i] = burstTime[i] + waitingTime[i];
            avgWT += waitingTime[i];
            avgTAT += turnaroundTime[i];
            System.out.println("P" + (i + 1) + "\t\t" + burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i]);
        }
        avgWT /= n;
        avgTAT /= n;
        System.out.println("\nAverage Waiting Time: " + avgWT);
        System.out.println("Average Turnaround Time: " + avgTAT);
    }
}
