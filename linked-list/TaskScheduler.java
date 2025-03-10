import java.util.*;
// Task class representing a task node in the circular linked list
class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    // Constructor to initialize the task details
    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

// TaskCircularLinkedList class to manage tasks using circular linked list
class TaskCircularLinkedList {
    Task head;

    // Constructor to initialize the circular linked list
    public TaskCircularLinkedList() {
        this.head = null;
    }

    // Add a task at the beginning of the list
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head; // Point to itself for circular reference
        } else {
            Task temp = head;
            while (temp.next != head) { // Traverse until we reach the last node
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head; // Circular reference to the head node
            head = newTask; // New task becomes the head of the list
        }
    }

    // Add a task at the end of the list
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head; // Point to itself for circular reference
        } else {
            Task temp = head;
            while (temp.next != head) { // Traverse until we reach the last node
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head; // Circular reference to the head node
        }
    }

    // Add a task at a specific position in the list
    public void addTaskAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position < 0) {
            System.out.println("Invalid position.");
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);

        if (position == 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task temp = head;
        for (int i = 0; i < position - 1; i++) {
            if (temp == null || temp.next == head) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
        }

        newTask.next = temp.next;
        temp.next = newTask;
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Task temp = head;
        Task prev = null;
        do {
            if (temp.taskId == taskId) {
                if (prev == null) { // Deleting the head node
                    if (temp.next == head) {
                        head = null; // Only one task in the list
                    } else {
                        prev = head;
                        while (prev.next != head) {
                            prev = prev.next;
                        }
                        head = temp.next;
                        prev.next = head;
                    }
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next task
    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Task temp = head;
        System.out.println("Current Task: " + temp.taskName + " (Task ID: " + temp.taskId + ")");
        head = temp.next; // Move to the next task
    }

    // Display all tasks starting from the head node
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        System.out.println("Task List:");
        do {
            System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for tasks by Priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found Task: " + temp.taskName + " (Task ID: " + temp.taskId + ")");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }
}

// Main class to test the TaskScheduler functionality
public class TaskScheduler {
    public static void main(String[] args) {
        TaskCircularLinkedList taskList = new TaskCircularLinkedList();

        // Add tasks to the list
        taskList.addTaskAtBeginning(1, "Task 1", 1, "2025-03-01");
        taskList.addTaskAtEnd(2, "Task 2", 2, "2025-03-05");
        taskList.addTaskAtEnd(3, "Task 3", 3, "2025-03-10");
        taskList.addTaskAtPosition(1, 4, "Task 4", 2, "2025-03-03");

        // Display all tasks
        taskList.displayAllTasks();

        // View the current task and move to the next task
        taskList.viewCurrentTask(); // View Task 1
        taskList.viewCurrentTask(); // View Task 4

        // Search tasks by Priority
        taskList.searchTaskByPriority(2);

        // Remove a task by Task ID
        taskList.removeTaskById(2);

        // Display all tasks after removal
        taskList.displayAllTasks();
    }
}
