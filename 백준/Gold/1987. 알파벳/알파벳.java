import java.util.*;
import java.io.*;

class Main {
    static int R, C;
    static char[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;
    static boolean[] used = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        
        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        used[arr[0][0] - 'A'] = true;
        solve(0, 0, 1);
        
        System.out.println(answer);
    }
    static void solve(int row, int col, int dept) {
        answer = Math.max(answer, dept);
        
        for(int i=0; i<4; i++) {
            int nowx = row + dx[i];
            int nowy = col + dy[i];
            
            if(nowx < 0 || nowx >= R || nowy < 0 || nowy >= C) continue;
            if(used[arr[nowx][nowy] - 'A'] == true) continue;
            
            used[arr[nowx][nowy] - 'A'] = true;
            solve(nowx, nowy, dept + 1);
            used[arr[nowx][nowy] - 'A'] = false;
        }
    }
}