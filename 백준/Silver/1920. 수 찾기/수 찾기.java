import java.util.*;
import java.io.*;

class Main {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N, M;
        int[] A;
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A);
        
        M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st2.nextToken());
            if (Arrays.binarySearch(A, num) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}