import java.io.*;
import java.util.*;

class Main {
    static int N, T, P;
    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        size = new int[6];
        for(int i=0; i<6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        
        tSolve();
        pSolve();
    }
    static void tSolve() {
        int[] result = new int[size.length];
        int sum = 0;
        for(int i=0; i<size.length; i++) {
            int n = size[i]/T;
            if(n == 0) {
                if(size[i]%T != 0) {
                    result[i] = 1;
                }
            }else if(n != 0) {
                if(size[i]%T != 0) {
                    result[i] = n+1;
                }else {
                    result[i] = n;
                }
            }
        }
        for(int i=0; i<result.length; i++) {
            sum += result[i];
        }
        System.out.println(sum);
    }
    static void pSolve() {
        System.out.println(N/P+" "+N%P);
    }
}