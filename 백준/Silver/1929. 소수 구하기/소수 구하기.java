import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N-M+1];
        
        int idx = 0;
        for(int i=M; i<=N; i++) {
            arr[idx] = i;
            idx++;
        }
        
        for(int i=0; i<arr.length; i++) {
            if(isPrime(arr[i])) {
                sb.append(arr[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
    static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i=2; i*i<=n; i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
}