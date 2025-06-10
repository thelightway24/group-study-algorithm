import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] map = new int[65][65];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            String temp = br.readLine();
            for (int j = 0; j < temp.length(); ++j) map[i][j] = temp.charAt(j) - '0';
        }

        quadTree(n, 0, 0);
    }

    public static void quadTree(int n, int x, int y) {
        int pos = n / 2;
        int curVal = map[x][y];
        for (int i = x; i < x + n; ++i) {
            for (int j = y; j < y + n; ++j) {
                if (map[i][j] != curVal) {
                    System.out.print("(");
                    quadTree(pos, x, y);
                    quadTree(pos, x, y + pos);
                    quadTree(pos, x + pos, y);
                    quadTree(pos, x + pos, y + pos);
                    System.out.print(")");
                    return;
                }
            }
        }
        if (curVal == 0) {
            System.out.print("0");
        }
        else {
            System.out.print("1");
        }
    }

}