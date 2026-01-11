import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (true) {
            line = br.readLine();

            if (line.equals("#")) {
                break;
            }

            int count = 0;

            for (int i = 0; i < line.length(); i++) {
                char c = Character.toLowerCase(line.charAt(i));
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}