import java.util.*;
class Process {
    int processID;
    int burstTime;
    int remainingBurstTime;
    int priority;
    Process next;

    // Constructor to initialize a process node
    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.remainingBurstTime = burstTime; // remaining burst time initially equals burst time
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduling {
    private Process head;  // head of the circular linked list
    private int size;  // number of processes
    private int totalWaitingTime;
    private int totalTurnaroundTime;

    // Constructor to initialize the Round Robin Scheduling
    public RoundRobinScheduling() {
        this.head = null;
        this.size = 0;
        this.totalWaitingTime = 0;
        this.totalTurnaroundTime = 0;
    }

    // Add a new process at the end of the circular list
    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head;  // Circular linkage
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;  // Circular linkage
        }
        size++;
    }

    // Remove a process by Process ID after its execution
    public void removeProcessByID(int processID) {
        if (head == null) {
            System.out.println("No processes to remove.");
            return;
        }

        Process temp = head;
        Process prev = null;
        
        // If the process to be removed is the head
        if (head.processID == processID) {
            if (head.next == head) {
                head = null;
            } else {
                prev = head;
                while (prev.next != head) {
                    prev = prev.next;
                }
                head = head.next;
                prev.next = head;
            }
            size--;
            return;
        }

        // Searching for the process to remove
        do {
            prev = temp;
            temp = temp.next;
            if (temp.processID == processID) {
                prev.next = temp.next;
                size--;
                return;
            }
        } while (temp != head);
        
        System.out.println("Process with ID " + processID + " not found.");
    }

    // Simulate the round-robin scheduling with a fixed time quantum
    public void roundRobinScheduling(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        
        while (size > 0) {
            // Execute the process for the given time quantum
            if (temp.remainingBurstTime > timeQuantum) {
                // Process is not yet completed
                temp.remainingBurstTime -= timeQuantum;
                System.out.println("Executing Process ID " + temp.processID + " for " + timeQuantum + " units.");
                temp = temp.next;
            } else {
                // Process finishes execution
                int waitingTime = totalTurnaroundTime - temp.burstTime;
                totalWaitingTime += waitingTime;
                totalTurnaroundTime += temp.burstTime;
                
                // Display completed process information
                System.out.println("Process ID " + temp.processID + " completed.");
                System.out.println("Waiting Time: " + waitingTime + " Turnaround Time: " + totalTurnaroundTime);
                
                // Remove the completed process
                removeProcessByID(temp.processID);
                
                // Move to the next process
                if (size > 0) {
                    temp = temp.next;
                }
            }
        }

        this.totalWaitingTime = totalWaitingTime;
        this.totalTurnaroundTime = totalTurnaroundTime;
    }

    // Display the list of processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processID + " Burst Time: " + temp.burstTime +
                    " Remaining Time: " + temp.remainingBurstTime + " Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    // Calculate and display the average waiting time and turn-around time for all processes
    public void calculateAverageTimes() {
        if (size == 0) {
            System.out.println("No processes to calculate times.");
            return;
        }

        double avgWaitingTime = (double) totalWaitingTime / size;
        double avgTurnaroundTime = (double) totalTurnaroundTime / size;

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }
}

public class CircularLL_RoundRobin {
    public static void main(String[] args) {
        RoundRobinScheduling rrScheduler = new RoundRobinScheduling();

        // Add processes to the circular linked list
        rrScheduler.addProcess(1, 10, 2);  // Process ID 1, Burst Time 10, Priority 2
        rrScheduler.addProcess(2, 5, 1);   // Process ID 2, Burst Time 5, Priority 1
        rrScheduler.addProcess(3, 8, 3);   // Process ID 3, Burst Time 8, Priority 3
        rrScheduler.addProcess(4, 6, 2);   // Process ID 4, Burst Time 6, Priority 2

        // Display processes before scheduling
        System.out.println("Processes before scheduling:");
        rrScheduler.displayProcesses();

        // Set time quantum to 4
        int timeQuantum = 4;

        // Start round-robin scheduling
        System.out.println("\nRound Robin Scheduling Simulation (Time Quantum: " + timeQuantum + "):");
        rrScheduler.roundRobinScheduling(timeQuantum);

        // Calculate and display average waiting time and turnaround time
        rrScheduler.calculateAverageTimes();
    }
}
