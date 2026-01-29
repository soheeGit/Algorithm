import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int total = 0;
        for (int i = 0; i < 4; i++) {
            total += Integer.parseInt(br.readLine());
        }
        
        int minutes = total / 60;
        int seconds = total % 60;
        
        System.out.println(minutes);
        System.out.println(seconds);
    }
}