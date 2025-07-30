import java.io.*;
import java.util.*;

public class Main {
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
				String s = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}

			int ans = bfs();
			bw.write(ans+"");
			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}


	static int bfs(){
		Queue<int[]> queue = new ArrayDeque<>();
		// 방문 배열, 마지막은 벽뚫여부
		boolean[][][] visited = new boolean[n][m][2];

		// [0] = x, [1] = y, [2] = 벽뚫 여부, [3] = 카운트
		queue.add(new int[]{0, 0, 0, 1});
		visited[0][0][0] = true;

		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			int crush = cur[2]; // cr = 0(벽 깨기 가능), 1 = (이미 깸)
			int count = cur[3];

			// 목표 위치 도착했는지 확인
			if (x == n - 1 && y == m - 1) return count;

			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

				if (map[nx][ny] == 1 && crush == 0 && !visited[nx][ny][1]){
					visited[nx][ny][1] = true;
					queue.add(new int[]{nx, ny, 1, count + 1});
				}

				if (map[nx][ny] == 0 && !visited[nx][ny][crush]){
					visited[nx][ny][crush] = true;
					queue.add(new int[]{nx, ny, crush, count + 1});
				}

			}
		}
		return -1;
	}
}
