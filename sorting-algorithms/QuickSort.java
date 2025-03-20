import java.util.Arrays;

public class QuickSort {
    
    // Function to implement Quick Sort
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(prices, low, high);
            
            // Recursively apply quick sort to left and right subarrays
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Function to partition the array around the pivot element
    private static int partition(int[] prices, int low, int high) {
        // Choose the pivot element (for simplicity, using the last element as the pivot)
        int pivot = prices[high];
        int i = (low - 1);  // Index of smaller element
        
        // Loop through the array to partition it into two parts
        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot, swap it
            if (prices[j] <= pivot) {
                i++;
                // Swap prices[i] and prices[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        
        // Swap the pivot element to its correct position
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        
        // Return the pivot index
        return i + 1;
    }

    public static void main(String[] args) {
        // Example product prices array
        int[] prices = { 150, 90, 200, 75, 50, 300, 100, 180 };
        
        System.out.println("Original prices: " + Arrays.toString(prices));
        
        // Call quickSort on the entire array
        quickSort(prices, 0, prices.length - 1);
        
        // Display the sorted product prices
        System.out.println("Sorted prices: " + Arrays.toString(prices));
    }
}
