import java.util.*;
import java.io.*;

class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=0; i<T; i++) {
            n = Integer.parseInt(br.readLine());
            dp(dp);
            System.out.println(dp[n]);
        }
    }
    static void dp(int[] dp) {
        for(int i=4; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
    }
}