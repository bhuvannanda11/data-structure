package linearBinarySeachAlgo;

import java.util.*;

public class concatenateString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of strings ");
        int n = sc.nextInt();
        String[] sentence = new String[n];
        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = sc.nextLine();
        }
        String result = resultString(sentence);
        System.out.println("Resultant concatenated String will be "+ result);
    }

    public static String  resultString(String[] arr){
        StringBuffer result = new StringBuffer();
        for(String s:arr){
            result.append(s);
            result.append(" ");
        }
        return result.toString();
    }
}