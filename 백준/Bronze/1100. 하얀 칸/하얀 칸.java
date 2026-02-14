import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int count = 0;

        for(int i = 0; i < 8; i++) {
            String line = br.readLine();

            for(int j = 0; j < 8; j++) {
                if(line.charAt(j) == 'F' && (i + j) % 2 == 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}