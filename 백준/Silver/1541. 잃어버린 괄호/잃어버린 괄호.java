import java.io.*;
import java.util.*;

class Main {
    static String[] str;
    static int[] num;
    static int parts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        parts = st.countTokens();
        str = new String[parts];
        num = new int[parts];
        for(int i=0; i<parts; i++) {
            str[i] = st.nextToken();
        }
        solve();
    }
    static void solve() {
        int n;
        for(int i=0; i<str.length; i++) {
            String[] addParts = str[i].split("\\+");
            for(String s : addParts) {
                num[i] += Integer.parseInt(s);
            }
        }
        n = num[0];
        for(int i=1; i<num.length; i++) {
            n -= num[i];
        }
        System.out.println(n);
    }
}