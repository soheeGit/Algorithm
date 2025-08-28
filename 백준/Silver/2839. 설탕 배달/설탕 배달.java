import java.util.*;
import java.io.*;

class Main {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int min = Integer.MAX_VALUE;
        int N = Integer.parseInt(br.readLine());
        int num = N/5;
        
        for(int i=0; i<=num; i++) {
            if(i == 0){
                if(N%3==0) {
                    min = Math.min(min, N/3);
                }
            } else {
                if((N-i*5)%3==0) {
                    min = Math.min(min, i+(N-i*5)/3);
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(min);
        }
    }
}