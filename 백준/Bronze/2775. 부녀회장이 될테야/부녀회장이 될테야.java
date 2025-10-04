import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(solve(k, n));
        }
    }
    static int solve(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        for(int i=1; i<=n; i++) {
            dp[0][i] = i;
        }
        
        for(int i=1; i<=k; i++) {
            for(int j=1; j<=n; j++) {
                if(j == 1) dp[i][j] = 1;
                else dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        
        return dp[k][n];
    }
}