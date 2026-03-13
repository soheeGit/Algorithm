import java.util.*;
import java.io.*;

class Main {
    static int n, m, r, result = 0;
    static int[] arr;
    static List<int[]>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        list = new ArrayList[n + 1];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            
            list[a].add(new int[]{b, l});
            list[b].add(new int[]{a, l});
        }
        
        for(int i=1; i<=n; i++) {
            dijkstra(i);
        }
        
        System.out.println(result);
    }
    static void dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        pq.add(new int[]{start, 0});
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int node = now[0];
            int cost = now[1];
            
            if(cost > dist[node]) continue;
            
            for(int[] next : list[node]) {
                int nextnode = next[0];
                int nextcost = cost + next[1];
                
                if(nextcost < dist[nextnode]){
                    dist[nextnode] = nextcost;
                    pq.add(new int[]{nextnode,nextcost});
                }
            }
        }
        int sum = 0;

        for(int i=1;i<=n;i++){
            if(dist[i] <= m){
                sum += arr[i];
            }
        }

        result = Math.max(result, sum);
    }
}