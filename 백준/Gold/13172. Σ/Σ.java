import java.util.*;
import java.io.*;

class Main {
    static int M;
    static long result = 0;
    static final long MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        M = Integer.parseInt(br.readLine());
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            
            solve(N, S);
        }
        System.out.println(result);
    }
    static void solve(int n, int s) {
        long inv = pow(n, MOD - 2);
        result = (result + s * inv) % MOD;
    }
    static long pow(long a, long b) {
        long res = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }
}