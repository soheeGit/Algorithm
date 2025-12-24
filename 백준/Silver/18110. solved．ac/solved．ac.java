import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] level = new int[n];
        for(int i=0; i<n; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(level);
        
        int count = (int)Math.round(n * 0.15);
        
        int sum = 0;
        int sumCount = n - 2 * count;
        for(int i=count; i<n-count; i++) {
            sum += level[i];
        }
        
        System.out.println((int)Math.round((double)sum / sumCount));
    }
}