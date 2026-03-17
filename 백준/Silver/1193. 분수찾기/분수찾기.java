import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int n = 1;
        int sum = 0;

        while (sum + n < X) {
            sum += n;
            n++;
        }

        int k = X - sum;

        int numerator, denominator;

        if (n % 2 == 0) {
            numerator = k;
            denominator = n - k + 1;
        } else {
            numerator = n - k + 1;
            denominator = k;
        }

        System.out.println(numerator + "/" + denominator);
    }
}