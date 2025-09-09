import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int A, B, C;
        
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            if(A==0 && B==0 && C==0) {
                break;
            }
            
            int max = Math.max(A, Math.max(B, C));
            if(max == A) {
                if(((C*C)+(B*B))==(A*A)) System.out.println("right");
                else System.out.println("wrong");
            }else if(max == B) {
                if(((C*C)+(A*A))==(B*B)) System.out.println("right");
                else System.out.println("wrong");
            }else {
                if(((A*A)+(B*B))==(C*C)) System.out.println("right");
                else System.out.println("wrong");
            }
        }
    }
}