import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] queue = new int[N];
        int back = 0;
        int front = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            if(s.equals("push")) {
                queue[back] = Integer.parseInt(st.nextToken());
                back++;
            }else if(s.equals("size")) {
                System.out.println(back-front);
            }else if(s.equals("empty")) {
                if(back == front) System.out.println(1);
                else System.out.println(0);
            }else if(s.equals("back")) {
                if(back == front) System.out.println(-1);
                else System.out.println(queue[back-1]);
            }else if(s.equals("front")) {
                if(back == front) System.out.println(-1);
                else System.out.println(queue[front]);
            }else if(s.equals("pop")) {
                if(back == front) System.out.println(-1);
                else {
                    System.out.println(queue[front]);
                    front++;
                }
            }
        }
    }
}