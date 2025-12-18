import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(solve());
    }
    static String solve() {
        int left = 0;
        int right = N - 1;
        int result = arr[left] + arr[right];
        int resultL = 0;
        int resultR = N - 1;
        
        while(left < right) {
            int a = arr[left] + arr[right];
            if(Math.abs(result) > Math.abs(a)) {
                resultL = left;
                resultR = right;
                result = a;
            }
            
            if(a == 0) break;
            else if(a < 0) {
                left++;
            } else {
                right--;
            }
        }
        
        return arr[resultL] + " " + arr[resultR];
    }
}