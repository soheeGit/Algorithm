import java.util.*;
import java.io.*;

class Main {
    static int M, N, H;
    static int[][][] box;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0, 0, 0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        
        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0; k<M; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    box[i][j][k] = tomato;
                    if(box[i][j][k] == 1) queue.add(new int[]{i, j, k, 0});
                }
            }
        }
        
        int result = bfs();
        
        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(result);
    }
    static int bfs() {
        int result = 0;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowH = now[0];
            int nowN = now[1];
            int nowM = now[2];
            int nowDay = now[3];
            result = Math.max(result, nowDay);
            
            for(int i=0; i<6; i++) {
                int nextH = nowH + dx[i];
                int nextN = nowN + dy[i];
                int nextM = nowM + dz[i];
                if(nextH >= 0 && nextN >= 0 && nextM >= 0 && nextH < H && nextN < N && nextM < M) {
                    if(box[nextH][nextN][nextM] == 0) {
                        box[nextH][nextN][nextM] = 1;
                        queue.add(new int[]{nextH, nextN, nextM, nowDay+1});
                    }
                }
            }
        }
        return result;
    }
}