import java.util.Arrays;

public class SelectionSort {
    
    // Function to implement Selection Sort
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        
        // Move through the entire array
        for (int i = 0; i < n - 1; i++) {
            // Find the index of the minimum element in the unsorted portion
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;  // Update the index of the minimum element
                }
            }
            
            // Swap the found minimum element with the first element of the unsorted portion
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        // Example exam scores array
        int[] examScores = {85, 92, 78, 63, 99, 55, 88, 76};
        
        System.out.println("Original exam scores: " + Arrays.toString(examScores));
        
        // Call selectionSort to sort the exam scores
        selectionSort(examScores);
        
        // Display the sorted exam scores
        System.out.println("Sorted exam scores: " + Arrays.toString(examScores));
    }
}
