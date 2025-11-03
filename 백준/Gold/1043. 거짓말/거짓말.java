import java.util.*;
import java.io.*;

class Main {
    static int N, M, t;
    static int[] truth;
    static int[] parent;
    static List<Integer>[] parties;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        parent = new int[N + 1];
        for (int i=1; i<=N; i++) parent[i] = i;
        
        st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());
        truth = new int[t];
        parties = new ArrayList[M];
        if(t != 0) {
            for(int i=0; i<t; i++) {
                truth[i] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            parties[i] = new ArrayList<>();
            int cnt = Integer.parseInt(st.nextToken());
            
            if (cnt > 0) {
                int first = Integer.parseInt(st.nextToken());
                parties[i].add(first);

                for (int j = 1; j < cnt; j++) {
                    int next = Integer.parseInt(st.nextToken());
                    parties[i].add(next);
                    union(first, next);
                }
            }
        }
        solve();
    }
    static void solve() {
        if(t == 0) {
            System.out.println(M);
            return;
        }
        
        Set<Integer> truthRoots = new HashSet<>();
        for (int i = 0; i < t; i++) {
            truthRoots.add(find(truth[i]));
        }

        int answer = 0;
        for(int i = 0; i < M; i++) {
            boolean canLie = true;
            for(int person : parties[i]) {
                if(truthRoots.contains(find(person))) {
                    canLie = false;
                    break;
                }
            }
            if(canLie) answer++;
        }
        System.out.println(answer);
    }
    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
}