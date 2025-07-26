import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] water;
	static boolean[][] cloud;

	static final int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static final int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

	// 대각선 4방향 (물복사버그)
	static final int[] diagX = {-1, -1, 1, 1};
	static final int[] diagY = {-1, 1, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		water = new int[N][N];

		// 초기 물
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				water[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 초기 구름
		cloud = new boolean[N][N];
		cloud[N - 1][0] = true;
		cloud[N - 1][1] = true;
		cloud[N - 2][0] = true;
		cloud[N - 2][1] = true;

		// M번 이동
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int steps = Integer.parseInt(st.nextToken());

			moveCloud(direction, steps);
			rain();
			waterCopyBug();
			createNewCloud();
		}

		// 최종 물의 양 합 출력
		System.out.println(getTotalWater());
	}

	/**
	 * 1. 구름 이동
	 */
	static void moveCloud(int direction, int steps) {
		boolean[][] newCloud = new boolean[N][N];
		int move = steps % N; // N의 배수번 이동하면 제자리

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (cloud[r][c]) {
					int nr = (r + dx[direction] * move) % N;
					int nc = (c + dy[direction] * move) % N;

					// 양수 보정
					if (nr < 0)
						nr += N;
					if (nc < 0)
						nc += N;

					newCloud[nr][nc] = true;
				}
			}
		}
		cloud = newCloud;
	}

	/**
	 * 2. 비 내림 (구름이 있는 칸의 물 +1)
	 */
	static void rain() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (cloud[r][c]) {
					water[r][c]++;
				}
			}
		}
	}

	/**
	 * 3. 물복사버그
	 * - 구름이 있던 칸에서 대각선 4칸 중 물이 있는 칸 개수만큼 물 증가
	 */
	static void waterCopyBug() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (cloud[r][c]) {
					int count = 0;

					for (int k = 0; k < 4; k++) {
						int nr = r + diagX[k];
						int nc = c + diagY[k];

						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							if (water[nr][nc] > 0) {
								count++;
							}
						}
					}

					water[r][c] += count;
				}
			}
		}
	}

	/**
	 * 4. 새로운 구름 생성
	 * - 물이 2 이상인 칸에 새 구름 생성하고 물 2 줄임
	 * - 직전에 구름이 있던 칸은 제외
	 */
	static void createNewCloud() {
		boolean[][] newCloud = new boolean[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!cloud[r][c] && water[r][c] >= 2) {
					water[r][c] -= 2;
					newCloud[r][c] = true;
				}
			}
		}

		cloud = newCloud;
	}

	/**
	 * 현재 전체 물 양 합산
	 */
	static int getTotalWater() {
		int sum = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				sum += water[r][c];
			}
		}
		return sum;
	}
}
