import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String str = br.readLine();
            if(str.equals("0")) break;
            int length = str.length();
            boolean t = true;
            
            for (int i=0; i<length/2; i++) {
                if (str.charAt(i) != str.charAt(length-1-i)) {
                    t = false;
                    break;
                }
            }
            if(t == true) System.out.println("yes");
            else System.out.println("no");
        }
    }
}