import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr, result;
    static boolean[] exist = new boolean[1000001];
    static int[] index = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        result = new int[N + 1];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            exist[arr[i]] = true;
            index[arr[i]] = i;
        }
        
        solve();
        
        for(int i=1; i<=N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
    static void solve() {
        for(int i=1; i<=N; i++) {
            int x = arr[i];
            for(int j=x * 2; j<=1000000; j+=x) {
                if(exist[j]) {
                    result[i]++;
                    result[index[j]]--;
                }
            }
        }
    }
}