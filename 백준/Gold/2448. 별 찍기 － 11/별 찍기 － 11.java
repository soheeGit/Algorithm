import java.util.*;
import java.io.*;

class Main {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][2 * N];
        for(int i=0; i<N; i++){
            Arrays.fill(arr[i], ' ');
        }
        
        solve(0, N - 1, N);
        
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            for(int j=0; j<2 * N - 1; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
    static void solve(int x, int y, int n) {
        if(n == 3) {
            arr[x][y] = '*';

            arr[x+1][y-1] = '*';
            arr[x+1][y+1] = '*';

            for(int i=y-2; i<=y+2; i++) {
                arr[x+2][i] = '*';
            }
            return;
        }
        
        int half = n / 2;

        solve(x, y, half);
        solve(x + half, y - half, half);
        solve(x + half, y + half, half);
    }
}