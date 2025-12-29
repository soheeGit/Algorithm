import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] arr;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        solve(0, 0, N);
        
        System.out.println(white);
        System.out.println(blue);
    }
    static void solve(int x, int y, int size) {
        if(isSameColor(x, y, size)) {
            if(arr[x][y] == 0) white++;
            else blue++;
            return;
        }
        
        int newSize = size / 2;
        solve(x, y, newSize);
        solve(x, y + newSize, newSize);
        solve(x + newSize, y, newSize);
        solve(x + newSize, y + newSize, newSize);
    }
    static boolean isSameColor(int x, int y, int size) {
        int color = arr[x][y];
        for(int i=x; i<x + size; i++) {
            for(int j=y; j<y + size; j++) {
                if(arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}