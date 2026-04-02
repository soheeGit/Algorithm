import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        solve();
    }
    static void solve() {
        long result = 0;
        pq.add(new int[]{0, 0});
        
        while(!pq.isEmpty())  {
            int[] now = pq.poll();
            int node = now[0];
            int cost = now[1];
            
            if(visited[node]) continue;
            result += cost;
            visited[node] = true;
            
            for(int i=0; i<N; i++) {
                if(visited[i]) continue;
                
                int nextCost = arr[node][i];
                pq.add(new int[]{i, nextCost});
            }
        }
        
        System.out.println(result);
    }
}