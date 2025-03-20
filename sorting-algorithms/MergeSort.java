import java.util.Arrays;

public class MergeSort {

    // Main function to sort the array using Merge Sort
    public static void mergeSort(double[] prices) {
        if (prices.length <= 1) {
            return;
        }
        
        // Split the array into two halves
        int mid = prices.length / 2;
        double[] left = Arrays.copyOfRange(prices, 0, mid);
        double[] right = Arrays.copyOfRange(prices, mid, prices.length);
        
        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);
        
        // Merge the sorted halves
        merge(prices, left, right);
    }

    // Function to merge two sorted arrays
    private static void merge(double[] prices, double[] left, double[] right) {
        int i = 0, j = 0, k = 0;
        
        // Merge the two arrays while there are elements in both
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                prices[k] = left[i];
                i++;
            } else {
                prices[k] = right[j];
                j++;
            }
            k++;
        }
        
        // If there are remaining elements in the left array
        while (i < left.length) {
            prices[k] = left[i];
            i++;
            k++;
        }
        
        // If there are remaining elements in the right array
        while (j < right.length) {
            prices[k] = right[j];
            j++;
            k++;
        }
    }

    // Main function to test the Merge Sort
    public static void main(String[] args) {
        double[] prices = {19.99, 5.49, 12.99, 7.49, 23.89, 9.99};
        
        System.out.println("Original prices:");
        System.out.println(Arrays.toString(prices));
        
        // Sort the array
        mergeSort(prices);
        
        System.out.println("Sorted prices:");
        System.out.println(Arrays.toString(prices));
    }
}
