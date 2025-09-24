import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        TreeSet<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            set.add(x);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int x : set) {
            map.put(x, rank++);
        }
        
        for(int i=0; i<N; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb);
    }
}