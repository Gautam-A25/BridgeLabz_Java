package linkedlist;

/*
6. Circular Linked List: Round Robin Scheduling Algorithm
Problem Statement: Implement a round-robin CPU scheduling algorithm using a circular linked list.
Each node represents a process and contains Process ID, Burst Time, and Priority.

Implement:
- Add a new process at the end of the circular list.
- Remove a process by Process ID after its execution.
- Simulate scheduling with fixed time quantum.
- Display processes in circular queue after each round.
- Calculate and display average waiting time and turn-around time.

Hint:
- Use circular linked list as queue.
- Each process runs for time quantum, move to next.
- Remove when burst becomes 0.
*/

import java.util.HashMap;
import java.util.Map;

// Node class (each node is a Process in circular linked list)
class Process {
    int pid;
    int burstTime;
    int priority;
    int remainingTime;

    Process next;

    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinCLL {
    private Process head = null;

    // Add process at end of circular list
    public void addProcess(int pid, int burst, int priority) {
        Process newNode = new Process(pid, burst, priority);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Process temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // Remove process by PID
    private void removeProcess(int pid) {
        if (head == null) return;

        Process temp = head;
        Process prev = null;

        do {
            if (temp.pid == pid) {

                // Case 1: only one process
                if (temp == head && temp.next == head) {
                    head = null;
                    return;
                }

                // Case 2: deleting head
                if (temp == head) {
                    Process last = head;
                    while (last.next != head) {
                        last = last.next;
                    }

                    head = head.next;
                    last.next = head;
                }
                // Case 3: deleting middle/tail
                else {
                    prev.next = temp.next;
                }

                temp.next = null; // cleanup
                return;
            }

            prev = temp;
            temp = temp.next;

        } while (temp != head);
    }

    // Display the circular queue
    public void displayQueue() {
        if (head == null) {
            System.out.println("Queue empty.");
            return;
        }

        System.out.print("Queue: ");
        Process temp = head;
        do {
            System.out.print("[P" + temp.pid + " RT=" + temp.remainingTime + "] ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Round Robin Simulation + Avg WT & TAT
    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        // Stores finish time of each process
        Map<Integer, Integer> finishTime = new HashMap<>();

        // Stores original burst time of each process
        Map<Integer, Integer> burstMap = new HashMap<>();

        // Capture burst times before processes are removed
        Process t = head;
        do {
            burstMap.put(t.pid, t.burstTime);
            t = t.next;
        } while (t != head);

        int currentTime = 0;
        Process current = head;

        System.out.println("---- Round Robin Scheduling ----");
        System.out.println("Time Quantum = " + timeQuantum + "\n");

        while (head != null) {
            displayQueue();

            int execTime = Math.min(timeQuantum, current.remainingTime);

            System.out.println("Executing P" + current.pid + " for " + execTime + " units...");
            current.remainingTime -= execTime;
            currentTime += execTime;

            // Process completed
            if (current.remainingTime == 0) {
                finishTime.put(current.pid, currentTime);

                int completedPid = current.pid;
                current = current.next; // move before removal
                removeProcess(completedPid);

                System.out.println("✅ P" + completedPid + " completed at time " + currentTime);

                if (head == null) break; // all completed
            } else {
                current = current.next;
            }

            System.out.println();
        }

        // Calculate WT and TAT
        double totalWT = 0;
        double totalTAT = 0;

        System.out.println("\n---- Final Results ----");
        System.out.println("PID | Burst | Finish | TurnAround | Waiting");
        System.out.println("-------------------------------------------");

        for (int pid : finishTime.keySet()) {
            int burst = burstMap.get(pid);
            int ft = finishTime.get(pid);

            int tat = ft; // arrival time = 0
            int wt = tat - burst;

            totalWT += wt;
            totalTAT += tat;

            System.out.println(pid + "   | " + burst + "     | " + ft + "     | " + tat + "         | " + wt);
        }

        int n = finishTime.size();
        System.out.println("-------------------------------------------");
        System.out.println("Average Waiting Time = " + (totalWT / n));
        System.out.println("Average Turnaround Time = " + (totalTAT / n));
    }
}

public class ProcessNode {
    public static void main(String[] args) {

        RoundRobinCLL rr = new RoundRobinCLL();

        // Add processes (pid, burstTime, priority)
        rr.addProcess(1, 10, 1);
        rr.addProcess(2, 5, 2);
        rr.addProcess(3, 8, 1);

        int timeQuantum = 3;

        // Simulation
        rr.simulate(timeQuantum);
    }
}
