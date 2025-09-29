import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        int sum = 0;
        for(int i=0; i<K; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a == 0) {
                s.pop();
            }else {
                s.push(a);
            }
        }
        int size = s.size();
        for(int i=0; i<size; i++) {
            if(s.isEmpty()) break;
            sum += s.pop();
        }
        
        System.out.println(sum);
    }
}