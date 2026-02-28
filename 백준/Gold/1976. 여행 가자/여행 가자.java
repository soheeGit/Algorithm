import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] city, parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        city = new int[M];
        parent = new int[N + 1];
        
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }
        
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                int e = Integer.parseInt(st.nextToken());
                if(e == 0) continue;
                
                union(i, j);
            }
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }
        
        solve();
    }
    static void solve() {
        int root = find(city[0]);
        
        for(int i=1; i<M; i++) {
            if(root != find(city[i])) {
                System.out.println("NO");
                return;
            }
        }
        
        System.out.println("YES");
    }
    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        
        if(pa == pb) return;
        
        parent[pb] = pa;
    }
}