import java.util.*;
import java.io.*;

class Main {
    static int N, M, goalA, goalB;
    static List<int[]>[] city;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        city = new LinkedList[N+1];
        
        for(int i=1; i<=N; i++) {
            city[i] = new LinkedList<>();
        }
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            city[a].add(new int[]{b, c});
        }
        
        st = new StringTokenizer(br.readLine());
        goalA = Integer.parseInt(st.nextToken());
        goalB = Integer.parseInt(st.nextToken());
        
        int[] dist = dijkstra(goalA);
        System.out.println(dist[goalB]);
    }
    static int[] dijkstra(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int s = now[0];
            int c = now[1];
            
            if(dist[s] < c) continue;
            
            for(int[] next : city[s]) {
                int nextS = next[0];
                int nextC = c + next[1];
                
                if(nextC < dist[nextS]) {
                    dist[nextS] = nextC;
                    pq.add(new int[]{nextS, nextC});
                }
            }
        }
        return dist;
    }
}