import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        
        long result = solve(A, B, C);
        System.out.println(result);
    }
    static long solve(long a, long b, long c) {
        if (b == 1) return a % c;
        
        long half = solve(a, b / 2, c);
        long result = (half * half) % c;
        
        if (b % 2 == 1) {
            result = (result * (a % c)) % c;
        }
        return result;
    }
}