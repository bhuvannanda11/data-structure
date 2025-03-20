package linearBinarySeachAlgo;

public class rotationPoint {
    public static void main(String[] args) {
        int[] rotatedArray = {15, 18, 2, 3, 6, 12};
        int rotationPointIndex = findRotationPoint(rotatedArray);

        System.out.println("The rotation point is at index: " + rotationPointIndex);
        System.out.println("The smallest element is: " + rotatedArray[rotationPointIndex]);
    }

    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {

                left = mid + 1;
            } else {

                right = mid;
            }
        }
        return left;
    }
}
