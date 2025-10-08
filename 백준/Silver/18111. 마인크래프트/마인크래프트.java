import java.io.*;
import java.util.*;

class Main {
    static int N, M, B;
    static int resultT = Integer.MAX_VALUE;
    static int resultH = Integer.MIN_VALUE;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        solve();
        System.out.println(resultT + " " + resultH);
    }
    static void solve() {
        for (int h=0; h<=256; h++) {
            int time = 0;
            int inventory = B;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int d = arr[i][j] - h;
                    if(d > 0) {
                        time += 2*d;
                        inventory += d;
                    }else {
                        time += -d;
                        inventory += d;
                    }
                }
            }
            
            if(inventory >= 0) {
                if(resultT == time) {
                    resultH = Math.max(resultH, h);
                }else if(resultT > time){
                    resultT = time;
                    resultH = h;
                }
            }
        }
    }
}