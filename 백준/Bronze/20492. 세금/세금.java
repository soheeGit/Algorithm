import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int case1 = (int)(N * 0.78);
        int case2 = (int)(N * 0.956);

        System.out.println(case1 + " " + case2);
    }
}