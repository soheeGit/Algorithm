import java.util.*;
import java.io.*;

class Main {
    static int n;
    static boolean[] visited;
    static ArrayList<int[]>[] graph;
    static int maxDist = 0;
    static int farNode = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        if (n == 1) {
            System.out.println(0);
            return;
        }
        
        for(int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }
        
        dfs(1, 0);
        
        visited = new boolean[n + 1];
        maxDist = 0;
        
        dfs(farNode, 0);
        
        System.out.println(maxDist);
    }
    static void dfs(int now, int dist) {
        visited[now] = true;
        if(maxDist < dist) {
            maxDist = dist;
            farNode = now;
        }
        
        for(int[] next : graph[now]) {
            int nextNode = next[0];
            int weight = next[1];
            
            if(!visited[nextNode]) dfs(nextNode, dist + weight);
        }
    }
}