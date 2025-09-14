import java.util.*;
import java.io.*;

class Main {
    static boolean[] isvisited;
    static int[][] rel;
    static int N, M, V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        rel = new int[M][2];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            rel[i][0] = Integer.parseInt(st.nextToken());
            rel[i][1] = Integer.parseInt(st.nextToken());
        }
        
        isvisited = new boolean[N+1];
        dfs(V);
        
        System.out.println();
        
        isvisited = new boolean[N+1];
        bfs(V);
    }
    static void dfs(int v) {
        isvisited[v] = true;
        System.out.print(v + " ");
        
        List<Integer> nodes = new ArrayList<>();
        for(int i=0; i<M; i++) {
            if(rel[i][0] == v) nodes.add(rel[i][1]);
            else if(rel[i][1] == v) nodes.add(rel[i][0]);
        }
        Collections.sort(nodes);
        
        for(int next : nodes) {
            if(!isvisited[next]) dfs(next);
        }
    }
    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        isvisited[v] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            
            List<Integer> nodes = new ArrayList<>();
            for(int i=0; i<M; i++) {
                if(rel[i][0] == cur) nodes.add(rel[i][1]);
                else if(rel[i][1] == cur) nodes.add(rel[i][0]);
            }
            Collections.sort(nodes);
            
            for(int next : nodes) {
                if(!isvisited[next]) {
                    isvisited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}