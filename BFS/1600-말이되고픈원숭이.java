import java.io.*;
import java.util.*;

public class Main {
	// 0 <= k <= 30, 1 <= w, h <= 200
	static int k, w, h;
	static int[] knightDx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] knightDy = {1, -1, 2, -2, 2, -2, 1, -1};
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] map;
	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			k = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];

			for (int i = 0; i < h; i++) { //지도 그리기
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
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
		if(w == 1 && h == 1) return 0;

		boolean[][][] visited = new boolean[h][w][k+1];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{0, 0, k, 0}); // x, y, 말처럼 이동하는 남은 횟수, 움직인 횟수
		visited[0][0][k] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];
			int ck = cur[2];
			int count = cur[3];

			if (cx == w - 1 && cy == h - 1) return count; // 답안 제출

			if (ck > 0){
				for (int i = 0; i < 8; i++) {
					int nx = cx + knightDx[i];
					int ny = cy + knightDy[i];
					int nk = ck - 1;
					int ncount = count + 1;

					if (nx < 0 || nx >= w || ny < 0 || ny >= h) continue;
					if (map[ny][nx] == 1) continue;
					if (visited[ny][nx][nk]) continue;

					queue.add(new int[]{nx, ny, nk, ncount});
					visited[ny][nx][nk] = true;
				}
			}

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				int ncount = count + 1;

				if (nx < 0 || nx >= w || ny < 0 || ny >= h) continue;
				if (map[ny][nx] == 1) continue;
				if (visited[ny][nx][ck]) continue;

				queue.add(new int[]{nx, ny, ck, ncount});
				visited[ny][nx][ck] = true;
			}
		}

		return -1;
	}
}

//방문 배열을 어떻게 해야할까.. 방문배열에 k를 추가해 선언해 해결