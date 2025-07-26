import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map;
	static int[][][] visit;
	static int[] dx = {0,  0, 1, -1};
	static int[] dy = {1, -1, 0,  0};
	static Queue<Pos> q;

	static class Pos {
		int x;
		int y;
		int itemUse;
		Pos(int ix, int iy, int itemStat){
			x = ix;
			y = iy;
			itemUse = itemStat;
		}
	}
	public static void main (String[] a) throws Exception {
		StringTokenizer sizeToken = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(sizeToken.nextToken());
		int M = Integer.parseInt(sizeToken.nextToken());

		visit = new int[N+1][M+1][2];
		// 0은 이동 가능 / 1은 벽
		map = new int[N+1][M+1];
		for(int i=1; i<N+1; i++){
			char[] input = br.readLine().toCharArray();
			for(int j=1; j<M+1; j++){
				map[i][j] = input[j-1] - '0';
			}
		}
		q = new LinkedList<Pos>();
		q.add(new Pos(1,1, 0));
		visit[1][1][0] = 1;
		while(!q.isEmpty()){

			int qs = q.size();


			for(int i=0; i<qs; i++){
				Pos p = q.poll();
				int dist = visit[p.x][p.y][p.itemUse];
				if (p.x == N && p.y == M) {
					System.out.println(dist);
					return;
				}

				for(int d=0; d<4; d++){
					int nextX = p.x + dx[d];
					int nextY = p.y + dy[d];
					if (nextX < 1 || nextX > N || nextY < 1 || nextY > M) continue;
					if(map[nextX][nextY] == 0 && visit[nextX][nextY][p.itemUse] == 0){
						visit[nextX][nextY][p.itemUse] = dist + 1;
						q.add(new Pos(nextX,nextY, p.itemUse));
					}
					if (map[nextX][nextY] == 1
						&& p.itemUse == 0 && visit[nextX][nextY][1] == 0) {
						Pos next = new Pos(nextX, nextY, 1);
						visit[nextX][nextY][1] = dist + 1;
						q.add(next);
					}
				}
			}

		}
		System.out.println(-1);
	}
}