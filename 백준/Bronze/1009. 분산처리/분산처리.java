import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(solve(a, b));
        }
    }
    static int solve(int a, int b) {
        int result = 1;
        
        for (int i = 0; i < b; i++) {
            result = (result * a) % 10;
        }
        
        return result == 0 ? 10 : result;
    }
}