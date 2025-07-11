import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] visited;
	static boolean[][] filled;
	static int m, n;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static List<Integer> ans = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			filled = new boolean[m][n];

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				fill(x1, y1, x2, y2);
			}

			visited = new boolean[m][n];
			for (int y = 0; y < m; y++) {
				for (int x = 0; x < n; x++) {
					if (!visited[y][x] && !filled[y][x]) {
						int area = dfs(y, x);
						ans.add(area);
					}
				}
			}

			Collections.sort(ans);
			bw.write(ans.size() + "\n");
			for (int i : ans) {
				bw.write(i + " ");
			}

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void fill(int x1, int y1, int x2, int y2) {
		for (int y = y1; y < y2; y++) {
			for (int x = x1; x < x2; x++) {
				filled[y][x] = true;
			}
		}
	}

	static int dfs(int y, int x) {
		visited[y][x] = true;
		int area = 1;
		for (int direction = 0; direction < 4; direction++) {
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
			if (filled[ny][nx]) continue;
			if (visited[ny][nx]) continue;
			area += dfs(ny, nx);
		}
		return area;
	}

}