public class InsertionSort {

    // Method to perform Insertion Sort on the array
    public static void insertionSort(int[] employeeIds) {
        // Traverse through the array from the second element
        for (int i = 1; i < employeeIds.length; i++) {
            int currentId = employeeIds[i];  // Element to be inserted into the sorted part
            int j = i - 1;
            
            // Shift elements of employeeIds[0..i-1] that are greater than currentId
            // to one position ahead of their current position
            while (j >= 0 && employeeIds[j] > currentId) {
                employeeIds[j + 1] = employeeIds[j];
                j = j - 1;
            }
            
            // Insert the currentId into its correct position
            employeeIds[j + 1] = currentId;
        }
    }

    // Main method to test the Insertion Sort
    public static void main(String[] args) {
        // Array of employee IDs
        int[] employeeIds = {101, 23, 56, 45, 78};

        System.out.println("Before Sorting:");
        // Print employee IDs before sorting
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }

        // Call the insertionSort method to sort the employee IDs
        insertionSort(employeeIds);

        System.out.println("\nAfter Sorting:");
        // Print employee IDs after sorting
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
    }
}
