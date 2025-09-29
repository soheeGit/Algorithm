import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i][0] = start;
            arr[i][1] = end;
        }
        Arrays.sort(arr, (a, b) -> {
            if(a[1] == b[1]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1], b[1]);
        });
        
        int end = 0;
        int count = 0;
        for(int[] a : arr) {
            if(end <= a[0]) {
                end = a[1];
                count++;
            }
        }
        System.out.println(count);
    }
}