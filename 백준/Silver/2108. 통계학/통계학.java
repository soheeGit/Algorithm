import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());
            list.add(x);
            map.put(x, map.getOrDefault(x, 0) + 1);
            sum += x;
        }
        Collections.sort(list);
        
        sb.append((int)Math.round((double)sum/N)).append("\n");
        sb.append(list.get(N/2)).append("\n");
        
        int maxFreq = Collections.max(map.values());
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modes.add(entry.getKey());
            }
        }
        Collections.sort(modes);
        if (modes.size() > 1) {
            sb.append(modes.get(1)).append("\n");
        } else {
            sb.append(modes.get(0)).append("\n");
        }
        
        sb.append(list.get(N-1)-list.get(0));
        System.out.println(sb);
    }
}