import java.util.*;
import java.io.*;

class Main {
    static int[][] arr = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0; i<9; i++) {
            String s = br.readLine();
            for(int j=0; j<9; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        
        solve();
    }
    static boolean solve() {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(arr[i][j] == 0) {
                    for(int num=1; num<=9; num++) {
                        if(!isPossible(i, j, num)) continue;
                        arr[i][j] = num;
                        if(solve()) return true;
                        arr[i][j] = 0;
                    }
                    return false;
                }
            }
        }            
        
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        
        return true;
    }
    static boolean isPossible(int r, int c, int num) {
        for(int i=0; i<9; i++) {
            if(arr[r][i] == num) return false;
        }
        for(int i=0; i<9; i++) {
            if(arr[i][c] == num) return false;
        }
        
        int row = (r / 3) * 3;
        int low = (c / 3) * 3;
        
        for(int i=row; i<row + 3; i++) {
            for(int j=low; j<low + 3; j++) {
                if(arr[i][j] == num) return false;
            }
        }
        
        return true;
    }
}