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
            int remain = N-i*5;
            if(remain%3 == 0) {
                min = Math.min(min, i+(remain)/3);
            }
        }
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(min);
        }
    }
}