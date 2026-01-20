package linkedlist;

/*
3. Circular Linked List: Task Scheduler
Problem Statement: Create a task scheduler using a circular linked list.
Each node represents a task with Task ID, Task Name, Priority, and Due Date.
Implement:
- Add at beginning, end, or specific position.
- Remove by Task ID.
- View current task and move to next.
- Display all tasks starting from head.
- Search by Priority.

Hint:
- Last node’s next points back to head.
- Stop traversal after one full cycle.
*/

// Node class (each node is a Task)
class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

// Circular Linked List class
class TaskCircularList {
    private Task head = null;
    private Task current = null;

    public void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newNode = new Task(id, name, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head; // circular link
            current = head;
            return;
        }

        Task temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
    }

    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newNode = new Task(id, name, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        Task last = head;
        while (last.next != head) last = last.next;

        newNode.next = head;
        last.next = newNode;
        head = newNode;
    }

    // Insert at position (1-based)
    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos <= 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        if (head == null) {
            addAtEnd(id, name, priority, dueDate);
            return;
        }

        Task newNode = new Task(id, name, priority, dueDate);

        Task temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeById(int id) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        Task temp = head;
        Task prev = null;

        do {
            if (temp.id == id) {

                // Only one node
                if (temp == head && temp.next == head) {
                    head = current = null;
                    System.out.println("Task removed: " + id);
                    return;
                }

                // Deleting head
                if (temp == head) {
                    Task last = head;
                    while (last.next != head) last = last.next;

                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }

                // Update current if it is removed
                if (current == temp) {
                    current = temp.next;
                }

                temp.next = null; // cleanup
                System.out.println("Task removed: " + id);
                return;
            }

            prev = temp;
            temp = temp.next;

        } while (temp != head);

        System.out.println("Task not found.");
    }

    public void viewCurrentAndMoveNext() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Current Task: " + current.id + " | " + current.name +
                " | Priority=" + current.priority +
                " | Due=" + current.dueDate);

        current = current.next;
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks.");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                System.out.println("Found Task: " + temp.id + " - " + temp.name + " Due=" + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with priority: " + priority);
        }
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks.");
            return;
        }

        System.out.println("\n---- All Tasks ----");
        Task temp = head;
        do {
            System.out.println(temp.id + " | " + temp.name + " | Priority=" + temp.priority + " | Due=" + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
}

public class TaskNode {
    public static void main(String[] args) {

        TaskCircularList tasks = new TaskCircularList();

        tasks.addAtEnd(1, "DSA Practice", 1, "2026-01-20");
        tasks.addAtEnd(2, "Project Work", 2, "2026-01-18");
        tasks.addAtBeginning(3, "Resume Update", 1, "2026-01-15");

        tasks.displayAll();

        tasks.viewCurrentAndMoveNext();
        tasks.viewCurrentAndMoveNext();

        tasks.searchByPriority(1);

        tasks.removeById(2);

        tasks.displayAll();
    }
}
