import java.io.*;
import java.util.*;

public class Main {
	// 3 <= n, m <= 300
	static int n, m;
	static int[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			map = new int[n][m];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}


			int year = 0;
			while (true) {
				int count = countComponent();

				if (count >= 2) {
					bw.write(year + "");
					break;
				}

				if (count == 0) {
					bw.write("0");
					break;
				}

				melt();
				year++;
			}

			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	static int countComponent() {
		boolean[][] visited = new boolean[n][m];
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] > 0) {
					bfs(i, j, visited);
					count++;
				}
			}
		}
		return count;
	}

	static void bfs(int x, int y, boolean[][] visited) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{x, y});
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];

			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if (visited[nx][ny]) continue;
				if (map[nx][ny] == 0) continue;
				visited[nx][ny] = true;
				queue.add(new int[]{nx, ny});
			}
		}
	}

	static void melt() {
		int[][] minus = new int[n][m];

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				if (map[x][y] > 0) {
					int sea = 0;
					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						if (map[nx][ny] == 0) sea++;
					}
					minus[x][y] = sea;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] -= minus[i][j];
				if (map[i][j] < 0) map[i][j] = 0;
			}
		}
	}
}