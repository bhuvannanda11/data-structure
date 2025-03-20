package linearBinarySeachAlgo;

import java.util.*;
public class reverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter input String");
        String input = sc.nextLine();
        String result=resultString(input);
        System.out.println("Reversed String is "+ result);

    }
    public static String resultString(String input){
        StringBuilder result = new StringBuilder();
        for(int i= input.length()-1; i>=0; i--){
            result.append(input.charAt(i));
        }
        return result.toString();
    } 
}
