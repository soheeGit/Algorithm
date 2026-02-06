import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            solve(N, M);
        }
    }
    static void solve(int N, int M) {
        int[][] dp = new int[M + 1][N + 1];
        for(int i = 0; i <= M; i++) {
            dp[i][0] = 1;
            if(i <= N) dp[i][i] = 1;
        }
        
        for(int i = 1; i <= M; i++) {
            for(int j = 1; j <= N && j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        System.out.println(dp[M][N]);
    }
}