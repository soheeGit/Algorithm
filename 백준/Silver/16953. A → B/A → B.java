import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        System.out.println(solve(A, B));
    }
    static int solve(int a, int b) {
        int count = 1;
        
        while(a < b) {
            if(b % 10 == 1) {
                b /= 10;
            }else if(b % 2 == 0) {
                b /= 2;
            }else {
                return -1;
            }
            count++;
        }
        
        if(a == b) {
            return count;
        }else return -1;
    }
}