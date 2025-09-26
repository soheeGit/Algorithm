import java.util.*;
import java.io.*;

class Main {
    static int N, E, v1, v2;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
    static List<int[]>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=1; i<=E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        
        solve();
    }
    static void solve() {
        int[] distFrom1 = dijkstra(1);
        int[] distFromV1 = dijkstra(v1);
        int[] distFromV2 = dijkstra(v2);
        
        long path1 = (long) distFrom1[v1] + distFromV1[v2] + distFromV2[N];
        long path2 = (long) distFrom1[v2] + distFromV2[v1] + distFromV1[N];
        
        long result = Math.min(path1, path2);
        
        if (result >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
    static int[] dijkstra(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        pq.add(new int[]{start, 0});
        
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int s = now[0];
            int c = now[1];
            
            if (dist[s] < c) continue;
            
            for(int[] next : graph[s]) {
                int nextS = next[0];
                int nextC = c + next[1];
                
                if (nextC < dist[nextS]) {
                    dist[nextS] = nextC;
                    pq.add(new int[]{nextS, nextC});
                }
            }
        }
        return dist;
    }
}