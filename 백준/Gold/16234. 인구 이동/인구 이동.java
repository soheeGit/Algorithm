import java.util.*;
import java.io.*;

class Main {
    static int N, L, R, time = 0;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        A = new int[N][N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        while(true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j]) {
                        if(bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if(!moved) break;
            time++;
        }
        
        System.out.println(time);
    }
    static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();

        queue.add(new int[]{x, y});
        list.add(new int[]{x, y});
        visited[x][y] = true;

        int sum = A[x][y];
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowx = now[0];
            int nowy = now[1];
            
            for(int i=0; i<4; i++) {
                int nx = nowx + dx[i];
                int ny = nowy + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;
                
                int diff = Math.abs(A[nowx][nowy] - A[nx][ny]);
                if(diff > R || diff < L) continue;
                
                list.add(new int[]{nx, ny});
                queue.add(new int[]{nx, ny});
                sum += A[nx][ny];
                
                visited[nx][ny] = true;
            }
        }
        
        int size = list.size();
        if(size == 1) return false;
        
        int count = sum/size;
        for(int[] l : list) {
            int lx = l[0];
            int ly = l[1];
            
            A[lx][ly] = count;
        }
        
        return true;
    }
}