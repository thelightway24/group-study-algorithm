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

			int ans = bfs();
			bw.write(ans + "");
			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	static int bfs() {
		int count = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][m];

		queue.add(new int[]{0, 0});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();




		}

		return count;
	}
}