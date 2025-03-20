public class BubbleSort {

    // Method to sort student marks using Bubble Sort
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        
        // Traverse through the array
        for (int i = 0; i < n - 1; i++) {
            // Compare each pair of adjacent marks
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap if the current mark is greater than the next
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Array of student marks
        int[] studentMarks = {95, 85, 70, 60, 100, 90, 80, 75};

        System.out.println("Before Sorting: ");
        for (int mark : studentMarks) {
            System.out.print(mark + " ");
        }

        // Call the bubbleSort method to sort the marks
        bubbleSort(studentMarks);

        System.out.println("\nAfter Sorting: ");
        for (int mark : studentMarks) {
            System.out.print(mark + " ");
        }
    }
}
