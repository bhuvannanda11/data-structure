import java.util.*;

class SortedStack {
    private Stack<Integer> stack;

    // Constructor to initialize the stack
    public SortedStack() {
        stack = new Stack<>();
    }

    // Function to insert an element into the sorted stack
    private void insertSorted(int element) {
        // If stack is empty or the element is greater than the top element, push it
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            // Pop the top element and recursively call insertSorted to find the right position
            int temp = stack.pop();
            insertSorted(element);
            stack.push(temp);
        }
    }

    // Function to sort the stack
    public void sortStack() {
        // Base case: If stack is not empty
        if (!stack.isEmpty()) {
            // Pop the top element
            int top = stack.pop();
            // Recursively sort the remaining stack
            sortStack();
            // Insert the popped element into the sorted stack
            insertSorted(top);
        }
    }

    // Function to print the stack (for demonstration)
    public void printStack() {
        System.out.println(stack);
    }

    // Function to push an element to the stack
    public void push(int value) {
        stack.push(value);
    }

    // Function to check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

public class StackSortUsingRecursion {
    public static void main(String[] args) {
        SortedStack sortedStack = new SortedStack();
        
        // Pushing elements into the stack
        sortedStack.push(34);
        sortedStack.push(3);
        sortedStack.push(31);
        sortedStack.push(98);
        sortedStack.push(92);
        sortedStack.push(23);

        System.out.println("Stack before sorting:");
        sortedStack.printStack();

        // Sorting the stack
        sortedStack.sortStack();

        System.out.println("Stack after sorting:");
        sortedStack.printStack();
    }
}
