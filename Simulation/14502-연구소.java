import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] map = new int[9][9];
    static boolean[][] vst = new boolean[9][9];
    static List<int[]> virus = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; ++i) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; ++j) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        recursion(0);
        System.out.println(ans);
    }

    public static void recursion(int wallCnt) {
        if (wallCnt == 3) {
            ans = Math.max(ans, bfs());
            vst = new boolean[9][9];
            return ;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    recursion(wallCnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }



    public static int bfs() {
        int[][] newMap = new int[9][9];
        for (int i = 0; i < n; ++i)  newMap[i] = map[i].clone();

        Queue<int[]> q = new ArrayDeque<>();
        for (int[] v : virus) {
            q.add(v);
            vst[v[0]][v[1]] = true;
        }

        while (!q.isEmpty()) {
            int[] cur = q.remove();
            for (int i = 0; i < 4; ++i) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0 && !vst[nx][ny]) {
                    vst[nx][ny] = true;
                    newMap[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (newMap[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}