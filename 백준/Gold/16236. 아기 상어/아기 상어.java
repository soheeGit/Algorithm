import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int sharkSize = 2;
    static int eatCount = 0;
    static int time = 0;
    static int sx, sy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 9) {
                    sx = i;
                    sy = j;
                    board[i][j] = 0;
                }
            }
        }
        
        while(true) {
            int[] target = bfs();
            if(target == null) break;
            
            int x = target[0];
            int y = target[1];
            int dist = target[2];

            time += dist;

            sx = x;
            sy = y;

            board[x][y] = 0;

            eatCount++;
            if(eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }
        
        System.out.println(time);
    }
    static int[] bfs() {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> fishList = new ArrayList<>();
        
        int minDist = Integer.MAX_VALUE;
        
        queue.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int dist = now[2];
            
            if(dist > minDist) break;
            if(board[x][y] != 0 && board[x][y] < sharkSize) {
                fishList.add(new int[]{x, y, dist});
                minDist = dist;
            }
            
            for(int i=0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if(visited[nextX][nextY]) continue;
                if(board[nextX][nextY] > sharkSize) continue;
                
                visited[nextX][nextY] = true;
                queue.add(new int[]{nextX, nextY, dist + 1});
            }
        }
        if(fishList.isEmpty()) return null;
        
        Collections.sort(fishList, (a, b) -> {
            if(a[2] != b[2]) return a[2] - b[2];
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        return fishList.get(0);
    }
}