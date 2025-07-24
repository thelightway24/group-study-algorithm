import java.io.*;
import java.util.*;

public class Main {

    static int t, h, w;
    static Character[][] map = new Character[1001][1001];
    static int[][] vst;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Deque<int[]> sang;
    static Deque<int[]> fire;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        String[] input;
        for (int i = 0; i < t; ++i) {
            input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);
            map = new Character[1001][1001];
            vst = new int[1001][1001];
            sang = new ArrayDeque<>();
            fire = new ArrayDeque<>();
            for (int j = 0; j < h; ++j) {
                String line = br.readLine();
                for (int k = 0; k < w; ++k) {
                    map[j][k] = line.charAt(k);
                    if (map[j][k] == '@') {
                        sang.add(new int[]{j, k});
                        vst[j][k] = 1;
                    }
                    if (map[j][k] == '*') fire.add(new int[]{j, k});
                }
            }
            fireBfs();
            int result = sangBfs();
            System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        }
    }


    public static void fireBfs() {
        int size = fire.size();
        for (int i = 0; i < size; ++i) {
            int[] pos = fire.poll();
            int x = pos[0];
            int y = pos[1];
            for (int j = 0; j < 4; ++j)  {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] != '#' && map[nx][ny] != '*') {
                    map[nx][ny] = '*';
                    fire.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static int sangBfs() {
        while (!sang.isEmpty()) {
            int size = sang.size();
            for (int i = 0; i < size; ++i) {
                int[] pos = sang.poll();
                int x = pos[0];
                int y = pos[1];
                for (int j = 0; j < 4; ++j) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                        if (map[nx][ny] == '.' && vst[nx][ny] == 0) {
                            vst[nx][ny] = vst[x][y] + 1;
                            sang.add(new int[]{nx, ny});
                        }
                    } else {
                        return vst[x][y];
                    }
                }
            }
            fireBfs();
        }
        return -1;
    }
}
