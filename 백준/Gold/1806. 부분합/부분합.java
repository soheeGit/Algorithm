import java.util.*;
import java.io.*;

class Main {
    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        solve();
    }
    static void solve() {
        int left = 0;
        int right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        
        while(right < N) {
            sum += arr[right];
        
            while(sum >= S) {
                result = Math.min(result, right - left + 1);
                sum -= arr[left];
                left++;
            }
            
            right++;
        }
        
        if(result == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(result);
    }
}