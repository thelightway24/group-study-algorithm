import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int M, N, K; // 세로(M), 가로(N), 직사각형 개수(K)
	public static boolean[][] visited; // 격자판 방문 및 막힘 체크
	public static int[] dx = {0, 0, -1, 1}; // 좌우 이동 (x 방향)
	public static int[] dy = {-1, 1, 0, 0}; // 상하 이동 (y 방향)

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[M][N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			// 영역 true로 표시
			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					visited[y][x] = true;
				}
			}
		}

		List<Integer> areas = new ArrayList<>();

		for (int i = 0; i < M; i++) { // 세로
			for (int j = 0; j < N; j++) { // 가로
				if (!visited[i][j]) {
					areas.add(bfs(j, i));
				}
			}
		}

		Collections.sort(areas);
		System.out.println(areas.size());

		for (int area : areas) {
			System.out.print(area + " ");
		}
	}

	private static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[y][x] = true; // 시작점 방문 처리
		int count = 1; // bfs가 호출된 순간 1개는 확정

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];

			// 상하좌우 4방향 탐색
			for (int d = 0; d < 4; d++) {
				int nx = nowX + dx[d];
				int ny = nowY + dy[d];

				// 방문체크 및 큐 추가
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (!visited[ny][nx]) {
						visited[ny][nx] = true;
						q.offer(new int[] {nx, ny});
						count++;
					}
				}
			}
		}
		return count;
	}
}

