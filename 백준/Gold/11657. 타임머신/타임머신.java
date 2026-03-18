import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static List<int[]>[] list;
    static long[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[N + 1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            list[A].add(new int[]{B, C});
        }
        
        solve();
    }
    static void solve() {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                for(int[] now : list[j]) {
                    int nowB = now[0];
                    int nowC = now[1];
                
                    if(dist[j] != Long.MAX_VALUE && dist[nowB] > dist[j] + nowC) {
                        dist[nowB] = dist[j] + nowC;
                        
                        if(i == N) {
                            System.out.println(-1);
                            return;
                        }
                    }
                }
            }
        }
        
        for(int i=2; i<=N; i++) {
            if(dist[i] == Long.MAX_VALUE) System.out.println(-1);
            else System.out.println(dist[i]);
        }
    }
}