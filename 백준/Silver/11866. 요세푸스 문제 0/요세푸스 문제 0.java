import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=N; i++) list.add(i);
        
        int index = 0;
        sb.append("<");
        while(!list.isEmpty()) {
            index = (index + K - 1) % list.size();
            sb.append(list.remove(index));
            if (!list.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}