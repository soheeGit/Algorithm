import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        int num = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'X') num++;
            else if(s.charAt(i) == '.') {
                if(num % 2 != 0) {
                    System.out.println(-1);
                    return;
                }else {
                    int a = num / 4;
                    int b = (num - a * 4) / 2;
                    for(int j=0; j<a; j++) {
                        sb.append("AAAA");
                    }
                    for(int j=0; j<b; j++) {
                        sb.append("BB");
                    }
                }
                num = 0;
                sb.append('.');
            }
        }
        
        if(num != 0) {
            if(num % 2 != 0) {
                System.out.println(-1);
                return;
            }else {
                int a = num / 4;
                int b = (num - a * 4) / 2;
                for(int j=0; j<a; j++) {
                    sb.append("AAAA");
                }
                for(int j=0; j<b; j++) {
                    sb.append("BB");
                }
            }
        }
        
        System.out.println(sb);
    }
}