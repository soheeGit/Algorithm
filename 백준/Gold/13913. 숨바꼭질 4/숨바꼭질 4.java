import java.util.*;
import java.io.*;

class Main {
    static int N, K, result;
    static boolean[] visited;
    static int[] prev;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        prev = new int[100001];
        
        queue.add(N);
        visited[N] = true;
        solve();
        
        System.out.println(sb);
    }
    static void solve() {
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            if(now == K) {
                print();
                return;
            }
            
            int[] next = {now - 1, now + 1, now * 2};
            for(int i=0; i<3; i++) {
                if(next[i] < 0 || next[i] > 100000 || visited[next[i]]) continue;
                visited[next[i]] = true;
                prev[next[i]] = now;
                queue.add(next[i]);
            }
        }
    }
    static void print() {
        List<Integer> path = new ArrayList<>();
        
        for(int i=K; i!=N; i=prev[i]) {
            path.add(i);
        }
        path.add(N);
        
        Collections.reverse(path);
        
        sb.append(path.size() - 1).append("\n");
        for(int x : path) {
            sb.append(x).append(" ");
        }
    }
}