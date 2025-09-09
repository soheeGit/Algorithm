import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        int[] num = new int[T];
        int result = 0;
        st = new StringTokenizer(br.readLine(), " ");
        
        for(int i=0; i<T; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<T; i++) {
            if(num[i]<2) continue;
            boolean isPrime = true;
            for(int j=2; j*j<=num[i]; j++) {
                if(num[i]%j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) result++;
        }
        System.out.println(result);
    }
}