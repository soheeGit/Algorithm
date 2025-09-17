import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static Queue<int[]> q = new LinkedList<>();
    static int result = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        
        q.add(new int[]{N, 0});
        visited[N] = true;
        bfs();
        System.out.println(result);
    }
    static void bfs() {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int time = cur[1];
            
            if(pos == K) {
                result = time;
                return;
            }
            
            int[] nextPos = {pos-1, pos+1, pos*2};
            
            if(pos - 1 >= 0 && !visited[pos - 1]) {
                visited[pos - 1] = true;
                q.add(new int[]{pos - 1, time + 1});
            }
            if(pos + 1 <= 100000 && !visited[pos + 1]) {
                visited[pos + 1] = true;
                q.add(new int[]{pos + 1, time + 1});
            }
            if(pos * 2 <= 100000 && !visited[pos * 2]) {
                visited[pos * 2] = true;
                q.add(new int[]{pos * 2, time + 1});
            }
        }
    }
}