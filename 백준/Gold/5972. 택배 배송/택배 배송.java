import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] dist;
    static List<int[]>[] graph;
    static Queue<int[]> queue = new PriorityQueue<>((x, y) -> x[1] - y[1]);
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            if(i == 1) dist[1] = 0;
            else dist[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            graph[A].add(new int[]{B, C});
            graph[B].add(new int[]{A, C});
        }
        
        queue.offer(new int[]{1, 0});
        solve();
        
        System.out.println(dist[N]);
    }
    static void solve() {
        while(!queue.isEmpty()) {
            int[] n = queue.poll();
            int now = n[0];
            int cost = n[1];
            
            if(cost > dist[now]) continue;
            
            for(int[] next : graph[now]) {
                int nextNode = next[0];
                int nextCost = cost + next[1];
                
                if(nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    queue.offer(new int[]{nextNode, nextCost});
                }
            }
        }
    }
}