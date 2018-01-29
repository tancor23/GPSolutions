import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        arrayMultiplication();
    }
 
    private static void arrayMultiplication() throws IOException {
 
        FastScanner fs = new FastScanner("input.txt");
 
        final int m = fs.nextInt();
        final int n = fs.nextInt();
        final int i = fs.nextInt();
        final int j = fs.nextInt();
        final int p = fs.nextInt();
 
        int[][] arrayMiddle;
        int[][][] array = new int[m][n][n];
 
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                for (int z = 0; z < n; z++) {
                    array[x][y][z] = fs.nextInt();
                }
            }
        }
 
        arrayMiddle = array[0];
        for (int x = 1; x < m; x++) {
            arrayMiddle = multiplication(arrayMiddle, array[x], p, n);
        }
 
        PrintWriter out = new PrintWriter(new File("output.txt"));
        out.print(arrayMiddle[i - 1][j - 1]);
        out.close();
    }
 
    private static int[][] multiplication(int[][] arrayA, int[][] arrayB, int p, int n) {
        
        int middle;
        int[][] arrayMiddle = new int[n][n];
        int[][] arrayBB = new int[n][n];
 
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                arrayBB[i][j] = arrayB[j][i];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                middle = 0;
                for (int k = 0; k < n; ++k) {
                    middle += arrayA[i][k] * arrayBB[j][k];
                }
                if (middle >= p) {
                    middle %= p;
                }
                arrayMiddle[i][j] = middle;
            }
        }
        return arrayMiddle;
    }
 
    static class FastScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;
 
        public FastScanner(String fileName) throws IOException {
            reader = new BufferedReader(new FileReader(fileName));
        }
 
        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line = reader.readLine();
                if (line == null) {
                    throw new EOFException();
                }
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}