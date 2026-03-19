import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static Queue<int[]> queue;
    static List<int[]> melt;
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
        
        int result = 0;
        while(true) {
            visited = new boolean[N][M];
            queue = new LinkedList<>();
            melt = new ArrayList<>();
            
            queue.add(new int[]{0, 0});
            visited[0][0] = true;
            
            solve();
            boolean r = cheeze();
            
            if(!r) break;
            result++;
        }
        
        System.out.println(result);
    }
    static void solve() {
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowx = now[0];
            int nowy = now[1];
            
            int num = 0;
            for(int i=0; i<4; i++) {
                int nextx = nowx + dx[i];
                int nexty = nowy + dy[i];
                
                if(nextx < 0 || nexty < 0 || nextx >= N || nexty >= M) continue;
                if(visited[nextx][nexty]) continue;
                
                if(arr[nextx][nexty] == 0) {
                    visited[nextx][nexty] = true;
                    queue.add(new int[]{nextx, nexty});
                }
            }
        }
    }
    static boolean cheeze() {
        boolean melted = false;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(visited[i][j] || arr[i][j] == 0) continue;
                
                int num = 0;
                for(int z=0; z<4; z++) {
                    int x = i + dx[z];
                    int y = j + dy[z];
                    
                    if(x < 0 || y < 0 || x >= N || y >= M) continue;
                    if(visited[x][y]) num++;
                }
                
                if(num >= 2) {
                    melt.add(new int[]{i, j});
                }
            }
        }
        
        for(int[] m : melt){
            arr[m[0]][m[1]] = 0;
            melted = true;
        }
        
        return melted;
    }
}