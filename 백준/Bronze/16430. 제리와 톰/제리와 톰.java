import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        
        int P = B - A;
        int Q = B;
        
        int gcd = gcd(P, Q);
        P /= gcd;
        Q /= gcd;
        
        System.out.println(P + " " + Q);
    }
    
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}