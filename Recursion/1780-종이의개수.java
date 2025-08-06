import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static Map<Integer, Integer> paper = new HashMap<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        for (int i = 0; i < n; ++i) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; ++j) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        paper.put(-1, 0);
        paper.put(0, 0);
        paper.put(1, 0);
        solve(n, 0, 0);
        System.out.println(paper.get(-1));
        System.out.println(paper.get(0));
        System.out.println(paper.get(1));
    }


    public static void solve(int size, int x, int y) {
        if (size == 0) return;
        int pos = size / 3;
        int val = map[x][y];
        for (int i = x; i < x + size; ++i) {
            for (int j = y; j < y + size; ++j) {
                if (map[i][j] != val) {
                    solve(pos, x, y);
                    solve(pos, x + pos, y);
                    solve(pos, x + 2 * pos, y);
                    solve(pos, x, y + pos);
                    solve(pos, x + pos, y + pos);
                    solve(pos, x + 2 * pos, y + pos);
                    solve(pos, x, y + 2 * pos);
                    solve(pos, x + pos, y + 2 * pos);
                    solve(pos, x + 2 * pos, y + 2 * pos);
                    return;
                }
            }
        }
        if (val == -1) {
            paper.put(-1, paper.get(-1) + 1);
        } else if (val == 0) {
            paper.put(0, paper.get(0) + 1);
        } else {
            paper.put(1, paper.get(1) + 1);
        }
    }
}