package linearBinarySeachAlgo;


import java.util.*;
public class occurence {
    public static void main(String[] args) {
        int[] sortedArray = {2, 4, 4, 4, 6, 8, 10};
        int target = 4;

        int firstIndex = findFirstOccurrence(sortedArray, target);
        int lastIndex = findLastOccurrence(sortedArray, target);

        System.out.println("First occurrence of " + target + " is at index: " + firstIndex);
        System.out.println("Last occurrence of " + target + " is at index: " + lastIndex);
    }


    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
