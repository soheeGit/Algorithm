import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> value = new HashMap<>();
        Map<String, Long> multiplier = new HashMap<>();

        value.put("black", 0); multiplier.put("black", 1L);
        value.put("brown", 1); multiplier.put("brown", 10L);
        value.put("red", 2); multiplier.put("red", 100L);
        value.put("orange", 3); multiplier.put("orange", 1000L);
        value.put("yellow", 4); multiplier.put("yellow", 10000L);
        value.put("green", 5); multiplier.put("green", 100000L);
        value.put("blue", 6); multiplier.put("blue", 1000000L);
        value.put("violet", 7); multiplier.put("violet", 10000000L);
        value.put("grey", 8); multiplier.put("grey", 100000000L);
        value.put("white", 9); multiplier.put("white", 1000000000L);

        String c1 = br.readLine();
        String c2 = br.readLine();
        String c3 = br.readLine();

        long num = value.get(c1) * 10 + value.get(c2);
        long result = num * multiplier.get(c3);

        System.out.println(result);
    }
}