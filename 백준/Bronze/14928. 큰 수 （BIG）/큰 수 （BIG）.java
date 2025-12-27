import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int mod = 20000303;
        long remainder = 0;
        
        int c;
        while ((c = br.read()) != -1) {
            if (c >= '0' && c <= '9') {
                remainder = (remainder * 10 + (c - '0')) % mod;
            }
        }
        
        System.out.println(remainder);
        br.close();
    }
}