import java.io.*;
import java.util.*;

//주사위 평면도는 아래와 같으며, 각각의 인덱스를 적용
//평상시
//dice[0] = 2 / dice[1] = 4 / dice[2] = 1
//dice[3] = 3 / dice[4] = 5 / dice[5] = 6
//동쪽으로 굴렸을때
//dice[0] = 2 / dice[1] = 1 / dice[2] = 3
//dice[3] = 6 / dice[4] = 5 / dice[5] = 4
//서쪽으로 굴렸을때
//dice[0] = 2 / dice[1] = 6 / dice[2] = 4
//dice[3] = 1 / dice[4] = 5 / dice[5] = 3
//남쪽으로 굴렸을 때
//dice[0] = 6 / dice[1] = 4 / dice[2] = 2
//dice[3] = 3 / dice[4] = 1 / dice[5] = 5
//북쪽으로 굴렸을 때
//dice[0] = 1 / dice[1] = 4 / dice[2] = 5
//dice[3] = 3 / dice[4] = 6 / dice[5] = 2
//    2
// 4  1(윗면) 3
//    5
//    6(아랫면)


public class Main {

    static int n, m, x, y, k;
    static int[][] map = new int[21][21];
    static int[] cmd = new int[1001];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] dice = new int[6];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        x = Integer.parseInt(input[2]);
        y = Integer.parseInt(input[3]);
        k = Integer.parseInt(input[4]);
        for (int i = 0; i < n; ++i) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; ++j) map[i][j] = Integer.parseInt(input[j]);
        }
        input = br.readLine().split(" ");
        for (int i = 0; i < k; ++i) {
            cmd[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i < k; ++i) {
            int nx = x + dx[cmd[i] - 1];
            int ny = y + dy[cmd[i] - 1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 범위 벗어남
            solve(cmd[i]);
            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[5];
            } else {
                dice[5] = map[nx][ny];
                map[nx][ny] = 0;
            }
            x = nx;
            y = ny;
            System.out.println(dice[2]); // 윗면 출력
        }
    }

    public static void solve(int dir) {
        if (dir == 1) {
            int temp = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[3];
            dice[3] = temp;
        } else if (dir == 2) {
            int temp = dice[2];
            dice[2] = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[1];
            dice[1] = temp;
        } else if (dir == 3) {
            int temp = dice[2];
            dice[2] = dice[4];
            dice[4] = dice[5];
            dice[5] = dice[0];
            dice[0] = temp;
        } else {
            int temp = dice[2];
            dice[2] = dice[0];
            dice[0] = dice[5];
            dice[5] = dice[4];
            dice[4] = temp;
        }
    }

}