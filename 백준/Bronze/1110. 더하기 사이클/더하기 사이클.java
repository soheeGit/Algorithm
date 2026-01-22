import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int original = N;
        int count = 0;

        do {
            int tens = N / 10;
            int ones = N % 10;
            int sum = tens + ones;
            
            N = ones * 10 + (sum % 10);
            count++;
        } while (N != original);

        System.out.println(count);
    }
}