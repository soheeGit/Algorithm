import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(!isCycle(a, b)) continue;
            else {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(0);
    }
    static boolean isCycle(int a, int b) {
        if (find(a) == find(b)) return true;
        union(a, b);
        return false;
    }
    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa != pb) {
            parent[pb] = pa;
        }
    }
    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}