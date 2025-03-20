package linearBinarySeachAlgo;

import java.util.*;

public class specificWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of sentences in an array ");
        int n = sc.nextInt();
        String[] arr = new String[n];
        System.out.println("Enter sentences ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLine();
        }
        System.out.println("Enter word you want to search ");
        String word = sc.nextLine();
        String result = findWord(arr, word);
        System.out.println("Word found in the sentence "+ result);
    }

    public static String findWord(String[] arr, String word){
        if(arr.length == 0){
            return "Not Found";
        }

        for (String sentence : arr) {
            String[] words = sentence.split(" ");
            for(String w : words){
                if(checkWords(w, word)){
                    return sentence;
                }
            }
           
        }
        return "Not Found";
    }


    public static boolean checkWords(String word1, String word2){
        if(word1.length() != word2.length()){
            return false;
        }

        for(int i = 0; i<word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                return false;
            }
        }
        return true;
    }

}
