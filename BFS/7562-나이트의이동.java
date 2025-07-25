import java.io.*;
import java.util.*;

public class Main {

	static int l, x1, y1, x2, y2;
	static boolean[][] visited;
	static Queue<int[]> queue;
	static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1}; // 나이트의 8 가지 방향
	static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

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
				l = Integer.parseInt(br.readLine()); // 체스판 그리드의 길이
				visited = new boolean[l][l];
				queue = new ArrayDeque<>();

				StringTokenizer st1 = new StringTokenizer(br.readLine());
				x1 = Integer.parseInt(st1.nextToken());
				y1 = Integer.parseInt(st1.nextToken());
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				x2 = Integer.parseInt(st2.nextToken());
				y2 = Integer.parseInt(st2.nextToken());

				bw.write(bfs() + "\n");
			}

			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	static int bfs() {
		if (x1 == x2 && y1 == y2) return 0; // 바로 리턴

		queue.add(new int[] {x1, y1, 0}); // 시작 xy좌표와 이동 카운트
		visited[x1][y1] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.remove();
			int curX = cur[0];
			int curY = cur[1];
			int count = cur[2];

			// 8방향
			for (int dir = 0; dir < 8; dir++) {
				int nx = curX + dx[dir];
				int ny = curY + dy[dir];

				if (nx < 0 || nx >= l || ny < 0 || ny >= l) continue; // 체스판 범위 밖이면 스킵
				if (visited[nx][ny] == true) continue; // 이미 방문한 칸이면 스킵

				if (nx == x2 && ny == y2) return (count + 1); // 목표칸이면 리턴

				visited[nx][ny] = true;
				queue.add(new int[] {nx, ny, count+1});
			}
		}
		return -1; // 세이프티
	}
}