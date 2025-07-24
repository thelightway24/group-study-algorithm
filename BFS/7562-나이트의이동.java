import java.io.*;
import java.util.*;

public class Main {

    static int t, n, startX, startY, targetX, targetY;
    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        String[] input;
        for (int i = 0; i < t; ++i) {
            n = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            startX = Integer.parseInt(input[0]);
            startY = Integer.parseInt(input[1]);
            input = br.readLine().split(" ");
            targetX = Integer.parseInt(input[0]);
            targetY = Integer.parseInt(input[1]);
            solve(startX, startY, targetX, targetY);
        }
    }

    public static void solve(int sX, int sY, int tX, int tY) {
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{sX, sY});

        int[][] map = new int[n + 1][n + 1];
        map[sX][sY] = 1;
        while(!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 8; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0) {
                    map[nx][ny] = map[x][y] + 1;
                    q.addLast(new int[]{nx, ny});
                }
            }
        }
        System.out.println(map[tX][tY] - 1);
    }


}
