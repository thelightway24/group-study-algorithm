import java.io.*;
import java.util.*;

public class Main {

    static int k, w, h;
    static int[][] map = new int[201][201];
    static int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2, 1, -1, 0, 0};
    static int[] dy = {2, 2, 1, -1, -2, -2, -1, 1, 0, 0, 1, -1};
    static int[] da = {1, -1, 0, 0};
    static int[] db = {0, 0, -1, 1};
    static int[][][] visited = new int[201][201][31];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        w = Integer.parseInt(input[0]);
        h = Integer.parseInt(input[1]);
        for (int i = 0; i < h; ++i) {
            input = br.readLine().split(" ");
            for (int j = 0; j < w; ++j) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        System.out.println(solve());
    }

    public static int solve() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0, k});

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            if (x == h - 1 && y == w - 1) return visited[x][y][cnt];
            if (cnt > 0) {
                for (int i = 0; i < 8; ++i) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == 0 && visited[nx][ny][cnt - 1] == 0) {
                        visited[nx][ny][cnt - 1] = visited[x][y][cnt] + 1;
                        dq.add(new int[]{nx, ny, cnt - 1});
                    }
                }
            }
            for (int i = 0; i < 4; ++i) {
                int nx = x + da[i];
                int ny = y + db[i];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == 0 && visited[nx][ny][cnt] == 0) {
                    visited[nx][ny][cnt] = visited[x][y][cnt] + 1;
                    dq.add(new int[]{nx, ny, cnt});
                }
            }
        }
        return -1;
    }
}