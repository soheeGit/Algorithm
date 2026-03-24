import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] parent;
    static class Edge {
        int a, b, c;
    
        Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    static List<Edge> edges = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        parent = new int[N + 1];
        for(int i=1; i<=N; i++) parent[i] = i;
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            edges.add(new Edge(A, B, C));
        }
        
        Collections.sort(edges, (a, b) -> a.c - b.c);
        
        solve();
    }
    static void solve() {
        int total = 0;
        int maxEdge = 0;
        
        for(Edge e : edges) {
            if(find(e.a) != find(e.b)) {
                total += e.c;
                union(e.a, e.b);
                maxEdge = Math.max(maxEdge, e.c);
            }
        }
        
        System.out.println(total - maxEdge);
    }
    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
    
        if(a != b) parent[b] = a;
    }
    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}