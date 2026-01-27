import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        
        int koreanDays = (A + C - 1) / C;
        int mathDays = (B + D - 1) / D;
        
        int studyDays = Math.max(koreanDays, mathDays);
        
        System.out.println(L - studyDays);
    }
}