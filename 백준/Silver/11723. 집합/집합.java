import java.util.*;
import java.io.*;

class Main {
    static boolean[] num = new boolean[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String a = st.nextToken();
            if(a.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                num[x] = true;
            } else if(a.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append(num[x] ? 1 : 0).append('\n');
            } else if(a.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                num[x] = false;
            } else if(a.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                num[x] = !num[x];
            } else if(a.equals("all")) {
                Arrays.fill(num, true);
            } else if(a.equals("empty")) {
                Arrays.fill(num, false);
            }
        }
        System.out.print(sb);
    }
}