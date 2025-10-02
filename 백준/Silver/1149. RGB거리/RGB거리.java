import java.util.*;
import java.io.*;

class Main {
    static int N, result = Integer.MAX_VALUE;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        st = new StringTokenizer(br.readLine(), " ");
        dp[0][0] = Integer.parseInt(st.nextToken());
        dp[0][1] = Integer.parseInt(st.nextToken());
        dp[0][2] = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            solve(a, b, c, i);
        }
        for(int i=0; i<3; i++) {
            result = Math.min(result, dp[N-1][i]);
        }
        System.out.println(result);
    }
    static void solve(int a, int b, int c, int i) {
        dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + a;
        dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + b;
        dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + c;
    }
}