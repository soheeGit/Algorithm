import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] A, up, down;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        up = new int[N];
        down = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            up[i] = 1;
            down[i] = 1;
        }
        
        solve();
        
        int result = 0;
        for(int i=0; i<N; i++) {
            result = Math.max(result, up[i] + down[i]);
        }
        System.out.println(result - 1);
    }
    static void solve() {
        for(int i=1; i<N; i++) {
            for(int j=0; j<i; j++){
                if(A[j] < A[i]) {
                    up[i] = Math.max(up[i], up[j] + 1);
                }
            }
        }
        
        for(int i=N - 2; i>=0; i--) {
            for(int j=i + 1; j<N; j++) {
                if(A[j] < A[i]) {
                    down[i] = Math.max(down[i], down[j] + 1);
                }
            }
        }
    }
}