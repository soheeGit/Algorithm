import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long n = 1;
        long k = 1;
        long nmk = 1;
        
        for(int i=N; i>=1; i--) n *= i;
        for(int i=K; i>=1; i--) k *= i;
        for(int i=(N-K); i>=1; i--) nmk *= i;
        
        System.out.println(n/(k*nmk));
    }
}
