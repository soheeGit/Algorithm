import java.util.*;
import java.io.*;

class Main {
    static int n, d, c, a, b, s;
    static List<int[]>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr = new ArrayList[n + 1];
            
            for(int i=1; i<=n; i++) {
                arr[i] = new ArrayList<>();
            }
            
            for(int i=0; i<d; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
                
                arr[b].add(new int[]{a, s});
            }
            
            int[] result = solve(c);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }
        
        System.out.println(sb);
    }
    static int[] solve(int start) {
        int[] dist = new int[n + 1];
        for(int i=1; i<=n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int node = now[0];
            int cost = now[1];
            
            if(cost > dist[node]) continue;
            
            for(int[] next : arr[node]) {
                int nextNode = next[0];
                int nextCost = cost + next[1];
                
                if(nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.add(new int[]{nextNode, nextCost});
                }
            }
        }
        
        int count = 0;
        int max = 0;

        for(int i=1;i<=n;i++){
            if(dist[i] != Integer.MAX_VALUE){
                count++;
                max = Math.max(max, dist[i]);
            }
        }
        
        return new int[]{count, max};
    }
}