import java.util.*;
import java.io.*;

class Main{
    static int N, S;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        S = Integer.parseInt(br.readLine());
        s = br.readLine();
        
        System.out.println(solve());
    }
    static int solve() {
        int count = 0;
        int result = 0;
        for(int i=1; i<S - 1; i++) {
            if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
                count++;
                if(count == N) {
                    result++;
                    count--;
                }
                i++;
            }else {
                count = 0;
            }
        }
        return result;
    }
}