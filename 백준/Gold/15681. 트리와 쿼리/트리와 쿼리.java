import java.util.*;
import java.io.*;

class Main {
    static int N, R, Q;
    static int[] dp;
    static List<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        dp = new int[N + 1];
        tree = new ArrayList[N + 1];
        for(int i=1; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        
        solve(R, -1);
        
        for(int i=0; i<Q; i++) {
            int a = Integer.parseInt(br.readLine());
            sb.append(dp[a]).append("\n");
        }
        
        System.out.println(sb);
    }
    static int solve(int now, int parent) {
        dp[now] = 1;

        for(int next : tree[now]) {
            if(next != parent) {
                dp[now] += solve(next, now);
            }
        }
        return dp[now];
    }
}