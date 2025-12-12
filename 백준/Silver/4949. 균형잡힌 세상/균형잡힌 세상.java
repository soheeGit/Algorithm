import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            String s = br.readLine();
            if(s.equals(".")) break;
            
            Stack<Character> stack = new Stack<>();
            String result = "yes";
            
            for(int i=0; i<s.length(); i++) {
                char s1 = s.charAt(i);
            
                if(s1 == '(') {
                    stack.push('(');
                }else if(s1 == ')') {
                    if(stack.isEmpty() || stack.pop() != '(') {
                        result = "no";
                        break;
                    }
                }else if(s1 == '[') {
                    stack.push('[');
                }else if(s1 == ']') {
                    if(stack.isEmpty() || stack.pop() != '[') {
                        result = "no";
                        break;
                    }
                }
            }
            
            if(!stack.isEmpty()) {
                result = "no";
            }
            
            sb.append(result).append("\n");
        }
        
        System.out.println(sb);
    }
}