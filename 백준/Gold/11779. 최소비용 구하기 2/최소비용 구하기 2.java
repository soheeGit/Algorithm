import java.util.*;
import java.io.*;

class Main {
    static int n, m, start, destination;
    static List<int[]>[] arr;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        arr = new ArrayList[n + 1];
        for(int i=1; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            arr[s].add(new int[]{d, c});
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());
        
        solve();
    }
    static void solve() {
        int[] prev = new int[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        pq.add(new int[]{start, 0});
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowS = now[0];
            int nowC = now[1];
            
            if(nowC > dist[nowS]) continue;
            
            for(int[] next : arr[nowS]) {
                int nextS = next[0];
                int nextC = next[1];
                
                if(dist[nextS] > nowC + nextC) {
                    dist[nextS] = nowC + nextC;
                    prev[nextS] = nowS;
                    
                    pq.add(new int[]{nextS, nowC + nextC});
                }
            }
        }
        
        List<Integer> path = new ArrayList<>();

        for(int i = destination; i != 0; i = prev[i]) {
            path.add(i);
        }
        Collections.reverse(path);
        
        System.out.println(dist[destination]);
        System.out.println(path.size());
        for(int i : path) {
            System.out.print(i + " ");
        }
    }
}