import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            solve(H, W, N);
        }
    }
    static void solve(int H, int W, int N) {
        int floor = N%H;
        if(N%H == 0) floor = H;
        int room = N/H;
        if(N%H != 0) room++;
        String h = Integer.toString(floor);
        String w = Integer.toString(room);
        if(room<10) w = "0"+w;
        
        System.out.println(h+w);
    }
}