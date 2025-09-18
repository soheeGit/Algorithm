import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int[][] distance, ground;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ground = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            Arrays.fill(distance[i], -1);
        }
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                if(ground[i][j] == 2) {
                    q.add(new int[]{i, j});
                    distance[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }
        
        bfs();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(ground[i][j] == 0) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    static void bfs() {
        while(true) {
            if(q.isEmpty()) {
                break;
            }
            int[] num = q.poll();
            for(int i=0; i<4; i++) {
                int nx = num[0] + dx[i];
                int ny = num[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(ground[nx][ny] == 0 || visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                distance[nx][ny] = distance[num[0]][num[1]]+1;
                q.add(new int[]{nx, ny});
            }
        }
    }
}