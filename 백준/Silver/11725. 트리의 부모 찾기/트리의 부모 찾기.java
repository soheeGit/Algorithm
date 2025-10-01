import java.util.*;
import java.io.*;

class Main {
    static int N;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        parent = new int[N+1];
        
        graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        
        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        
        bfs(1);
        for(int i=2; i<=N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int next : graph[now]) {
                if(!visited[next]) {
                    visited[next] = true;
                    parent[next] = now;
                    queue.add(next);
                }
            }
        }
    }
}