import java.util.*;
import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            Queue<int[]> q = new LinkedList();
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                int a = Integer.parseInt(st.nextToken());
                q.add(new int[]{a, j});
            }
            solve(M, q);
        }
        System.out.println(sb);
    }
    static void solve(int M, Queue<int[]> q) {
        int count = 0;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int a = now[0];
            int j = now[1];
            
            boolean isPrior = true;
            for(int[] queue: q) {
                if(a < queue[0]) {
                    isPrior = false;
                    break;
                }
            }
            
            if(!isPrior) q.add(now);
            else {
                count++;
                if(j == M) {
                    sb.append(count).append("\n");
                    return;
                }
            }
        }
    }
}