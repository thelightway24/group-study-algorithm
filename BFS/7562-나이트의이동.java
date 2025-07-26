import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static final int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	static final int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int caseCount = Integer.parseInt(br.readLine());
		while (caseCount-- > 0) {
			int line = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int tx = Integer.parseInt(st.nextToken());
			int ty = Integer.parseInt(st.nextToken());

			sb.append(bfs(line, sx, sy, tx, ty)).append('\n');
		}

		System.out.print(sb);
	}

	static int bfs(int l, int sx, int sy, int tx, int ty) {
		if (sx == tx && sy == ty)
			return 0;

		boolean[][] visited = new boolean[l][l];
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sx, sy, 0});
		visited[sx][sy] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0], y = cur[1], d = cur[2];

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < l && 0 <= ny && ny < l && !visited[nx][ny]) {
					if (nx == tx && ny == ty)
						return d + 1;
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny, d + 1});
				}
			}
		}
		return -1;
	}
}
