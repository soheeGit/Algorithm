import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static int[] time, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = new int[100001];
        count = new int[100001];
        
        solve();
        
        System.out.println(time[K]);
        System.out.println(count[K]);
    }
    static void solve() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        count[N] = 1;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            int[] next = {now - 1, now + 1, now * 2};
            
            for(int n : next) {
                if(n < 0 || n > 100000) continue;
                
                if(count[n] == 0) {
                    time[n] = time[now] + 1;
                    count[n] = count[now];
                    queue.add(n);
                }else if(time[n] == time[now] + 1) {
                    count[n] += count[now];
                }
            }
        }
    }
}