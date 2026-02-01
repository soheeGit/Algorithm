import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sh = Integer.parseInt(st.nextToken());
            int sm = Integer.parseInt(st.nextToken());
            int ss = Integer.parseInt(st.nextToken());
            int eh = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int es = Integer.parseInt(st.nextToken());

            int start = sh * 3600 + sm * 60 + ss;
            int end = eh * 3600 + em * 60 + es;

            int diff = end - start;

            int h = diff / 3600;
            int m = (diff % 3600) / 60;
            int s = diff % 60;

            System.out.println(h + " " + m + " " + s);
        }
    }
}