import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] A, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        dp = new int[N + 1];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[1] = 1;
        solve();
        
        int max = 0;
        for(int i=1; i<=N; i++) {
            max = Math.max(max, dp[i]);
        }
            
        System.out.println(max);
    }
    static void solve() {
        for(int i=1; i<=N; i++) {
            dp[i] = 1;
            for (int j=1; j<i; j++) {
                if(A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    }
}