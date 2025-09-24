import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static long max = Integer.MIN_VALUE;
    static int[] req;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        req = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            req[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, req[i]);
        }
        
        M = Integer.parseInt(br.readLine());
        
        long result = solve();
        System.out.println(result);
    }
    static long solve() {
        long low = 0;
        long high = max;
        long result = 0;
        
        while(low <= high) {
            long mid = (low + high)/2;
            if(money(mid)) {
                result = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return result;
    }
    static boolean money(long mid) {
        long sum = 0;
        for(int i=0; i<N; i++) {
            if(req[i] > mid) {
                sum += mid;
            } else {
                sum += req[i];
            }
        }
        return sum <= M;
    }
}