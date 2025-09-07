import java.util.*;
import java.io.*;

class Main {
    static int result = 0;
    static int N, M;
    static int[][] connections;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        connections = new int[M][2];
        visited = new boolean[N+1];
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<2; j++) {
                connections[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1);
        System.out.println(result);
    }
    static void dfs(int n) {
        visited[n] = true;
        for(int i=0; i<M; i++) {
            int a = connections[i][0];
            int b = connections[i][1];

            if(a == n && !visited[b]) {
                result++;
                dfs(b);
            } else if(b == n && !visited[a]) {
                result++;
                dfs(a);
            }
        }
    }
}