import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        
        for(int i=1; i<=N; i++) {
            String s = br.readLine();
            for(int j=1; j<=M; j++) {
                arr[i][j] = s.charAt(j - 1) - '0';
            }
        }
        queue.add(new int[]{1, 1});
        visited[1][1] = true;
        
        System.out.println(bfs());
    }
    static int bfs() {
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowN = now[0];
            int nowM = now[1];
            
            if(nowN == N && nowM == M) {
                return arr[nowN][nowM];
            }
            
            for(int i=0; i<4; i++) {
                int nextN = nowN + dx[i];
                int nextM = nowM + dy[i];
                if(nextN <= N && nextM <= M && nextN > 0 && nextM > 0) {
                    if(arr[nextN][nextM] != 0 && !visited[nextN][nextM]) {
                        visited[nextN][nextM] = true;
                        queue.add(new int[]{nextN, nextM});
                        arr[nextN][nextM] = arr[nowN][nowM] + 1;
                    }
                }
            }
        }
        
        return -1;
    }
}