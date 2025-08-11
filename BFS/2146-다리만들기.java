import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int[][] map;
	static int[][] island;
	static boolean[][][] visited;
	static int[] dx = {1, -1,  0, 0};
	static int[] dy = {0,  0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		island = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int label = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && island[i][j] == 0) {
					label++;
					dfs(i, j, label);
				}
			}
		}

		Queue<int[]> q = new ArrayDeque<>();
		visited = new boolean[label+1][N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int lbl = island[i][j];
				if (lbl > 0) {
					for(int d = 0; d < 4; d++) {
						int ni = i + dx[d];
						int nj = j + dy[d];
						if (ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] == 0) {
							visited[lbl][i][j] = true;
							q.offer(new int[]{i, j, lbl, 0});
							break;
						}
					}
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x    = cur[0];
			int y    = cur[1];
			int orig = cur[2];
			int dist = cur[3];

			if (dist >= ans) continue;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

				if (!visited[orig][nx][ny]) {
					if (map[nx][ny] == 0) {
						visited[orig][nx][ny] = true;
						q.offer(new int[]{nx, ny, orig, dist + 1});
					}
					else if (island[nx][ny] != orig) {
						ans = Math.min(ans, dist);
					}
				}
			}
		}

		System.out.println(ans);
	}

	static void dfs(int i, int j, int label) {
		island[i][j] = label;
		for(int d = 0; d < 4; d++) {
			int ni = i + dx[d];
			int nj = j + dy[d];
			if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
				if (map[ni][nj] == 1 && island[ni][nj] == 0) {
					dfs(ni, nj, label);
				}
			}
		}
	}
}