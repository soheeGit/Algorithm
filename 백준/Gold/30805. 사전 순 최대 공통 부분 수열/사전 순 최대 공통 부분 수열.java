import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] A, B;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        solve();
    }
    static void solve() {
        int aStart = 0;
        int bStart = 0;
        
        while(true) {
            int max = 0;
            int aIdx = 0;
            int bIdx = 0;
        
            for(int i=aStart; i<N; i++) {
                for(int j=bStart; j<M; j++) {
                    if(A[i] == B[j] && A[i] > max) {
                        max = A[i];
                        aIdx = i;
                        bIdx = j;
                    }
                }
            }
            
            if(max == 0) break;
            result.add(max);
            aStart = aIdx + 1;
            bStart = bIdx + 1;
        }
        
        System.out.println(result.size());

        if(result.size() > 0) {
            for(int x : result) System.out.print(x + " ");
        }
    }
}