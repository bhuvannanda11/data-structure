package linearBinarySeachAlgo;


import java.util.*;

public class removeDuplicates {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter String ");
    String input = sc.nextLine();
    String result = withoutDuplicatesString(input);
    System.out.println("Resultant string will be "+ result);

  }  


  public static String withoutDuplicatesString(String input){
      StringBuilder result = new StringBuilder();
        HashSet<Character> isPresent = new HashSet<>();

        for(char ch : input.toCharArray()){
            if(!isPresent.contains(ch)){
                isPresent.add(ch);
                result.append(ch);
            }
        }
        return result.toString();
  }
}
