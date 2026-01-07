import java.util.*;
import java.io.*;

class Main {
    static long[] dp;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new long[n + 1];
            P(n);
            System.out.println(dp[n]);
        }
    }

    static void P(int n) {
        if(n >= 1) dp[1] = 1;
        if(n >= 2) dp[2] = 1;
        if(n >= 3) dp[3] = 1;

        for(int i = 4; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
    }
}