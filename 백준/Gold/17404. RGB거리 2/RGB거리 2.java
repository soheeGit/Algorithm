import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int result = Integer.MAX_VALUE;
        for(int i=0; i<3; i++) {
            result = Math.min(result, solve(i));
        }
        
        System.out.println(result);
    }
    static int solve(int first) {
        int[][] dp = new int[N][3];
        int INF = 1_000_000_000;
        
        for(int i=0; i<3; i++) dp[0][i] = INF;
        dp[0][first] = cost[0][first];
        
        for(int i=1; i<N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }
        
        int res = Integer.MAX_VALUE;

        for(int last=0; last<3; last++) {
            if(last == first) continue;
            res = Math.min(res, dp[N-1][last]);
        }

        return res;
    }
}