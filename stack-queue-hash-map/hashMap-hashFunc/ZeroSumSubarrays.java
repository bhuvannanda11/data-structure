import java.util.*;

public class ZeroSumSubarrays {

    // Function to find all subarrays with zero sum
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int cumulativeSum = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Update the cumulative sum
            cumulativeSum += arr[i];

            // If cumulative sum is zero, the subarray from index 0 to i has zero sum
            if (cumulativeSum == 0) {
                result.add(Arrays.copyOfRange(arr, 0, i + 1));
            }

            // If cumulative sum is found in the map, there are subarrays whose sum is zero
            if (map.containsKey(cumulativeSum)) {
                List<Integer> indices = map.get(cumulativeSum);

                // Add the subarrays that sum to zero by using the indices stored in the map
                for (int index : indices) {
                    result.add(Arrays.copyOfRange(arr, index + 1, i + 1));
                }
            }

            // Add the current index to the list of indices of this cumulative sum
            map.computeIfAbsent(cumulativeSum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }

    // Main function for testing
    public static void main(String[] args) {
        int[] arr = {6, -1, 3, -3, 4, -2, 2, 2, -3, 3};

        List<int[]> subarrays = findZeroSumSubarrays(arr);

        // Print the zero-sum subarrays
        System.out.println("Subarrays with zero sum:");
        for (int[] subarray : subarrays) {
            System.out.println(Arrays.toString(subarray));
        }
    }
}
