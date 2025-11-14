import java.util.*;
import java.io.*;

class Main {
    static String s1, s2;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        s1 = br.readLine();
        s2 = br.readLine();
        
        int n = s1.length();
        int m = s2.length();
        
        dp = new int[n + 1][m + 1];
        
        lcs(n, m);
        System.out.println(dp[n][m]);
    }
    static void lcs(int n, int m) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }
}