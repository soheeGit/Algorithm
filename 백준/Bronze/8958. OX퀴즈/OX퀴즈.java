import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            String s = br.readLine();
            solve(s);
        }
    }
    static void solve(String s) {
        int ren = s.length();
        int result = 0;
        int[] str = new int[ren];
        if(s.charAt(0) == 'O') str[0] = 1;
        
        for(int i=1; i<ren; i++) {
            char c = s.charAt(i);
            if(c == 'O') {
                str[i] += str[i-1]+1;
            }else{
                str[i] = 0;
            }
        }
        
        for(int i=0; i<str.length; i++) {
            result += str[i];
        }
        System.out.println(result);
    }
}