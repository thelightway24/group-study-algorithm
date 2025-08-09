import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int r, c, k;
		Node(int r, int c, int k) { this.r = r; this.c = c; this.k = k; }
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 나이트(말) 이동 8방
		int[] kr = {-2,-2,-1,-1,1,1,2,2};
		int[] kc = {-1,1,-2,2,-2,2,-1,1};
		// 인접 4방 (상하좌우)
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};

		// dist[k][r][c] = 해당 상태에 도달하는 최소 동작수, -1이면 미방문
		int[][][] dist = new int[K+1][H][W];
		for (int k = 0; k <= K; k++) {
			for (int i = 0; i < H; i++) Arrays.fill(dist[k][i], -1);
		}

		ArrayDeque<Node> q = new ArrayDeque<>();
		dist[0][0][0] = 0;
		q.offer(new Node(0, 0, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();
			int r = cur.r, c = cur.c, used = cur.k;
			int curDist = dist[used][r][c];

			// 인접 4방 이동
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d], nc = c + dc[d];
				if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
				if (map[nr][nc] == 1) continue; // 장애물
				if (dist[used][nr][nc] == -1) {
					dist[used][nr][nc] = curDist + 1;
					q.offer(new Node(nr, nc, used));
				}
			}

			// 말(나이트) 이동 — 사용 한도 남아있을 때만
			if (used < K) {
				for (int d = 0; d < 8; d++) {
					int nr = r + kr[d], nc = c + kc[d];
					if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
					if (map[nr][nc] == 1) continue;
					if (dist[used + 1][nr][nc] == -1) {
						dist[used + 1][nr][nc] = curDist + 1;
						q.offer(new Node(nr, nc, used + 1));
					}
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int k = 0; k <= K; k++) {
			int d = dist[k][H-1][W-1];
			if (d != -1 && d < ans) ans = d;
		}

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
}
