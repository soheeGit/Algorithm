import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        String[] s = new String[N];
        for (int i = 0; i < N; i++) {
            s[i] = br.readLine();
        }
        
        Arrays.sort(s, (a, b) -> {
            if (a.length() != b.length()) return a.length() - b.length();
            return a.compareTo(b);
        });
        
        sb.append(s[0]).append("\n");
        for (int i = 1; i < N; i++) {
            if (!s[i].equals(s[i-1])) sb.append(s[i]).append("\n");
        }
        System.out.print(sb);
    }
}
