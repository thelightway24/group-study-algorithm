import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static char[][] picture;
	static boolean[][] visited;
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
			n = Integer.parseInt(br.readLine());
			picture = new char[n][n];

			for (int i = 0; i < n; i++) { // 그림 저장
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					picture[i][j] = s.charAt(j);
				}
			}

			int count1 = 0;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						dfs1(i, j);
						count1++;
					}
				}
			}

			int count2 = 0;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						dfs2(i, j);
						count2++;
					}
				}
			}

			bw.write(count1 + " " + count2);

			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	public static void dfs1(int i, int j) {
		visited[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
			if (visited[nx][ny]) continue;
			if (picture[nx][ny] != picture[i][j]) continue;
			dfs1(nx, ny);
		}
	}

	public static void dfs2(int i, int j) {
		visited[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
			if (visited[nx][ny]) continue;
			if (!(picture[i][j] == picture[nx][ny]
				|| (picture[i][j] == 'R' && picture[nx][ny] == 'G')
				|| (picture[i][j] == 'G' && picture[nx][ny] == 'R')
			)) continue;
			dfs2(nx, ny);
		}
	}

}