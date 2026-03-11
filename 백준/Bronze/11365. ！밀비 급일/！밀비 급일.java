import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            String str = br.readLine();
            
            if(str.equals("END")) break;
            
            StringBuilder sb = new StringBuilder(str);
            System.out.println(sb.reverse());
        }
    }
}