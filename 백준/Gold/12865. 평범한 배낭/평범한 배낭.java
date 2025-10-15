import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static int[][] dp;
    static int[][] subject;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+1][K+1];
        subject = new int[N+1][2];
        
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            subject[i][0] = Integer.parseInt(st.nextToken());
            subject[i][1] = Integer.parseInt(st.nextToken());
        }
        solve();
        System.out.println(dp[N][K]);
    }
    static void solve() {
        for(int i=1; i<=N; i++) {
            for(int j=0; j<=K; j++) {
                if(j >= subject[i][0]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - subject[i][0]] + subject[i][1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }
}