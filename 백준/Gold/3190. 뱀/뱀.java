import java.util.*;
import java.io.*;

class Main {
    static int N, K, L;
    static int[][] board;
    static Deque<int[]> dq = new LinkedList<>();
    static Map<Integer, Character> map = new HashMap<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N][N];
        
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            
            board[c - 1][l - 1] = 1;
        }
        
        L = Integer.parseInt(br.readLine());
        
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            
            map.put(X, C.charAt(0));
        }
        
        dq.add(new int[]{0, 0});
        board[0][0] = 2;
        
        System.out.println(solve());
    }
    static int solve() {
        int time = 0;
        int dir = 0;
        
        while(true) {
            time++;
            int[] head = dq.peekFirst();
            
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                return time;
            }
            
            if(board[nx][ny] == 2) {
                return time;
            }
                
            if(board[nx][ny] == 1) {
                dq.addFirst(new int[]{nx, ny});
                board[nx][ny] = 2;
            }else {
                dq.addFirst(new int[]{nx, ny});
                board[nx][ny] = 2;
                
                int[] tail = dq.pollLast();
                board[tail[0]][tail[1]] = 0;
            }
            
            if(map.containsKey(time)) {
                if(map.get(time) == 'L') {
                    dir = (dir + 3) % 4;
                }else {
                    dir = (dir + 1) % 4;
                }
            }
        }
    }
}