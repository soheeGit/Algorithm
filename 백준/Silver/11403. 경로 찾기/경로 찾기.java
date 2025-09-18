import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] result;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        result = new int[N][N];
        graph = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
               graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<N; i++) {
            bfs(i);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void bfs(int n) {
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        
        while(!q.isEmpty()) {
            int num = q.poll();
            for(int i=0; i<N; i++) {
                if(graph[num][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    result[n][i] = 1;
                    q.add(i);
                }
            }
        }
    }
}