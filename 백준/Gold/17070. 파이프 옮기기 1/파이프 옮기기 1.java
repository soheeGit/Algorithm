import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] arr;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N][3];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[0][1][0] = 1;
        solve();
        
        int ans = dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
        System.out.println(ans);
    }
    
    static void solve() {
    for(int r=0; r<N; r++) {
        for(int c=0; c<N; c++) {
            if(arr[r][c] == 1) continue;

            if(dp[r][c][0] > 0) {

                if(c+1 < N && arr[r][c+1] == 0)
                    dp[r][c+1][0] += dp[r][c][0];

                if(r+1 < N && c+1 < N &&
                   arr[r][c+1] == 0 &&
                   arr[r+1][c] == 0 &&
                   arr[r+1][c+1] == 0)
                    dp[r+1][c+1][2] += dp[r][c][0];
            }

            if(dp[r][c][1] > 0) {

                if(r+1 < N && arr[r+1][c] == 0)
                    dp[r+1][c][1] += dp[r][c][1];

                if(r+1 < N && c+1 < N &&
                   arr[r][c+1] == 0 &&
                   arr[r+1][c] == 0 &&
                   arr[r+1][c+1] == 0)
                    dp[r+1][c+1][2] += dp[r][c][1];
            }

            if(dp[r][c][2] > 0) {

                if(c+1 < N && arr[r][c+1] == 0)
                    dp[r][c+1][0] += dp[r][c][2];

                if(r+1 < N && arr[r+1][c] == 0)
                    dp[r+1][c][1] += dp[r][c][2];

                if(r+1 < N && c+1 < N &&
                   arr[r][c+1] == 0 &&
                   arr[r+1][c] == 0 &&
                   arr[r+1][c+1] == 0)
                    dp[r+1][c+1][2] += dp[r][c][2];
            }
        }
    }
}

}