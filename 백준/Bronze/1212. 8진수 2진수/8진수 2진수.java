import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if(input.equals("0")) {
            System.out.println("0");
            return;
        }

        String[] binary = {
            "000","001","010","011",
            "100","101","110","111"
        };

        StringBuilder sb = new StringBuilder();

        int first = input.charAt(0) - '0';
        sb.append(Integer.toBinaryString(first));

        for(int i = 1; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            sb.append(binary[num]);
        }

        System.out.println(sb);
    }
}