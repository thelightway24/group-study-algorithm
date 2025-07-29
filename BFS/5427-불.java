import java.io.*;
import java.util.*;

public class Main {
	static int w, h;
	static char[][] map;
	static int[][] fireTime, sangTime;
	static StringBuilder sb = new StringBuilder();
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static Queue<int[]> sangQueue;
	static Queue<int[]> fireQueue;

	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			int t = Integer.parseInt(br.readLine());

			for (int i = 0; i < t; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				w = Integer.parseInt(st.nextToken()); // 넓이
				h = Integer.parseInt(st.nextToken()); // 높이

				map = new char[h][w];
				fireTime = new int[h][w];
				sangTime = new int[h][w];
				fireQueue = new ArrayDeque<>();
				sangQueue = new ArrayDeque<>();

				for (int j = 0; j < h; j++) {
					String line = br.readLine();
					for (int k = 0; k < w; k++) {
						map[j][k] = line.charAt(k);
						fireTime[j][k] = -1;
						sangTime[j][k] = -1;
						if (map[j][k] == '*') {
							fireQueue.add(new int[]{j, k});
							fireTime[j][k] = 0;
						} else if (map[j][k] == '@') {
							sangQueue.add(new int[]{j, k});
							sangTime[j][k] = 0;
						}
					}
				}


				sb.append(bfs() + "\n");
			}

			bw.write(sb.toString());

			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	static String bfs(){

		// 불 먼저 퍼뜨리기
		while (!fireQueue.isEmpty()) {
			int[] cur = fireQueue.remove();
			int x = cur[0];
			int y = cur[1];

			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
				if (map[nx][ny] == '#' || fireTime[nx][ny] != -1) continue;

				fireTime[nx][ny] = fireTime[x][y] + 1;
				fireQueue.add(new int[]{nx, ny});
			}
		}

		// 상근이 이동
		while (!sangQueue.isEmpty()) {
			int[] cur = sangQueue.poll();
			int x = cur[0];
			int y = cur[1];

			// 탈출 조건 (가장자리 도달)
			if (x == 0 || x == h - 1 || y == 0 || y == w - 1) {
				return Integer.toString(sangTime[x][y] + 1);
			}

			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
				if (map[nx][ny] == '#' || sangTime[nx][ny] != -1) continue;

				// 불보다 먼저 도착할 수 있어야 함
				if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= sangTime[x][y] + 1) continue;

				sangTime[nx][ny] = sangTime[x][y] + 1;
				sangQueue.add(new int[]{nx, ny});
			}
		}

		return "IMPOSSIBLE";
	}
}