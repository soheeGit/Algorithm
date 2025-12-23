import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String isbn = br.readLine();
        
        int starPos = isbn.indexOf('*');
        
        int starWeight = (starPos % 2 == 0) ? 1 : 3;
        
        int sum = 0;
        for(int i=0; i<13; i++) {
            if (i != starPos) {
                int digit = isbn.charAt(i) - '0';
                int weight = (i % 2 == 0) ? 1 : 3;
                sum += digit * weight;
            }
        }
        
        for(int i=0; i<=9; i++) {
            if ((sum + starWeight * i) % 10 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}