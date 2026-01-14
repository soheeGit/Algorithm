import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++) {
                arr[0][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++) {
                arr[1][j] = Integer.parseInt(st.nextToken());
            }
            
            sb.append(solve(n, arr)).append("\n");
        }
        
        System.out.println(sb);
    }
    static int solve(int n, int[][] arr) {
        if (n == 1) {
            return Math.max(arr[0][0], arr[1][0]);
        }
        
        int[][] dp = new int[2][n];
        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        dp[0][1] = arr[0][1] + arr[1][0];
        dp[1][1] = arr[1][1] + arr[0][0];
        
        for(int i=2; i<n; i++) {
            dp[0][i] = arr[0][i] + Math.max(dp[1][i - 1], dp[1][i - 2]);
            dp[1][i] = arr[1][i] + Math.max(dp[0][i - 1], dp[0][i - 2]);
        }
        
        return Math.max(dp[0][n-1], dp[1][n-1]);
    }
}