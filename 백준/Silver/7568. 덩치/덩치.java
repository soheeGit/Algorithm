import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] person;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        person = new int[N][2]; 
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            person[i][0] = Integer.parseInt(st.nextToken());
            person[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<N; i++) {
            sb.append(solve(i)).append(" ");
        }
        
        System.out.println(sb);
    }
    static int solve(int i) {
        int count = 1;
        for(int j=0; j<N; j++) {
            if(i == j) continue;
            if(person[i][0] < person[j][0] && person[i][1] < person[j][1]) {
                count++;
            }
        }
        return count;
    }
}