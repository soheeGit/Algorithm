import java.util.*;
import java.io.*;

class Main {
    static int V, E, K;
    static List<int[]>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        graph = new LinkedList[V+1];
        
        for(int i=1; i<=V; i++) {
            graph[i] = new LinkedList<>();
        }
        
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
        }
        
        int[] dist = dijkstra(K);
        for (int i=1; i<=V; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }
    static int[] dijkstra(int start) {
        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        pq.add(new int[]{start, 0});
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int s = now[0];
            int c = now[1];
            
            if(dist[s] < c) continue;
            
            for(int[] next: graph[s]) {
                int nextS = next[0];
                int nextC = c + next[1];
                
                if(dist[nextS] > nextC) {
                    dist[nextS] = nextC;
                    pq.add(new int[]{nextS, nextC});
                }
            }
        }
        return dist;
    }
}