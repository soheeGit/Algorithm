import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int len = s.length();
        int mod = len % 3;

        if (mod == 1) s = "00" + s;
        else if (mod == 2) s = "0" + s;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i += 3) {
            int val =
                (s.charAt(i) - '0') * 4 +
                (s.charAt(i+1) - '0') * 2 +
                (s.charAt(i+2) - '0');

            sb.append(val);
        }

        System.out.println(sb);
    }
}
