import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.println(solve());
    }
    static int solve() {
        int result = 0;
        
        for(int i=N - 1; i>=0; i--) {
            if(arr[i] <= K) {
                int count = K / arr[i];
                result += count;
                K -= count * arr[i];
            }    
        }
        
        return result;
    }
}