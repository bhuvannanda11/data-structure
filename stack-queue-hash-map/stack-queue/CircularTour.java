public class CircularTour {

    // Function to find the starting pump index for completing the circular tour
    public static int circularTour(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalSurplus = 0;  // To track total surplus of petrol
        int currentSurplus = 0;  // Surplus for the current tour
        int startingPump = 0;  // The potential starting point

        // Traverse all petrol pumps
        for (int i = 0; i < n; i++) {
            // Calculate the surplus for the current pump
            totalSurplus += petrol[i] - distance[i];
            currentSurplus += petrol[i] - distance[i];

            // If currentSurplus becomes negative, reset the starting point
            if (currentSurplus < 0) {
                // We can't complete the tour starting from current pump, so reset
                startingPump = i + 1;
                currentSurplus = 0;  // Reset the surplus for the new start
            }
        }

        // If total surplus is negative, it's not possible to complete the circular tour
        if (totalSurplus < 0) {
            return -1;  // Indicating no valid start point
        }

        // Otherwise, the starting point is valid
        return startingPump;
    }

    // Main function for testing
    public static void main(String[] args) {
        // Example petrol and distance arrays
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = circularTour(petrol, distance);

        if (start == -1) {
            System.out.println("No solution possible.");
        } 
        else {
            System.out.println("The starting point for the circular tour is pump index: " + start);
        }
    }
}
