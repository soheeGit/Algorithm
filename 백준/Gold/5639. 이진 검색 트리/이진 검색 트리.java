import java.util.*;
import java.io.*;

class Main {
    static List<Integer> arr = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            arr.add(Integer.parseInt(line));
        }
        
        solve(0, arr.size() - 1);
        
        for(int r : result) {
            System.out.println(r);
        }
    }
    static void solve(int start, int end) {
        if(start > end) return;
        int root = arr.get(start);
        int mid = end + 1;

        for(int i=start + 1; i<=end; i++) {
            if(arr.get(i) > root) {
                mid = i;
                break;
            }
        }
        
        solve(start + 1, mid - 1);
        solve(mid, end);
        result.add(root);
    }
}