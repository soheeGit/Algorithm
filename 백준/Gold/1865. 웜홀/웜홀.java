import java.util.*;
import java.io.*;

class Main {
    static int N, M, W;
    static List<int[]>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int TC = Integer.parseInt(br.readLine());
        while(TC-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            
            list = new ArrayList[N + 1];
            for(int i=1; i<=N; i++) {
                list[i] = new ArrayList<>();
            }
            
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                
                list[S].add(new int[]{E, T});
                list[E].add(new int[]{S, T});
            }
            
            for(int i=0; i<W; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                
                list[S].add(new int[]{E, -T});
            }
            
            solve();
        }
    }
    static void solve() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 0);
        
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                for(int[] now : list[j]) {
                    int nowE = now[0];
                    int nowT = now[1];
                
                    if(dist[nowE] > dist[j] + nowT) {
                        dist[nowE] = dist[j] + nowT;
                        
                        if(i == N) {
                            System.out.println("YES");
                            return;
                        }
                    }
                }
            }
        }
        
        System.out.println("NO");
    }
}