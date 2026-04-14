import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ySum = 0;
        int mSum = 0;

        for(int i = 0; i < N; i++) {
            int time = Integer.parseInt(st.nextToken());

            ySum += (time / 30 + 1) * 10;
            mSum += (time / 60 + 1) * 15;
        }

        if(ySum < mSum) {
            System.out.println("Y " + ySum);
        } else if(ySum > mSum) {
            System.out.println("M " + mSum);
        } else {
            System.out.println("Y M " + ySum);
        }
    }
}