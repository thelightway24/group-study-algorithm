import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] nDx = {-1, 1, 1, -1, 2, 2, -2, -2};
	static int[] nDy = {2, 2, -2, -2, 1, -1, 1, -1};
	static int[] mDx = {0,  0, 1, -1};
	static int[] mDy = {-1, 1, 0, 0};
	static int[][] map;
	static int maxX;
	static int maxY;
	static int skillLimit;
	static boolean[][][] visit;
	static Queue<Pos> q = new ArrayDeque<>();

	static class Pos {
		int x;
		int y;
		int skillUse;
		int cnt;
	}

	public static void main (String[] a) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 말로 이동할 수 있는 횟수
		skillLimit = Integer.parseInt(br.readLine());

		// 맵
		int[] mapSize = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		maxX = mapSize[0] + 1;
		maxY = mapSize[1] + 1;
		map = new int[maxX][maxY];

		for(int i=0; i<mapSize[1]; i++){
			int[] inputX = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			for(int j=0; j<mapSize[j]; j++){
				map[i+1][j+1] = inputX[j];
			}
		}

		Pos target = new Pos();
		target.x = maxX;
		target.y = maxY;

		Pos start = new Pos();
		start.x = 1;
		start.y = 1;

		visit = new boolean[mapSize[0] + 1][mapSize[1] + 1][skillLimit+1];
		
		System.out.println(bfs(start, target));
	}

	private static int bfs(Pos start, Pos target) {
		visit[1][1][0] = true;
		q.add(start);
		while(!q.isEmpty()){
			Pos cur = q.poll();
			if(cur.x == target.x && cur.y == target.y){
				return cur.cnt;
			}

			// 원숭이
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + mDx[i];
				int nextY = cur.y + mDy[i];
				int use = cur.skillUse;

				if (nextX > 0 && nextX < maxX && nextY > 0 && nextY < maxY
					&& map[nextY][nextX] == 0 && !visit[nextY][nextX][use]) {
					visit[nextY][nextX][use] = true;
					Pos nextPos = new Pos();
					nextPos.x = nextX;
					nextPos.y = nextY;
					nextPos.skillUse = use;
					nextPos.cnt = cur.cnt + 1;
					q.add(nextPos);
				}
			}
			
			//말
			if (cur.skillUse < skillLimit) {
				for (int i = 0; i < 8; i++) {
					int nextX = cur.x + nDx[i];
					int nextY = cur.y + nDy[i];
					int use = cur.skillUse + 1;

					if (nextX > 0 && nextX < maxX && nextY > 0 && nextY < maxY
						&& map[nextY][nextX] == 0 && !visit[nextX][nextY][use]) {
						visit[nextX][nextY][use] = true;
						Pos nextPos = new Pos();
						nextPos.x = nextX;
						nextPos.y = nextY;
						nextPos.skillUse = use;
						nextPos.cnt = cur.cnt + 1;
						q.add(nextPos);
					}
				}
			}
		}
		
		return -1;

	}
}
