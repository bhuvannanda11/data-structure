import java.util.*;

public class TwoSum {

    // Function to find indices of the two numbers that add up to the target
    public static int[] twoSum(int[] nums, int target) {
        // HashMap to store the number and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If complement is already in the map, return the indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Otherwise, add the current number and its index to the map
            map.put(nums[i], i);
        }

        // Return an empty array if no solution exists (though problem guarantees a solution)
        return new int[] {};
    }

    // Main function for testing
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Get the result of two indices whose values sum up to the target
        int[] result = twoSum(nums, target);

        if (result.length == 2) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } 
        else {
            System.out.println("No solution found");
        }
    }
}
