import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();
        
        int start = -1;
        
        if(!s1.equals("Fizz") && !s1.equals("Buzz") && !s1.equals("FizzBuzz")) {
            start = Integer.parseInt(s1);
        }else if(!s2.equals("Fizz") && !s2.equals("Buzz") && !s2.equals("FizzBuzz")) {
            start = Integer.parseInt(s2) - 1;
        }else if (!s3.equals("Fizz") && !s3.equals("Buzz") && !s3.equals("FizzBuzz")) {
            start = Integer.parseInt(s3) - 2;
        }
        
        System.out.println(getFizzBuzz(start + 3));
    }
    
    static String getFizzBuzz(int n) {
        if (n % 3 == 0 && n % 5 == 0) return "FizzBuzz";
        if (n % 3 == 0) return "Fizz";
        if (n % 5 == 0) return "Buzz";
        return Integer.toString(n);
    }
}