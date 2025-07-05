import java.io.*;
import java.util.*;

public class Main {

    static int n, ans;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] finalMap;
    static Map<Integer, int[]> likeMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] input;
        finalMap = new int[n][n];

        for (int i = 0; i < Math.pow(n, 2); ++i) {
            input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            int[] arr = new int[4];

            for (int j = 1; j < input.length; ++j) {
                arr[j - 1] = Integer.parseInt(input[j]);
            }
            likeMap.put(num, arr);
            seat(num);
        }
        printAns();
    }

    public static void printAns() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int num = finalMap[i][j];
                int like = 0;
                for (int k = 0; k < 4; ++k) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && likeCheck(num, finalMap[nx][ny])) {
                        like++;
                    }
                }
                if (like == 0) ans += 0;
                else ans += Math.pow(10, like - 1);
            }

        }
        System.out.println(ans);
    }

    public static boolean nearCheck(int x, int y, int r, int c) {
        return (Math.abs(x - r) + Math.abs(y - c) == 1);
    }

    public static boolean likeCheck(int num, int check) {
        if (num == 0 || check == 0) return false;
        List<Integer> likeList = new ArrayList<>();
        Arrays.stream(likeMap.get(num)).forEach(likeList::add);
        return likeList.contains(check);
    }

    public static void seat(int num) {

        int[][] tempMap = new int[n][n];
        List<int[]> maxSeats = new ArrayList<>();
        int maxVal = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < 4; ++k) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && nearCheck(i, j, nx, ny) && likeCheck(num, finalMap[nx][ny]) && finalMap[i][j] == 0) {
                        tempMap[i][j]++;
                        maxVal = Math.max(maxVal, tempMap[i][j]);
                    }
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (finalMap[i][j] == 0 && tempMap[i][j] == maxVal) {
                    maxSeats.add(new int[]{i, j});
                }
            }
        }

        if (maxSeats.isEmpty()) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (finalMap[i][j] == 0) {
                        maxSeats.add(new int[]{i, j});
                    }
                }
            }
        }

        int[] finalSeat = maxSeats.get(0);
        int maxNear = -1;

        for (int[] seat : maxSeats) {
            int r = seat[0];
            int c = seat[1];
            int curNear = 0;
            for (int k = 0; k < 4; k++) {
                int nr = r + dx[k];
                int nc = c + dy[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && finalMap[nr][nc] == 0) {
                    curNear++;
                }
            }
            if (curNear > maxNear) {
                maxNear = curNear;
                finalSeat = seat;
            }
        }
        finalMap[finalSeat[0]][finalSeat[1]] = num;
    }
}
