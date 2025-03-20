package linearBinarySeachAlgo;

import java.util.Scanner;

public class firstNegativeNumber{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter element you want to search ");
        int search = sc.nextInt();
        int result = findNumber(arr, search);
        System.out.println("Element found at index "+ result);
    }

    public static int findNumber(int[] arr,int n){
        if(arr.length == 0){
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == n){
                return i;
            }
        }
        return -1;
    }
}