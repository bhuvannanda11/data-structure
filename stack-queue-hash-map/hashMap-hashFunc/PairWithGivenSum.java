import java.util.HashSet;

public class PairWithGivenSum {

    // Function to check if there exists a pair with the given sum
    public static boolean hasPairWithSum(int[] arr, int target) {
        // HashSet to store visited elements
        HashSet<Integer> seenNumbers = new HashSet<>();

        // Iterate through the array
        for (int num : arr) {
            // Calculate the complement (target - current element)
            int complement = target - num;

            // If complement exists in the set, return true
            if (seenNumbers.contains(complement)) {
                return true;
            }

            // Add the current element to the set
            seenNumbers.add(num);
        }

        // No pair found
        return false;
    }

    // Main function for testing
    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        boolean result = hasPairWithSum(arr, target);

        if (result) {
            System.out.println("There exists a pair with the given sum.");
        } else {
            System.out.println("No pair exists with the given sum.");
        }
    }
}
