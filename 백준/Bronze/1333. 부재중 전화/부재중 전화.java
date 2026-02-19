import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int totalTime = N * L + (N - 1) * 5;
        int block = L + 5;

        for (int t = 0; ; t += D) {

            if (t >= totalTime) {
                System.out.println(t);
                break;
            }

            int songIndex = t / block;
            int mod = t % block;

            if (mod >= L) {
                System.out.println(t);
                break;
            }
        }
    }
}
