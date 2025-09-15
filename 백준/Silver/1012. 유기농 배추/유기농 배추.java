import java.io.*;
import java.util.*;

class Main {
    static int M, N, K;
    static int[][] bachu;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int T = Integer.parseInt(st.nextToken());
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            bachu = new int[M][N];
            visited = new boolean[M][N];
            
            for(int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                bachu[X][Y] = 1;
            }
            int result = solve();
            System.out.println(result);
        }
    }
    static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for(int i=0; i<4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if(a >= 0 && b >= 0 && a < M && b < N)
                if(!visited[a][b] && bachu[a][b] == 1) dfs(a, b);
        }
    }
    static int solve() {
        int count = 0;
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(bachu[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j); 
                    count++;
                }
            }
        }
        return count;
    }
}