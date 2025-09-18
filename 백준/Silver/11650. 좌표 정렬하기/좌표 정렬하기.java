import java.io.*;
import java.util.*;

class Main {
    static class XY {
        int x;
        int y;
        XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        List<XY> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new XY(x, y));
        }
        
        Collections.sort(list, (a, b) -> {
            if(a.x != b.x) return (a.x - b.x);
            else return (a.y - b.y);
        });
        
        for(XY xy: list) {
            sb.append(xy.x).append(" ").append(xy.y).append("\n");
        }
        System.out.print(sb);
    }
}