import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            Deque<Integer> deque = new ArrayDeque<>();
            
            if (n > 0) {
                String[] nums = arr.substring(1, arr.length() - 1).split(",");
                for (String num : nums) {
                    deque.addLast(Integer.parseInt(num));
                }
            }
            sb.append(solve(p, deque)).append("\n");
        }
        
        System.out.println(sb);
    }
    static String solve(String p, Deque<Integer> deque) {
        boolean reversed = false;
        
        for(int i=0; i<p.length(); i++) {
            char ac = p.charAt(i);
            if(ac == 'R') {
                reversed = !reversed;
            }else{
                if (deque.isEmpty()) {
                    return "error";
                }
                if(!reversed) deque.pollFirst();
                else deque.pollLast();
            }
        }
        
        return buildResult(deque, reversed);
    }
    static String buildResult(Deque<Integer> deque, boolean reversed) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (!deque.isEmpty()) {
            sb.append(reversed ? deque.pollLast() : deque.pollFirst());
            if (!deque.isEmpty()) sb.append(",");
        }

        sb.append("]");
        return sb.toString();
    }
}