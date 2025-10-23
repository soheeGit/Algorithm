import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] houses;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        houses = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                houses[i][j] = s.charAt(j) - '0';
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (houses[i][j] == 1 && !visited[i][j]) {
                    result.add(bfs(i, j));
                }
            }
        }
        
        Collections.sort(result);
        System.out.println(result.size());
        for (int count : result) {
            System.out.println(count);
        }
    }
    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y});
        int count = 1;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            
            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                
                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                    if(!visited[nextX][nextY] && houses[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                        count++;
                    }
                }
            }
        }
        return count;
    }
}