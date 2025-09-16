import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static HashSet<String> str;
    static ArrayList<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        str = new HashSet<>();
        for (int i = 0; i < N; i++) {
            str.add(br.readLine());
        }
        
        result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if(str.contains(name)) {
                result.add(name);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (String r: result) {
            System.out.println(r);
        }
    }
}
