import java.io.*;
import java.util.*;

class Main {
    static int K, N;
    static long max = Integer.MIN_VALUE;
    static int[] lan;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lan = new int[K];
        
        for(int i=0; i<K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lan[i]);
        }
        
        Arrays.sort(lan);
        
        long result = solve();
        System.out.println(result);
    }
    static long solve() {
        long low = 1;
        long high = max;
        long result = 0;
        
        while(low <= high) {
            long mid = (low + high)/2;
            if(check(mid)) {
                result = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return result;
    }
    static boolean check(long mid) {
        long count = 0;
        for (int i=0; i<K; i++) {
            count += lan[i] / mid;
        }
        return count >= N;
    }
}