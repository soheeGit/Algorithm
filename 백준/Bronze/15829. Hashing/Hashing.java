import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        long r = 31;
        long hash = 0;
        long pow = 1;
        
        for(int i=0; i<n; i++) {
            int a = s.charAt(i) - 'a' + 1;
            
            hash = (hash + a * pow) % 1234567891;
            pow = (pow * r) % 1234567891;
        }
        
        System.out.println(hash);
    }
}