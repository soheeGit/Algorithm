import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] arr, result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        solve(0);
        System.out.print(sb);
    }
    
    static void solve(int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(result[i]);
                if(i < M - 1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        
        int lastUsed = -1;
        for(int i = 0; i < N; i++) {
            if(visited[i] || arr[i] == lastUsed) {
                continue;
            }
            visited[i] = true;
            result[depth] = arr[i];
            lastUsed = arr[i];
            solve(depth + 1);
            visited[i] = false;
        }
    }
}