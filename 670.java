import java.io.*;
import java.util.*;
 

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arrayOfNumber;
 
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("input.txt")));
        int number = Integer.parseInt(bufferedReader.readLine());
 
        ArrayList<Integer> list = new ArrayList<>();
 
        for (int i = 1; i <= 26057; i++) {
            int numberForI = i;
            int numberForII = i;
            int count = 0;
            int elementOfArray = 0;
            int xFinal = 0;
 
            if (i <= 10) {
                list.add(i);
                continue;
            }
 
            while (numberForI > 0) {
                numberForI = numberForI / 10;
                count++;
            }
 
            arrayOfNumber = new int[count];
 
            while (numberForII > 0) {
                arrayOfNumber[elementOfArray] = numberForII % 10;
                numberForII = numberForII / 10;
                elementOfArray++;
            }
 
            for (int x = 0; x < arrayOfNumber.length - 1; x++) {
                for (int z = x + 1; z < arrayOfNumber.length; z++) {
                    if (arrayOfNumber[x] == arrayOfNumber[z]) {
                        xFinal++;
                        break;
                    }
                }
                if (xFinal > 0) {
                    break;
                }
            }
            if (xFinal > 0) {
            } else {
                list.add(i);
            }
            if (list.size() == number || list.size() >= number ) {
                break;
            }
        }
        PrintWriter out = new PrintWriter(new File("output.txt"));
        out.print(String.valueOf(list.get(number - 1)));
        out.close();
    }
}