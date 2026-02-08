import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] arr, selected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new int[M];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        solve(0, 0);
        System.out.println(sb);
    }
    static void solve(int start, int dept) {
        if(dept == M) {
            for(int s : selected) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=start; i<N; i++) {
            if(i > start && arr[i] == arr[i - 1]) continue;
            
            selected[dept] = arr[i];
            solve(i, dept + 1);
        }
    }
}