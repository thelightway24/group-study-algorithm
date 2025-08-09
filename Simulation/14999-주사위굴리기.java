import java.io.*;
import java.util.*;

public class Main {
	static int N, M, x, y, K;
	static int[][] map;
	static int[] dice = new int[7];
	// 동서북남
	// 문제가 1,2,3,4 순서대로 동서북남
	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < K; i++) {
			int cmd = Integer.parseInt(st.nextToken());
			int nx = x + dx[cmd];
			int ny = y + dy[cmd];
			
			//범위 밖으로 가는 명령은 무시
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				continue;
			}

			roll(cmd);
			x = nx;
			y = ny;

			if (map[x][y] == 0) {
				map[x][y] = dice[6];
			} else {
				// 바닥 = 지도 위 값
				dice[6] = map[x][y];
				map[x][y] = 0;
			}
			sb.append(dice[1]).append("\n");
		}
		System.out.print(sb);
	}

	static void roll(int dir) {
		int[] tmp = dice.clone();
		// 1 동쪽, 2 서쪽, 3 북쪽, 4 남쪽
		if (dir == 1) {
			dice[1] = tmp[4];
			dice[3] = tmp[1];
			dice[6] = tmp[3];
			dice[4] = tmp[6];
		} else if (dir == 2) {
			dice[1] = tmp[3];
			dice[4] = tmp[1];
			dice[6] = tmp[4];
			dice[3] = tmp[6];
		} else if (dir == 3) {
			dice[1] = tmp[5];
			dice[2] = tmp[1];
			dice[6] = tmp[2];
			dice[5] = tmp[6];
		} else if (dir == 4) {
			dice[1] = tmp[2];
			dice[5] = tmp[1];
			dice[6] = tmp[5];
			dice[2] = tmp[6];
		}
	}
}
