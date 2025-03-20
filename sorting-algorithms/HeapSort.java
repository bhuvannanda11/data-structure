import java.util.Arrays;

public class HeapSort{

    // Function to implement Heap Sort
    public static void heapSort(int[] salaries) {
        int n = salaries.length;
        
        // Build a Max Heap (Rearrange the array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }
        
        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move the current root to the end of the array
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;
            
            // Reheapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Function to heapify a subtree rooted at index i
    private static void heapify(int[] salaries, int n, int i) {
        int largest = i;  // Initialize largest as root
        int left = 2 * i + 1;  // Left child index
        int right = 2 * i + 2;  // Right child index
        
        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }
        
        // If right child is larger than the largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }
        
        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;
            
            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    public static void main(String[] args) {
        // Example salary demands array (representing job applicants' salary expectations)
        int[] salaryDemands = {55000, 75000, 60000, 45000, 90000, 80000, 40000};
        
        System.out.println("Original salary demands: " + Arrays.toString(salaryDemands));
        
        // Call heapSort to sort the salary demands
        heapSort(salaryDemands);
        
        // Display the sorted salary demands
        System.out.println("Sorted salary demands: " + Arrays.toString(salaryDemands));
    }
}
