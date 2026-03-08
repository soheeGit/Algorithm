import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        
        int count = 0;
        
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        
        System.out.println(count);
    }
}