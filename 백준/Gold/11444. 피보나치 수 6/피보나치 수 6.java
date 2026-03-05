import java.util.*;
import java.io.*;

class Main {
    static long n;
    static long[][] arr = {{1, 1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Long.parseLong(br.readLine());
        
        long[][] result = solve(n);
        System.out.println(result[0][1] % 1000000007);
    }
    static long[][] solve(long n) {
        if(n == 1) return arr;
        
        long[][] temp = solve(n / 2);
        
        if(n % 2 == 0) {
            return multiply(temp, temp);
        }else {
            return multiply(multiply(temp, temp), arr);
        }
    }
    static long[][] multiply(long[][] a, long[][] b) {
        long[][] result = new long[2][2];
        
        for(int i=0; i<2; i++) {
            for(int j=0; j<2; j++) {
                for(int z=0; z<2; z++) {
                    result[i][j] = (result[i][j] + a[i][z] * b[z][j]) % 1000000007;
                }
            }
        }
        
        return result;
    }
}