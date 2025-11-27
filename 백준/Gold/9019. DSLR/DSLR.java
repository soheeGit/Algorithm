import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(solve(A, B)).append("\n");
        }
        
        System.out.println(sb);
    }
    static String solve(int A, int B) {
        boolean[] visited = new boolean[10000];
        Queue<Integer> q = new LinkedList<>();
        String[] command = new String[10000];
        
        q.add(A);
        visited[A] = true;
        command[A] = "";
        String[] opt = {"D", "S", "L", "R"};
        
        while(!q.isEmpty()) {
            int now = q.poll();
            if(now == B) return command[now];
            
            for(int i=0; i<4; i++) {
                int next = 0;
                
                if(i == 0) next = D(now);
                else if(i == 1) next = S(now);
                else if(i == 2) next = L(now);
                else if(i == 3) next = R(now);
                
                if(!visited[next] && next >= 0 && next < 10000) {
                    visited[next] = true;
                    command[next] = command[now] + opt[i];
                    q.add(next);
                }
            }
        }
        return "";
    }
    static int D(int A) {
        if(A * 2 >= 10000) return A * 2 % 10000;
        return A * 2;
    }
    static int S(int A) {
        if(A == 0) {
            A = 9999;
            return A;
        }
        return A - 1;
    }
    static int L(int A) {
        return (A % 1000) * 10 + A / 1000;
    }
    static int R(int A) {
        return (A / 10) + (A % 10) * 1000;
    }
}