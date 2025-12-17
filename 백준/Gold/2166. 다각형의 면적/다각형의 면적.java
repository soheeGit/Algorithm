import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[] x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        x = new long[n];
        y = new long[n];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }
        
        System.out.println(solve());
        
        br.close();
    }
    static String solve() {
        long sum = 0;
        
        for(int i=1; i<n-1; i++) {
            long a = x[0] * y[i];
            long b = x[i] * y[i+1];
            long c = x[i+1] * y[0];
            long d = x[i] * y[0];
            long e = x[i+1] * y[i];
            long f = x[0] * y[i+1];
            
            sum += (a + b + c) - (d + e + f);
        }
        
        double result = Math.abs(sum) / 2.0;
        return String.format("%.1f", result);
    }
}