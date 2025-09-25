import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[] arr;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        if (solve()) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
    static boolean solve() {
        int cur = 0;
        for(int i=1; i<=n; i++) {
            int target = arr[i];
            while (cur < target) {
                stack.push(++cur);
                sb.append("+\n");
            }
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                return false;
            }
        }
        return true;
    }
}