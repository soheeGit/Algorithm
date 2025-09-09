import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        System.out.println(A+B-C);
        
        String a = Integer.toString(A);
        String b = Integer.toString(B);
        int n = Integer.parseInt(a+b);
        
        System.out.println(n-C);
    }
}