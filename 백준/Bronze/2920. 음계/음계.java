import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] row = new int[8];
        boolean asc = true;
        boolean dec = true;
        
        for(int i=0; i<8; i++) {
            row[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<8; i++) {
            if(row[i] != i+1) asc = false;
            if(row[i] != 8-i) dec = false;
        }
        
        if(asc) System.out.println("ascending");
        else if(dec) System.out.println("descending");
        else System.out.println("mixed");
    }
}