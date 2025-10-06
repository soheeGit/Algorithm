import java.util.*;
import java.io.*;

class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i=1; i<=N; i++) {
            set.add(find(i));
        }
        System.out.println(set.size());
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b)   {
            parent[b] = a;
        }
    }
    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}