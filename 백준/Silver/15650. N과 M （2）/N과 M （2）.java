import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] arr, result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        result = new int[M];
        for(int i=1; i<=N; i++) {
            arr[i] = i;
        }
        solve(1, 0);
        
        System.out.println(sb);
    }
    static void solve(int start, int count) {
        if(count == M) {
            for(int i=0; i<M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<=N; i++) {
            result[count] = arr[i];
            solve(i+1, count+1);
        }
    }
}