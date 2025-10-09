import java.util.*;
import java.io.*;

class Main {
    static int[][] arr, prefix;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        prefix = new int[N+1][N+1];
        
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                prefix[i][j] = arr[i][j] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            solve(x1, y1, x2, y2);
        }
        System.out.println(sb);
    }
    static void solve(int x1, int y1, int x2, int y2) {
        int result = 0;
        if(x1 == 1) {
            result = prefix[x2][y2] - prefix[x2][y1-1];
        }else if(y1 == 1) {
            result = prefix[x2][y2] - prefix[x1-1][y2];
        }else if(x1 == 1 && y1 == 1){
            result = prefix[x2][y2];
        }else {
            result = prefix[x2][y2] - prefix[x2][y1-1] - prefix[x1-1][y2] + prefix[x1-1][y1-1];
        }
        sb.append(result).append("\n");
    }
}