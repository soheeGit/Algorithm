import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] fruit;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        fruit = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        
        for(int i=0; i<N; i++) {
            fruit[i] = Integer.parseInt(st.nextToken());
        }
        
        solve();
    }
    static void solve() {
        int left = 0;
        int maxLen = 0;
        
        for(int i=0; i<N; i++) {
            int f = fruit[i];
            map.put(f, map.getOrDefault(f, 0) + 1);
            
            while(map.size() > 2) {
                int leftFruit = fruit[left];
                map.put(leftFruit, map.get(leftFruit) - 1);
                if (map.get(leftFruit) == 0) map.remove(leftFruit);
                left++;
            }
            
            maxLen = Math.max(maxLen, i - left + 1);
        }
        
        System.out.println(maxLen);
    }
}