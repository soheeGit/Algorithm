import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int result = A*B*C;
        int[] num = new int[10];
        
        String s = Integer.toString(result);
        for(int i=0; i<s.length(); i++) {
            int n = s.charAt(i)-'0';
            num[n]++;
        }
        
        for(int i=0; i<=9; i++){
            System.out.println(num[i]);            
        }
    }
}