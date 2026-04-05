import java.util.*;
import java.io.*;

class Main {
    static int N, M, result = 0;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        solve();
    }
    static void solve() {
        int year = 0;
        
        while(true) {
            int result = check();
            
            if(result >= 2) {
                System.out.println(year);
                return;
            }else if(result == 0) {
                System.out.println(0);
                return;
            }
            
            year++;
            melt();
        }
    }
    static void melt() {
        int[][] melt = new int[N][M];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] > 0) {
                    for(int z=0; z<4; z++) {
                        int nextX = i + dx[z];
                        int nextY = j + dy[z];
                        
                        if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                        if(arr[nextX][nextY] == 0) melt[i][j]++;
                    }
                }
            }
        }
        
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] > 0) arr[i][j] = Math.max(0, arr[i][j] - melt[i][j]);
            }
        }
    }
    static void bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowx = now[0];
            int nowy = now[1];
            
            for(int i=0; i<4; i++) {
                int nextX = nowx + dx[i];
                int nextY = nowy + dy[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if(arr[nextX][nextY] > 0 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
    static int check() {
        boolean[][] visited = new boolean[N][M];
        int count = 0;
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j, visited);
                    count++;
                }
            }
        }
        
        return count;
    }
}