import java.util.*;
import java.io.*;

class Main {
    static int N, r, c;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) + 1;
        c = Integer.parseInt(st.nextToken()) + 1;
        
        solve(N, r, c);
        
        System.out.println(result);
    }
    static void solve(int N, int r, int c) {
        if(N == 0) return;
        
        int n = 1;
        for(int i=0; i<N; i++) {
            n *= 2;
        }
        
        if(r > n/2 && c <= n/2) {
            result += n/2 * n/2 * 2;
            solve(N - 1, r - n/2, c);
        } else if(r > n/2 && c > n/2) {
            result += n/2 * n/2 * 3;
            solve(N - 1, r - n/2, c - n/2);
        } else if(r <= n/2 && c > n/2) {
            result += n/2 * n/2;
            solve(N - 1, r, c - n/2);
        } else {
            solve(N - 1, r, c);
        }
    }
}