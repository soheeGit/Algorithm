import java.util.*;
import java.io.*;

class Main {
    static class Problem {
        int idx, score;
        
        Problem(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List<Problem> list = new ArrayList<>();
        
        for(int i=1; i<=8; i++) {
            int score = Integer.parseInt(br.readLine());
            list.add(new Problem(i, score));
        }
        
        Collections.sort(list, (a, b) -> b.score - a.score);
        
        int sum = 0;
        List<Integer> selected = new ArrayList<>();
        
        for(int i=0; i<5; i++) {
            sum += list.get(i).score;
            selected.add(list.get(i).idx);
        }
        
        Collections.sort(selected);
        
        System.out.println(sum);
        
        for(int num : selected) {
            System.out.print(num + " ");
        }
    }
}