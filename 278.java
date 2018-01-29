import java.io.*;
import java.util.*;
  
public class Main {
    public static void main(String[] argv) throws IOException {
  
        String worldNo = "NO";
        String worldYes = "YES";
  
  
        try {
            while (true) {
                Scanner in = new Scanner(new File("input.txt"));
  
                String stringS = in.nextLine();
                String stringT = in.nextLine();
                int worldBreak = 0;
  
  
                PrintWriter out = new PrintWriter(new File("output.txt"));
  
                if (stringS.isEmpty()) {
                    out.println(worldYes);
                    out.close();
                    break;
                }
  
                if (stringT.isEmpty() && !stringS.isEmpty()) {
                    out.println(worldNo);
                    out.close();
                    break;
                }
                if (stringS.equals(stringT)) {
                    out.println(worldYes);
                    out.close();
                    break;
                }
  
                char arrayS[] = stringS.toCharArray();
                char arrayT[] = stringT.toCharArray();
  
                int sizeArrayS = arrayS.length;
                int sizeArrayT = arrayT.length;
                int numberBreak = 0;
  
                if (sizeArrayS > sizeArrayT) {
                    out.println(worldNo);
                    out.close();
                  break;
                } else {
                    for (int i = 0, middle = 0, q = 0; i < sizeArrayS; i++) {
                        for (int j = middle; j < sizeArrayT; j++) {
                            if (arrayT[j] == arrayS[i]) {
                                q++;
                                if (i == sizeArrayS - 1 && q == sizeArrayS) {
                                    numberBreak++;
                                    out.println(worldYes);
                                    out.close();
                                    break;
                                }
                                middle = j + 1;
                                break;
                            }
                            if (sizeArrayT - j < sizeArrayS - i) {
                                worldBreak++;
                                out.println(worldNo);
                                out.close();
                                break;
                            }
                        }
                        if (numberBreak > 0 || worldBreak>0) {
                            break;
                        }
                    }
                    if (numberBreak == 0) {
                        out.println(worldNo);
                        out.close();
                        break;
                    }
                    if (numberBreak > 0 || worldBreak>0) {
                        break;
                    }
                }
            }
        } catch (NoSuchElementException e) {
        }
    }
}