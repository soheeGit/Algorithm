import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new char[N][M];
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                char c = s.charAt(j);
                if(c == 'I') {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
                campus[i][j] = s.charAt(j);
            }
        }

        bfs();
        
    }
    static void bfs() {
        int result = 0;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            
            for(int i=0; i<4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(campus[nx][ny] == 'X') continue;
                
                visited[nx][ny] = true;
                
                if(campus[nx][ny] == 'P') result++;
                queue.offer(new int[]{nx, ny});
            }
        }
        
        if(result == 0) {
            System.out.println("TT");
        }else {
            System.out.println(result);
        }
    }
}