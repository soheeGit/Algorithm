import java.util.*;
import java.io.*;

class Main {
    static int R, C, T;
    static int upper = -1, lower = -1;
    static int[][] arr, temp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1) {
                    if(upper == -1) upper = i;
                    else lower = i;
                }
            }
        }
        while(T-- > 0) solve();
        
        int result = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(arr[i][j] > 0) result += arr[i][j];
            }
        }
        
        System.out.println(result);
    }
    static void solve() {
        temp = new int[R][C];
        
        spread();
        
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                arr[i][j] = temp[i][j];
            }
        }
        
        operate();
    }
    static void spread() {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(arr[i][j] == 0 || arr[i][j] == -1) continue;
                int now = arr[i][j] / 5;
                int num = 0;
                
                for(int z=0; z<4; z++) {
                    int nextr = i + dx[z];
                    int nextc = j + dy[z];
                    
                    if(nextr < 0 || nextc < 0 || nextr >= R || nextc >= C || arr[nextr][nextc] == -1) continue;
                    temp[nextr][nextc] += now;
                    num++;
                }
                temp[i][j] += arr[i][j];
                temp[i][j] -= num * now;
            }
        }
    }
    static void operate() {
        for(int i=upper - 1; i>0; i--) arr[i][0] = arr[i - 1][0];
        for(int i=0; i<C - 1; i++) arr[0][i] = arr[0][i + 1];
        for(int i=0; i<upper; i++) arr[i][C - 1] = arr[i + 1][C - 1];
        for(int i=C - 1; i>1; i--) arr[upper][i] = arr[upper][i - 1];
        arr[upper][1] = 0;
        
        for(int i=lower + 1; i<R - 1; i++) arr[i][0] = arr[i + 1][0];
        for(int i=0; i<C - 1; i++) arr[R - 1][i] = arr[R - 1][i + 1];
        for(int i=R - 1; i>lower; i--) arr[i][C - 1] = arr[i - 1][C - 1];
        for(int i=C - 1; i>1; i--) arr[lower][i] = arr[lower][i - 1];
        arr[lower][1] = 0;
        
        arr[upper][0] = -1;
        arr[lower][0] = -1;
    }
}