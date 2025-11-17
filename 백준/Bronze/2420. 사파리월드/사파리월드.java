import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        
        long c = Math.abs(a - b);
        System.out.println(c);
    }
}