import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static int n,m,k;
    static int[][] map = new int[51][51];
    static boolean[][] vst = new boolean[51][51];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            k = Integer.parseInt(input[2]);
            for (int j = 0; j < k; ++j) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                map[x][y] = 1;
            }
            int ans = 0;
            for (int a = 0; a < n; ++a) {
                for (int b = 0; b < m; ++b) {
                    if (map[a][b] == 1 && !vst[a][b]) {
                        dfs(a, b);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
            map = new int[51][51];
            vst = new boolean[51][51];
        }
    }

    public static void dfs(int x, int y) {
        if (vst[x][y]) return;

        vst[x][y] = true;
        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && !vst[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
