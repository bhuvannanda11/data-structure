import java.util.HashSet;

public class LongestConsecutiveSequence {

    // Function to find the length of the longest consecutive elements sequence
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Store all elements in a hash set for O(1) lookup
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Iterate through each number in the array
        for (int num : numSet) {
            // Only start a sequence if num-1 is not in the set (this is the start of a sequence)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Keep checking for the next consecutive number
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Update the longest streak found
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    // Main function for testing
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(nums);
        System.out.println("Length of the longest consecutive sequence: " + result);
    }
}
