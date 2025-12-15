import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] board;
    static int[][] maxDp;
    static int[][] minDp;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        board = new int[N][3];
        maxDp = new int[N][3];
        minDp = new int[N][3];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
            board[i][2] = Integer.parseInt(st.nextToken());
        }
        
        solve();
        
        sb.append(max).append(" ").append(min);
        System.out.println(sb);
    }
    static void solve() {        
        for(int i=0; i<3; i++) {
            maxDp[0][i] = board[0][i];
            minDp[0][i] = board[0][i];
        }
        
        for(int i=1; i<N; i++) {
            maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + board[i][0];
            minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + board[i][0];
            
            maxDp[i][1] = Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + board[i][1];
            minDp[i][1] = Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + board[i][1];
            
            maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + board[i][2];
            minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + board[i][2];
        }
        
        for(int i=0; i<3; i++) {
            max = Math.max(max, maxDp[N - 1][i]);
            min = Math.min(min, minDp[N - 1][i]);
        }
    }
}