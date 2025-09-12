import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        int top = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            if(s.equals("push")) {
                stack[top] = Integer.parseInt(st.nextToken());
                top++;
            }else if(s.equals("top")) {
                if(top == 0) System.out.println(-1);
                else System.out.println(stack[top-1]);
            }else if(s.equals("size")) {
                System.out.println(top);
            }else if(s.equals("empty")) {
                if(top == 0) System.out.println(1);
                else System.out.println(0);
            }else if(s.equals("pop")) {
                if(top == 0) System.out.println(-1);
                else {
                    top--;
                    System.out.println(stack[top]);
                }
            }
        }
    }
}