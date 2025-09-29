import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for(int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                String a = st.nextToken();
                int b = Integer.parseInt(st.nextToken());
                solve(a, b, map);
            }
            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
    static void solve(String a, int b, TreeMap<Integer, Integer> map) {
        if(a.equals("I")) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }else {
            if(map.isEmpty()) return;
            if(b == -1) {
                int fk = map.firstKey();
                if(map.get(fk) == 1) map.remove(fk);
                else map.put(fk, map.get(fk) - 1);
            }else {
                int lk = map.lastKey();
                if(map.get(lk) == 1) map.remove(lk);
                else map.put(lk, map.get(lk) - 1);
            }
        }
    }
}