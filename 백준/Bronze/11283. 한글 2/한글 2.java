import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char c = br.readLine().charAt(0);
        
        int result = c - '가' + 1;
        
        System.out.println(result);
    }
}