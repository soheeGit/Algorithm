import java.util.*;
import java.io.*;

class Main {
    static int N, result = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        comb(1, 1);

        System.out.println(result);
    }

    static void comb(int start, int depth) {
        if (depth == N / 2) {
            calculate();
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            comb(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    static void calculate() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {

                if (visited[i] && visited[j]) {
                    startTeam += arr[i][j] + arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += arr[i][j] + arr[j][i];
                }

            }
        }

        int diff = Math.abs(startTeam - linkTeam);
        result = Math.min(result, diff);
    }
}