import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int day = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;

        for (int i = 0; i < 5; i++) {
            int car = Integer.parseInt(st.nextToken());
            if (car == day) {
                count++;
            }
        }

        System.out.println(count);
    }
}