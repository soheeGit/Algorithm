import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int result = 0;
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
        
        dfs(0);
        System.out.println(result);
    }
    static void dfs(int depth) {
        if(depth == 3){
            bfs();
            return;
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    dfs(depth + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }
    static void bfs() {
        int[][] copy = new int[N][M];
        for(int i=0; i<N; i++){
            copy[i] = arr[i].clone();
        }
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copy[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] virous = q.poll();
            int xv = virous[0];
            int yv = virous[1];
            
            for(int i=0; i<4; i++) {
                int nowx = xv + dx[i];
                int nowy = yv + dy[i];

                if(nowx < 0 || nowy < 0 || nowx >= N || nowy >= M) continue;
                if(copy[nowx][nowy] == 0) {
                    copy[nowx][nowy] = 2;
                    q.add(new int[]{nowx, nowy});
                }
            }
        }
        
        int r = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copy[i][j] == 0){
                    r++;
                }
            }
        }
        
        result = Math.max(result, r);
    }
}