package linearBinarySeachAlgo;


import java.util.*;
public class peakElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int peak = binarySearch(arr, 0, arr.length - 1);
        
        if (peak != -1) {
            System.out.println("Peak element found: " + peak );
        } else {
            System.out.println("No peak element found.");
        }
    }

    public static int binarySearch(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0) {
            return -1; 
        } 
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPeak(arr, mid)) {
                return arr[mid];
            } 
            else if (mid > 0 && arr[mid] <= arr[mid - 1]) {
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static boolean isPeak(int[] arr, int mid) {
        int n = arr.length;

        boolean leftCheck = (mid == 0 || arr[mid] > arr[mid - 1]);
        boolean rightCheck = (mid == n - 1 || arr[mid] > arr[mid + 1]);

        return leftCheck && rightCheck;
    }
}