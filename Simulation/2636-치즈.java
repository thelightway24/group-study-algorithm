import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] map = new int[101][101];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] vst;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; ++i) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; ++j) map[i][j] = Integer.parseInt(input[j]);
        }
        bfs();
    }

    public static void bfs() {
        int cnt = 0;
        int ans = 0;
        while (!check()) {
            cnt++;
            List<int[]> outside = outsideCheck();
            ans = outside.size();

            for (int[] pos : outside) {
                int x = pos[0];
                int y = pos[1];
                map[x][y] = 0;
            }


        }
        System.out.println(cnt);
        System.out.println(ans);
    }

    public static List<int[]> outsideCheck() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        vst = new boolean[101][101];
        vst[0][0] = true;
        List<int[]> isOutside = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vst[nx][ny]) {
                    if (map[nx][ny] == 1) {
                        isOutside.add(new int[]{nx, ny});
                        vst[nx][ny] = true;
                    }
                    else {
                        vst[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return isOutside;
    }

    public static boolean check() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (map[i][j] == 1) return false;
            }
        }
        return true;
    }
}