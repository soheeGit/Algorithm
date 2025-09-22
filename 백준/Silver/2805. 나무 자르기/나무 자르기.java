import java.util.*;
import java.io.*;

class Main {
    static int N, M, max = Integer.MIN_VALUE;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }
        
        long result = solve();
        System.out.println(result);
    }
    static long solve() {
        long low = 0;
        long high = max;
        long result = 0;
        
        while(low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;
            for(int t : tree) {
                if(t >= mid) {
                    sum += t - mid;
                }
            }
            if (sum >= M) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}