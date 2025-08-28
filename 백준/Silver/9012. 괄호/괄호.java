import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            
            for(int j=0; j<s.length(); j++) {
                char c = s.charAt(j);
                if(c == '(') {
                    stack.push(c);
                }else {
                    if(stack.isEmpty()) {
                        System.out.println("NO");
                        break;
                    }
                    stack.pop();
                }
                if(j == s.length()-1){
                    if(stack.isEmpty()) {
                        System.out.println("YES");
                    }else {
                        System.out.println("NO");
                    }
                }
            }
        }
    }
}