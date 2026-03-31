import java.util.*;
import java.io.*;

class Main {
    static int N, result = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        comb(0, 0);
        System.out.println(result);
    }
    static void comb(int start, int dept) {
        if(dept == N / 2) {
            solve();
            return;
        }
        for(int i=start; i<N; i++) {
            visited[i] = true;
            comb(i + 1, dept + 1);
            visited[i] = false;
        }
    }
    static void solve() {
        int startTeam = 0;
        int linkTeam = 0;
        
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(visited[i] && visited[j]) {
                    startTeam += arr[i][j] + arr[j][i];
                }
                if(!visited[i] && !visited[j]) {
                    linkTeam += arr[i][j] + arr[j][i];
                }
            }
        }
        
        int r = Math.abs(startTeam - linkTeam);
        result = Math.min(result, r);
    }
}