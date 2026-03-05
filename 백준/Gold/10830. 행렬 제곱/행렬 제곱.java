import java.util.*;
import java.io.*;

class Main {
    static int N;
    static long B;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        arr = new int[N][N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] result = solve(B);
        
        for(int[] re : result) {
            for(int r : re) {
                System.out.print(r % 1000 + " ");
            }
            System.out.println();
        }
    }
    static int[][] solve(long b) {
        if(b == 1) return arr;
        
        int[][] temp = solve(b / 2);
        
        if(b % 2 == 0) {
            return multiply(temp, temp);
        }else {
            return multiply(multiply(temp, temp), arr);
        }
    }
    static int[][] multiply(int[][] a, int [][] b) {
        int[][] result = new int[N][N];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int z=0; z<N; z++) {
                    result[i][j] = (result[i][j] + a[i][z] * b[z][j]) % 1000;
                }
            }
        }
        return result;
    }
}