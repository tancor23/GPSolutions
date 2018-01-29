import java.io.*;
import java.util.*;
 
 
public class Main {
    public static void main(String[] args) throws IOException {
        int positiveNumber = 0, negativeNumber = 0, countOfPositive = 0, countOfNegative = 0;
        String text;
        String text1 = "";
 
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
 
            while (line != null) {
                sb.append(line);
                sb.append(" ");
                line = br.readLine();
            }
            String everything = sb.toString();
 
            int[] numArr = Arrays.stream(everything.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 1; i < numArr.length; i++) {
                if (numArr[i] >= 0) {
                    positiveNumber += numArr[i];
                    countOfPositive++;
                } else {
                    negativeNumber += numArr[i];
                    countOfNegative++;
                }
            }
 
            if (positiveNumber >= Math.abs(negativeNumber)) {
 
                text = Integer.toString(countOfPositive);
                for (int i = 1; i < numArr.length; i++) {
                    if (numArr[i] >= 0) {
                        text1 += Integer.toString(i);
                        text1 += " ";
                         
                    }
                }
 
            } else {
                text = Integer.toString(countOfNegative);
                for (int i = 1; i < numArr.length; i++) {
                    if (numArr[i] < 0) {
                        text1 += Integer.toString(i);
                        text1 += " ";
                    }
                }
            }
 
            PrintWriter out = new PrintWriter(new File("output.txt"));
            out.println(text);
            out.print(text1);
            out.close();
 
        }
    }
}