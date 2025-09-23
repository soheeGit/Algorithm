import java.util.*;
import java.io.*;

class Main {
    static int N, C;
    static int[] houses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        houses = new int[N];
        
        for(int i=0; i<N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);
        
        int result = solve();
        System.out.println(result);
    }
    static int solve() {
        int low = 1;
        int high = houses[N - 1] - houses[0];
        int result = 0;
        
        while(low <= high) {
            int mid = (low + high)/2;
            if(install(mid)) {
                result = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return result;
    }
    static boolean install(int mid) {
        int count = 1;
        int lastInstalled = houses[0];
        
        for (int i=1; i<N; i++) {
            if (houses[i]-lastInstalled >= mid) {
                count++;
                lastInstalled = houses[i];
            }
        }
        return count >= C;
    }
}