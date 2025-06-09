import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map = new int[101][101];
    static boolean[][] vst = new boolean[101][101];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int maxVal = 0;
        for (int i = 0; i < n; ++i) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; ++j) {
                map[i][j] = Integer.parseInt(input[j]);
                maxVal = Math.max(maxVal, map[i][j]);
            }
        }

        int ans = 0;
        for (int a = 0; a <= maxVal; ++a) {
            int tempAns = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (map[i][j] > a && !vst[i][j]) {
                        dfs(i, j, a);
                        tempAns++;
                    }
                }
            }
            ans = Math.max(ans, tempAns);
            vst = new boolean[101][101];
        }
        System.out.println(ans);
    }
    public static void dfs(int x, int y, int h) {
        if (vst[x][y]) return;
        vst[x][y] = true;

        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !vst[nx][ny] && map[nx][ny] > h) {
                dfs(nx, ny, h);
            }
        }
    }

}
