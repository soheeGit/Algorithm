import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            System.out.println(i + ". " + line);
        }
    }
}