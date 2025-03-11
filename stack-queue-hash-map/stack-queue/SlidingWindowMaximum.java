import java.util.*;

public class SlidingWindowMaximum {

    // Function to find the maximum element in each sliding window of size k
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];  // Array to store the result
        Deque<Integer> deque = new LinkedList<>();  // Deque to store indices of elements

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices whose corresponding values are less than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.offerLast(i);

            // The first k-1 windows are not fully filled, so we start adding to the result array once i >= k - 1
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];  // The maximum is at the front of the deque
            }
        }

        return result;
    }

    // Main function for testing
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        // Print the result
        System.out.println("Sliding window maximums:");
        System.out.println(Arrays.toString(result));
    }
}
