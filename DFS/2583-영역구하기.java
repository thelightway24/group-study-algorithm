import java.io.*;
import java.util.*;

public class Main {

    static int n,m,k;
    static int[][] map = new int[101][101];
    static boolean[][] vst = new boolean[101][101];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        for (int i = 0; i < k; ++i) {
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            for (int a = y1; a < y2; ++a) {
                for (int b = x1; b < x2; ++b) map[b][a] = 1;
            }
        }

        List<Integer> ll = new ArrayList<>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (map[j][i] == 0 && !vst[j][i]) {
                    ll.add(dfs(i, j));
                }
            }
        }
        System.out.println(ll.size());
        Collections.sort(ll);
        for (int val : ll) {
            System.out.print(val + " ");
        }
    }


    public static int dfs(int x, int y) {
        int area = 1;

        vst[y][x] = true;

        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] == 0 && !vst[ny][nx]) {
                area += dfs(nx, ny);
            }
        }
        return area;
    }
}
