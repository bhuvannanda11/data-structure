import java.util.*;

class QueueUsingTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // Constructor to initialize the stacks
    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation: Push the element onto stack1
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation: Pop the element from stack2
    public int dequeue() {
        // If both stacks are empty, throw an exception
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        // If stack2 is empty, move all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Pop from stack2 (this is the front of the queue)
        return stack2.pop();
    }

    // Peek operation: Get the front element of the queue without dequeuing
    public int peek() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class QueueUsingStack {
    public static void main(String[] args) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        
        // Testing enqueue operation
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        // Testing dequeue operation
        System.out.println(queue.dequeue()); // Output: 1 (Front of the queue)
        System.out.println(queue.dequeue()); // Output: 2
        
        // Testing peek operation
        System.out.println(queue.peek()); // Output: 3 (Front of the queue)
        
        // Testing isEmpty operation
        System.out.println(queue.isEmpty()); // Output: false
        
        // Dequeue the last element
        System.out.println(queue.dequeue()); // Output: 3
        
        // Check if queue is empty now
        System.out.println(queue.isEmpty()); // Output: true
    }
}
