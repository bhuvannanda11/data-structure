package linearBinarySeachAlgo;
import java.util.*;

public class compareEfficiency {
    public static void main(String[] args) {
        int n = 1000000;
        String text = "hello";

        long startTime1 = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        
        for (int i = 0; i < n; i++) {
            stringBuffer.append(text);
        }
        
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;

        long startTime2 = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            stringBuilder.append(text);
        }
        
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;
        
        System.out.println("Time taken by StringBuffer: " + duration1 / 1_000_000 + " ms");
        System.out.println("Time taken by StringBuilder: " + duration2 / 1_000_000 + " ms");

    }
}
