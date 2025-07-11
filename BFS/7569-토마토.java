import java.io.*;
import java.util.*;

public class Main {

    public static class Index {
        int x;
        int y;
        int z;

        Index(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int n, m, h, ans;
    static int[][][] map = new int[101][101][101];
    static Deque<Index> q = new ArrayDeque<>();
    static int[] dx = {0, 0, -1, 1, 0 ,0};
    static int[] dy = {0 ,0, 0, 0, -1, 1};
    static int[] dz = {1, -1, 0, 0, 0, 0};


    public static void main(String[] args) throws Exception {

        init();
        bfs();
        solve();

    }

    public static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        h = Integer.parseInt(input[2]);

        for (int i = 0; i < h; ++i) {
            for (int j = 0 ; j < m; ++j) {
                input = br.readLine().split(" ");
                for (int k = 0; k < n; ++k) {
                    map[i][j][k] = Integer.parseInt(input[k]);
                    if (map[i][j][k] == 1) q.addLast(new Index(i, j, k));
                }
            }
        }
    }

    public static void solve() {

        for (int i = 0; i < h; ++i) {
            for (int j = 0 ; j < m; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    } else {
                        ans = Math.max(ans, map[i][j][k]);
                    }
                }
            }
        }
        System.out.println(ans - 1);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Index cur = q.pollFirst();
            int x = cur.x;
            int y = cur.y;
            int z = cur.z;
            for (int i = 0; i < 6; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if (nx >= 0 && nx < h && ny >= 0 && ny < m && nz >= 0 && nz < n && map[nx][ny][nz] == 0) {
                    map[nx][ny][nz] = map[x][y][z] + 1;
                    q.addLast(new Index(nx, ny, nz));
                }
            }
        }
    }

}
