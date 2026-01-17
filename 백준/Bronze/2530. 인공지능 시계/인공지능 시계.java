import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int D = Integer.parseInt(br.readLine());

        int total = A * 3600 + B * 60 + C + D;
        total %= 86400;

        int hour = total / 3600;
        int minute = (total % 3600) / 60;
        int second = total % 60;

        System.out.println(hour + " " + minute + " " + second);
    }
}