import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] area;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int maxSafeAreas = 1;
		for (int h = 1; h <= 100; h++) {
			boolean[][] visited = new boolean[N][N];
			int safeAreasCount = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && area[i][j] > h) {
						bfs(i, j, h, visited);
						safeAreasCount++;
					}
				}
			}
			if (safeAreasCount > maxSafeAreas) {
				maxSafeAreas = safeAreasCount;
			}
		}
		System.out.println(maxSafeAreas);
	}

	static void bfs(int y, int x, int h, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {y, x});
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cy = cur[0];
			int cx = cur[1];

			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];

				if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
					if (!visited[ny][nx] && area[ny][nx] > h) {
						visited[ny][nx] = true;
						q.offer(new int[] {ny, nx});
					}
				}
			}
		}
	}
}
