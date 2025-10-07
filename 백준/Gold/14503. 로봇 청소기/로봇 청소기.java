import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] room;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cleaned = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        
        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        simulate(r, c, d);
        System.out.println(cleaned);
    }
    static void simulate(int r, int c, int d) {
        while(true) {
            if (room[r][c] == 0) {
                room[r][c] = 2;
                cleaned++;
            }
            
            boolean found = false;
            
            for(int i=0; i<4; i++) {
                d = (d + 3) % 4;
                int x = r + dx[d];
                int y = c + dy[d];
                if(x >= 0 && x < N && y >= 0 && y < M && room[x][y] == 0) {
                    r = x;
                    c = y;
                    found = true;
                    break;
                }
            }
            if (found) continue;
            
            int back = (d + 2) % 4;
            int bx = r + dx[back];
            int by = c + dy[back];
            if (bx >= 0 && bx < N && by >= 0 && by < M && room[bx][by] != 1) {
                r = bx;
                c = by;
            } else {
                break;
            }
        }
    }
}