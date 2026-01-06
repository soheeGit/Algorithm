import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];
        
        for(int i=1; i<=n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j=1; j * j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        System.out.println(dp[n]);
    }
}