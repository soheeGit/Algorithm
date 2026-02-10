import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int unit = 10;
        while(unit <= n) {
            n = (n + unit / 2) / unit * unit;
            unit *= 10;
        }

        System.out.println(n);
    }
}