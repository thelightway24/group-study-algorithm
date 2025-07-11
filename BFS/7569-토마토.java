import java.io.*;
import java.util.*;

public class Main {
	// 1. 최초 상태를 담아서 보관
	// 2. 예외 처리 = 0일이 걸리는경우, 결국 다 안익는 경우
	// 3. bfs로 상하좌우앞뒤로 전파 시키며 얼마나 걸리는지 확인

	static int m, n, h;
	static int[][][] tomatoes;
	static int[] dz = {1, -1, 0, 0, 0, 0}; // 위 아래
	static int[] dy = {0, 0, 1, -1, 0, 0}; // 행 (y) 이동 ↓ ↑
	static int[] dx = {0, 0, 0, 0, 1, -1}; // 열 (x) 이동 → ←
	static Queue<int[]> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			// 2 <= m, n <= 100, 1 <= h <= 100
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken()); // 열 개수 / x좌표 / 가로칸의 수
			n = Integer.parseInt(st.nextToken()); // 행 개수 / y좌표 / 세로칸의 수
			h = Integer.parseInt(st.nextToken()); // 높이 z좌표
			tomatoes = new int[h][n][m]; // z/y/x 로 저장.. 이게 헷갈리게 만든 원흉이다. 걍 얌전히 mnh할걸

			// 1. 최초 상태 저장
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < n; j++) {
					st = new StringTokenizer(br.readLine());
					for (int k = 0; k < m; k++) {
						int tomato = Integer.parseInt(st.nextToken());
						tomatoes[i][j][k] = tomato;
						if (tomato == 1) queue.add(new int[] {i, j, k}); // 익은 토마토의 좌표를 정수 배열로 큐에 저장 // hnm = zyx
					}
				}
			}

			int ans = bfs();

			bw.write(ans + "");

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static int bfs() {
		int ans = -1; // 원래는 플래그를 세워서 예외처리를 했는데 (allPreRiped 등) 복잡해지고 모든 예외 사항처리가 안됐다. -1로 시작하면 됨.

		while (!queue.isEmpty()) {
			int size = queue.size();
			ans++;
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll(); // 큐에서 다음 좌표(익은 토마토가 있는) 가져옴
				int z = cur[0]; // h
				int y = cur[1]; // n
				int x = cur[2]; // m

				for (int dir = 0; dir < 6; dir++) { // 가져온 좌표로 상하좌우앞뒤를 탐색하고, 익혀버릴 수 있는 토마토가 있으면 익히고 큐에 저장.
					int nz = z + dz[dir];
					int ny = y + dy[dir];
					int nx = x + dx[dir];

					if (nz < 0 || nz >= h || nx < 0 || nx >= m || ny < 0 || ny >= n) continue; // 박스 범위내를 나가면 스킵
					if (tomatoes[nz][ny][nx] != 0) continue; // 해당 좌표가 이미 익었거나 비었으면 스킵

					tomatoes[nz][ny][nx] = 1; // 새롭게 익은 토마토 다시 큐에 추가
					queue.add(new int[] {nz, ny, nx});
				}
			}
		}

		for (int[][] box : tomatoes) { //익힐 수 있는 모든 케이스 적용 했는데 안익은 토마토가 있으면 -1 출력
			for (int[] row : box) {
				for (int tomato : row) {
					if (tomato == 0) {
						return -1;
					}
				}
			}
		}
		return ans;
	}
}

//진짜 얌전히 xyz로 담기만 했어도 해결 될 문제. 순서를 xyz, zyx, zxy를 섞어쓰니까 혼란에 시간을 너무 많이 빼았겼다.