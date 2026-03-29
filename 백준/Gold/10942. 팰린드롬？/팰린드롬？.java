import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] arr;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new boolean[N + 1][N + 1];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        init();
        
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            
            if(dp[S][E]) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        
        System.out.println(sb);
    }
    static void init() {
        for(int i=1; i<=N; i++) dp[i][i] = true;

        for(int i=1; i<N; i++) {
            if(arr[i] == arr[i+1]) dp[i][i+1] = true;
        }

        for(int len=3; len<=N; len++) {
            for(int i=1; i+len-1<=N; i++) {
                int j = i + len - 1;
                if(arr[i] == arr[j] && dp[i+1][j-1]) {
                    dp[i][j] = true;
                }
            }
        }
    }
}