import java.util.Arrays;

public class CountingSort {
    
    // Function to implement Counting Sort
    public static void countingSort(int[] ages) {
        // Find the range of the ages (from 10 to 18)
        int range = 18 - 10 + 1;  // Range is 9 (10, 11, ..., 18)
        
        // Create a count array to store the frequency of each age
        int[] count = new int[range];
        
        // Fill the count array with the frequency of each age
        for (int i = 0; i < ages.length; i++) {
            count[ages[i] - 10]++;
        }
        
        // Compute cumulative frequencies
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        
        // Create an output array to store the sorted ages
        int[] output = new int[ages.length];
        
        // Build the output array using the cumulative count array
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - 10] - 1] = age;  // Place the age in the correct position
            count[age - 10]--;  // Decrease the count for the placed age
        }
        
        // Copy the sorted output array to the original ages array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        // Example array of student ages
        int[] studentAges = {14, 12, 16, 10, 18, 15, 14, 13, 11, 17};
        
        System.out.println("Original student ages: " + Arrays.toString(studentAges));
        
        // Call countingSort to sort the ages
        countingSort(studentAges);
        
        // Display the sorted student ages
        System.out.println("Sorted student ages: " + Arrays.toString(studentAges));
    }
}
