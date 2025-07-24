import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map = new int[1001][1001];
    static int[][][] vst = new int[1001][1001][2];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        for (int i = 0; i < n; ++i) {
            String line = br.readLine();
            for (int j = 0; j < m; ++j) {
                map[i][j] = line.charAt(j) - 48;
            }
        }
        vst[0][0][0] = 1;
        bfs();
    }

    public static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0, 0});

        while (!dq.isEmpty()) {
            int[] pos = dq.poll();
            int x = pos[0];
            int y = pos[1];
            int wall = pos[2];
            if (x == n - 1 && y == m - 1) break;
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 0 && vst[nx][ny][wall] == 0) {
                        vst[nx][ny][wall] = vst[x][y][wall] + 1;
                        dq.add(new int[]{nx, ny, wall});
                    } else if (map[nx][ny] == 1 && wall == 0 && vst[nx][ny][1] == 0) {
                        vst[nx][ny][1] = vst[x][y][0] + 1;
                        dq.add(new int[]{nx, ny, 1});
                    }
                }
            }
        }

        if (vst[n - 1][m - 1][0] == 0 && vst[n - 1][m - 1][1] == 0) {
            System.out.println(-1);
        } else if (vst[n - 1][m - 1][0] != 0) {
            System.out.println(vst[n - 1][m - 1][0]);
        } else if (vst[n - 1][m - 1][1] != 0) {
            System.out.println(vst[n - 1][m - 1][1]);
        }

    }

}