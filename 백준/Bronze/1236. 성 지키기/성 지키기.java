import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] row = new boolean[N];
        boolean[] col = new boolean[M];
        
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                if (line.charAt(j) == 'X') {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        int rowEmpty = 0;
        int colEmpty = 0;

        for(int i=0; i<N; i++) {
            if(!row[i]) rowEmpty++;
        }

        for(int j=0; j<M; j++) {
            if(!col[j]) colEmpty++;
        }
        
        System.out.println(Math.max(rowEmpty, colEmpty));
    }
}