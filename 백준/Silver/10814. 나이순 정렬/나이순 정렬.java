import java.io.*;
import java.util.*;

class Main {
    static class Member {
        int age;
        String name;
        Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Member(age, name));
        }

        Collections.sort(list, (a, b) -> a.age - b.age);

        for (Member m : list) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        System.out.print(sb);
    }
}