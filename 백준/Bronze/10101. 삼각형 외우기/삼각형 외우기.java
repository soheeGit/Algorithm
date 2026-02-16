import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int sum = a + b + c;

        if(sum != 180) {
            System.out.println("Error");
        }
        else if(a == 60 && b == 60 && c == 60) {
            System.out.println("Equilateral");
        }
        else if(a == b || b == c || a == c) {
            System.out.println("Isosceles");
        }
        else {
            System.out.println("Scalene");
        }
    }
}