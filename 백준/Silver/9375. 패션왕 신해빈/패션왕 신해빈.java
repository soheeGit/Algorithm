import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String type = st.nextToken();
                
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            
            int result = 1;
            for(int count : map.values()) {
                result *= (count + 1);
            }
            
            sb.append(result - 1).append('\n');
        }
        
        System.out.print(sb);
    }
}
