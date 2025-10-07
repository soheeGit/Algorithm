import java.util.*;
import java.io.*;

class Main {
    static int n, k;
    static int[] coin;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        coin = new int[n];
        dp = new int[k+1];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        solve();
        System.out.println(dp[k]);
    }
    static void solve() {
        dp[0] = 1;
        for(int c : coin) {
            for(int i=c; i<=k; i++) {
                dp[i] += dp[i-c];
            }
        }
    }
}
