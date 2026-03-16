import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];
        
        for(int i=1; i<=N; i++) {
            String s = br.readLine();
            for(int j=1; j<=M; j++) {
                arr[i][j] = s.charAt(j - 1) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        System.out.println(solve());
    }
    static int solve() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.add(new int[]{1, 1, 0});
        dist[1][1] = 0;
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0];
            int y = now[1];
            int cost = now[2];
            
            if(x == N && y == M) return dist[x][y];
            if(dist[x][y] < cost) continue;
            
            for(int i=0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                
                if(nextX < 1 || nextY < 1 || nextX > N || nextY > M) continue;
                
                int nextCost = cost + arr[nextX][nextY];
                
                if(nextCost < dist[nextX][nextY]) {
                    pq.add(new int[]{nextX, nextY, nextCost});
                    dist[nextX][nextY] = nextCost;
                }
            }
        }
        
        return dist[N][M];
    }
}