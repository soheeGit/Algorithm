import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int num = 666;
        
        while(count < N) {
            if(String.valueOf(num).contains("666")) {
                count++;
            }
            num++;
        }
        System.out.println(num-1);
    }
}