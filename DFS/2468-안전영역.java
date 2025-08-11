import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[][] visit;
	static int[][] value;
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};

	public static void main(String a[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N + 1][N + 1];
		value = new int[N + 1][N + 1];

		int maxLevel = 0;
		for (int i = 1; i <= N; i++) {
			StringTokenizer rowN = new StringTokenizer(br.readLine());
			int j = 1;
			while (rowN.hasMoreTokens()) {
				value[i][j] = Integer.parseInt(rowN.nextToken());
				if (value[i][j] > maxLevel) {
					maxLevel = value[i][j];
				}
				j++;
			}
		}

		int result = 0;

		for (int water = 0; water <= maxLevel; water++) {
			visit = new boolean[N + 1][N + 1];

			int safe = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!visit[i][j] && value[i][j] > water) {
						bfs(i, j, water);
						safe++;
					}
				}
			}

			if (safe > result) {
				result = safe;
			}
		}

		System.out.println(result);
	}

	public static void bfs(int startX, int startY, int level) throws IOException {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {startX, startY});
		visit[startX][startY] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0], y = cur[1];

			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];

				if (1 <= nextX && nextX <= N &&
					1 <= nextY && nextY <= N &&
					!visit[nextX][nextY] &&
					value[nextX][nextY] > level) {

					visit[nextX][nextY] = true;
					queue.add(new int[] {nextX, nextY});
				}
			}
		}
	}
}