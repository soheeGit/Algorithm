import java.util.*;
import java.io.*;

class Main {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        System.out.println(brute(board, N, M));
    }
    static int brute(char[][] board, int N, int M) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<=N-8; i++) {
            for(int j=0; j<=M-8; j++) {
                int w = 0;
                int b = 0;
                for(int k=0; k<8; k++) {
                    for(int l=0; l<8; l++) {
                        char cur = board[k+i][l+j];
                        if((k+l)%2 == 0) {
                            if(cur != 'W') w++;
                            if(cur != 'B') b++;
                        } else {
                            if(cur != 'B') w++;
                            if(cur != 'W') b++;
                        }
                    }
                }
                min = Math.min(min, Math.min(w, b));
            }
        }
        return min;
    }
}