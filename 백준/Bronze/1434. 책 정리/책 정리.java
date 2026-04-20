import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] box = new int[N];
        int[] book = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            book[i] = Integer.parseInt(st.nextToken());
        }

        int j = 0;
        int waste = 0;

        for(int i = 0; i < N; i++) {
            int capacity = box[i];

            while(j < M && capacity >= book[j]) {
                capacity -= book[j];
                j++;
            }

            waste += capacity;
        }

        System.out.println(waste);
    }
}