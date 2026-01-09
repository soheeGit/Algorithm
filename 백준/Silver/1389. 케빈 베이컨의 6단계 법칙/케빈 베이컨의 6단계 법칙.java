import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
            list[B].add(A);
        }
        
        int result = Integer.MAX_VALUE;
        int num = 0;
        for(int i=1; i<=N; i++) {
            int n = solve(i);
            if(result > n) {
                result = n;
                num = i;
            }
        }
        
        System.out.println(num);
    }
    static int solve(int n) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        dist[n] = 0;
        visited[n] = true;
        queue.offer(n);
        
        while(!queue.isEmpty()) {
            int num = queue.poll();
            for(int friend : list[num]) {
                if(visited[friend] == true) continue;
                dist[friend] = dist[num] + 1;
                visited[friend] = true;
                queue.offer(friend);
            }
        }
        
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += dist[i];
        }
        return sum;
    }
}