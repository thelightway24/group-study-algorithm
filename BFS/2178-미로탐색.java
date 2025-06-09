import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] map = new int[101][101];
    static int[][] vst = new int[101][101];
    static boolean[][] vstDfs = new boolean[101][101];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Deque<int[]> dq = new ArrayDeque<>();
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; ++i) {
            String graph = br.readLine();
            for (int j = 0; j < graph.length(); ++j) {
                map[i][j] = graph.charAt(j) - 48;
            }
        }
        // vstDfs[0][0] = true;
        // dfs(0, 0, 1);
        // System.out.println(ans);
        bfs();
        System.out.println(vst[n - 1][m - 1]);
    }

    public static void bfs() {
        dq.add(new int[]{0,0});
        vst[0][0] = 1;

        while (!dq.isEmpty()) {
            int[] temp = dq.poll();
            int x = temp[0];
            int y = temp[1];
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 &&vst[nx][ny] == 0) {
                    vst[nx][ny] = vst[x][y] + 1;
                    dq.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void dfs(int x, int y, int cnt) {
        if (x == n - 1 && y == m - 1) {
            ans = Math.min(ans, cnt);
            return;
        }

        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vstDfs[nx][ny]) {
                if (map[nx][ny] == 0) continue;
                vstDfs[nx][ny] = true;
                dfs(nx, ny, cnt + 1);
                vstDfs[nx][ny] = false;
            }
        }

    }

}
