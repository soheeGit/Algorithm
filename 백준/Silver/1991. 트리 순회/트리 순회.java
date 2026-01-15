import java.util.*;
import java.io.*;

class Main {
    static char[] left;
    static char[] right;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        left = new char[N];
        right = new char[N];
        
        Arrays.fill(left, '.');
        Arrays.fill(right, '.');
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);
            
            int parent = a - 'A';
            left[parent] = b;
            right[parent] = c;
        }
        

        sb = new StringBuilder();
        preorder(0);
        System.out.println(sb.toString());

        sb = new StringBuilder();
        inorder(0);
        System.out.println(sb.toString());

        sb = new StringBuilder();
        postorder(0);
        System.out.println(sb.toString());
    }
    static void preorder(int node) {
        sb.append((char)(node + 'A'));

        if(left[node] != '.') {
            preorder(left[node] - 'A');
        }
        if(right[node] != '.') {
            preorder(right[node] - 'A');
        }
    }
    static void inorder(int node) {
        if(left[node] != '.') {
            inorder(left[node] - 'A');
        }

        sb.append((char)(node + 'A'));

        if(right[node] != '.') {
            inorder(right[node] - 'A');
        }
    }
    static void postorder(int node) {
        if(left[node] != '.') {
            postorder(left[node] - 'A');
        }
        if(right[node] != '.') {
            postorder(right[node] - 'A');
        }

        sb.append((char)(node + 'A'));
    }
}