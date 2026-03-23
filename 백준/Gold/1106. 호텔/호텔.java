import java.util.*;
import java.io.*;

class Main {
    static int C, N;
    static int[] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new int[C + 101];
        arr = new int[2][N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int cost = Integer.parseInt(st.nextToken());
            int cust = Integer.parseInt(st.nextToken());
            
            arr[0][i] = cost;
            arr[1][i] = cust;
        }
        solve();
    }
    static void solve() {
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i=0; i<N; i++) {
            int cost = arr[0][i];
            int cust = arr[1][i];
            
            for(int j=cust; j<C + 101; j++) {
                if(dp[j - cust] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - cust] + cost, dp[j]);
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for(int i=C; i<C + 101; i++) {
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }
}