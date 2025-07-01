import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static char[][] map = new char[101][101];
    static char[][] map2 = new char[101][101];
    static boolean[][] vst = new boolean[101][101];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String input;
        for (int i = 0; i < n; ++i) {
            input = br.readLine();
            for (int j = 0; j < input.length(); ++j) {
                map[i][j] = input.charAt(j);
                map2[i][j] = (map[i][j] == 'G') ? 'R' : map[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        // 일반 사람
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!vst[i][j]) {
                    dfs(i, j);
                    ans++;
                }
            }
        }
        sb.append(ans).append(" ");
        ans = 0;
        vst = new boolean[101][101];
        // 적록색약 사람
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!vst[i][j]) {
                    dfs2(i, j);
                    ans++;
                }
            }
        }
        sb.append(ans);
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        if (vst[x][y]) return;
        vst[x][y] = true;

        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >=0 && ny < n && !vst[nx][ny] && map[nx][ny] == map[x][y]) {
                dfs(nx,ny);
            }
        }
    }

    public static void dfs2(int x, int y) {
        if (vst[x][y]) return;
        vst[x][y] = true;

        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >=0 && ny < n && !vst[nx][ny] && map2[nx][ny] == map2[x][y]) {
                dfs2(nx,ny);
            }
        }
    }
}
