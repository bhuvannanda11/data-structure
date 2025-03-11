import java.util.Stack;

public class StockSpan {
    
    // Function to calculate stock span
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];  // Array to store the span values
        Stack<Integer> stack = new Stack<>();  // Stack to store indices of prices
        
        // Traverse all stock prices
        for (int i = 0; i < n; i++) {
            // Pop elements from stack while they are less than or equal to the current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            
            // If stack is empty, all previous prices are less than or equal to the current price
            if (stack.isEmpty()) {
                span[i] = i + 1;  // Span is the entire range from the start to the current day
            } else {
                // Otherwise, the span is the difference between current index and the index on top of the stack
                span[i] = i - stack.peek();
            }
            
            // Push the current index onto the stack
            stack.push(i);
        }
        
        return span;
    }

    // Main function for testing
    public static void main(String[] args) {
        int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
        
        // Call the calculateSpan function
        int[] span = calculateSpan(prices);
        
        // Print the span values
        for (int i = 0; i < span.length; i++) {
            System.out.println("Price: " + prices[i] + ", Span: " + span[i]);
        }
    }
}
