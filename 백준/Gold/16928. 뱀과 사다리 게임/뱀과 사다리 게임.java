import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] move = new int[101];
    static boolean[] visited = new boolean[101];
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            move[x] = y;
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            move[u] = v;
        }
        
        queue.add(new int[]{1, 0});
        visited[1] = true;
        
        System.out.println(bfs());
    }
    static int bfs() {
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowSite = now[0];
            int nowCount = now[1];
            
            if(nowSite == 100) return nowCount;
            
            for(int i=1; i<=6; i++) {
                int next = i+nowSite;
                if(next > 100) continue;
                
                if(move[next] != 0) next = move[next];
                
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, nowCount+1});
                }
            }
            
        }
        return -1;
    }
}