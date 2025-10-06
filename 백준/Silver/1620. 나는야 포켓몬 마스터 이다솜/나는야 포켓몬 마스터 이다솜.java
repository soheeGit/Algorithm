import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = new String[N+1];
        
        for (int i=1; i<=N; i++) {
            String name = br.readLine();
            map.put(name, i);
            arr[i] = name;
        }
        
        for (int i=0; i<M; i++) {
            String q = br.readLine();
            if (isNumber(q)) {
                int idx = Integer.parseInt(q);
                sb.append(arr[idx]).append("\n");
            } else {
                sb.append(map.get(q)).append("\n");
            }
        }
        System.out.print(sb);
    }
    static boolean isNumber(String s) {
        return s.charAt(0) >= '0' && s.charAt(0) <= '9';
    }
}
