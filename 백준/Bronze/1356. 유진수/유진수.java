import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String N = br.readLine();
        int length = N.length();
        boolean isYujin = false;

        for(int i = 1; i < length; i++) {
            int leftProduct = 1;
            int rightProduct = 1;

            for(int j = 0; j < i; j++) {
                leftProduct *= N.charAt(j) - '0';
            }

            for(int j = i; j < length; j++) {
                rightProduct *= N.charAt(j) - '0';
            }

            if(leftProduct == rightProduct) {
                isYujin = true;
                break;
            }
        }

        if(isYujin) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}