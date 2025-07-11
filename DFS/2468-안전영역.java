import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0}; // ↓ ↑ → ←
	static int[] dy = {0, 0, 1, -1}; // ↓ ↑ → ←  이걸 모르는데 어케 맨땅 dfs로 푸냐는거임~

	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			// 2 <= n <= 100
			n = Integer.parseInt(br.readLine());
			graph = new int[n][n];
			int highest = 0;

			for (int x = 0; x < n; x++) { // graph에 좌표별 높이 저장
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int y = 0; y < n; y++) {
					int height = Integer.parseInt(st.nextToken());
					graph[x][y] = height;
					highest = Math.max(highest, height);
				}
			}
			//       j
			// ____________
			//  | 6 8 2 6 2
			//  | 3 2 3 4 6
			// i| 6 7 3 3 2
			//  | 7 2 5 3 6
			//  | 8 9 5 2 7

			int ans = 1; // 최소 1

			for (int h = 1; h < highest; h++) { // 가능한 모든 수위에 대해 체크
				visited = new boolean[n][n];
				int count = 0;

				for (int x = 0; x < n; x++) { // x,y 모든 좌표에 대해 이중반복문을 돌린다. dfs는 상하좌우 같은 '안전한공간'으로 묶이는거 확인을 위해 사용
					for (int y = 0; y < n; y++) {
						// 잠기지 않았고 방문 안 한 좌표면 새로운 안전한 영역
						if (!visited[x][y] && graph[x][y] > h) {
							dfs(x, y, h);
							count++; // 안전한 영역 카운트
						}
					}
				}
				ans = Math.max(ans, count);
			}


			bw.write(ans + "");

			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	static void dfs(int x, int y, int water) {
		visited[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d]; // x, y = 좌표값, dx[d]와 dx[d]를 더하는 것을 4번 반복. 상하좌우 4 방향을 한번씩 보는거임.
			if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue; // 전체 범위 밖으로 이동할 시 스킵
			if (visited[nx][ny]) continue; // 이미 방문한 좌표일때 스킵
			if (graph[nx][ny] <= water) continue; // 잠긴 좌표일 때 스킵
			dfs(nx, ny, water); // 상하좌우에 같은 '안전한영역'으로 묶일 좌표가 없으면 아예 스킵됨.
		}
	}
}