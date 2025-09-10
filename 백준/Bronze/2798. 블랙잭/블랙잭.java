import java.util.*;
import java.io.*;

class Main {
    static int N, M, max, val;
    static int[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        card = new int[N];
        max = Integer.MIN_VALUE;
        val = 0;
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        solve(0, 0);
        System.out.println(max);
    }
    static void solve(int idx, int cnt) {
        if(cnt == 3) {
            if(val <= M){
                max = Math.max(val, max);
            }
            return;
        }
        for(int i=idx; i<N; i++) {
            val += card[i];
            solve(i+1, cnt+1);
            val -= card[i];
        }
    }
}