import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] map = new int[51][51];
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; ++i) {
            input = br.readLine().split(" ");
            for (int j = 0; j < input.length; ++j) map[i][j] = Integer.parseInt(input[j]);
        }

        int cloudX1 = n - 1, cloudY1 = 0;
        int cloudX2 = n - 2, cloudY2 = 0;
        int cloudX3 = n - 1, cloudY3 = 1;
        int cloudX4 = n - 2, cloudY4 = 1;
        List<Pair> clouds = new ArrayList<>();
        clouds.add(new Pair(cloudX1, cloudY1));
        clouds.add(new Pair(cloudX2, cloudY2));
        clouds.add(new Pair(cloudX3, cloudY3));
        clouds.add(new Pair(cloudX4, cloudY4));

        for (int i = 0; i < m; ++i) {
            input = br.readLine().split(" ");
            int d = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);
            clouds = move(d, s, clouds);
            rain(clouds);
            duplicate(clouds);
            clouds = makeCloud(clouds);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ans += map[i][j];
            }
        }
        System.out.println(ans);
    }

    public static List<Pair> move(int d, int s, List<Pair> clouds) {
        List<Pair> newClouds = new ArrayList<>();
        for (Pair cloud : clouds) {
            int newX = (cloud.x + dx[d - 1] * (s % n) + n) % n;
            int newY = (cloud.y + dy[d - 1] * (s % n) + n) % n;
            newClouds.add(new Pair(newX, newY));
        }
        return newClouds;
    }

    public static void rain(List<Pair> clouds) {
        for (Pair cloud : clouds) {map[cloud.x][cloud.y] += 1;}
    }

    public static void duplicate(List<Pair> clouds) {
        // 대각선 -> 1, 3, 5, 7

        for (Pair cloud : clouds) {
            int cnt = 0;
            int x = cloud.x;
            int y = cloud.y;
            for (int i = 1; i < 8; i += 2) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] != 0) cnt++;
            }
            map[x][y] += cnt;
        }
    }

    public static List<Pair> makeCloud(List<Pair> clouds) {
        List<Pair> newclouds = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (map[i][j] >= 2 && !clouds.contains(new Pair(i, j))) {
                    map[i][j] -= 2;
                    newclouds.add(new Pair(i, j));
                }
            }
        }
        return newclouds;
    }
}
