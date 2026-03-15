import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][2];
        
        for(int i=1; i<=N; i++) {
            String s = br.readLine();
            for(int j=1; j<=M; j++) {
                arr[i][j] = s.charAt(j - 1) - '0';
            }
        }
        
        queue.add(new int[]{1, 1, 1, 0});
        visited[1][1][0] = true;
        
        int result = solve();
        
        System.out.println(result);
    }
    static int solve() {
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int dist = now[2];
            int wall = now[3];
            
            if(nowX == N && nowY == M) return dist;
            
            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                
                if(nextX < 1 || nextY < 1 || nextX > N || nextY > M) continue;
                
                if(arr[nextX][nextY] == 0 && !visited[nextX][nextY][wall]) {
                    queue.add(new int[]{nextX, nextY, dist + 1, wall});
                    visited[nextX][nextY][wall] = true;
                } else if(arr[nextX][nextY] == 1 && wall == 0) {
                    queue.add(new int[]{nextX, nextY, dist + 1, 1});
                    visited[nextX][nextY][1] = true;
                }
            }
        }
        return -1;
    }
}