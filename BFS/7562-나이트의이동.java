import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dx = {-1, 1, 1, -1, 2, 2, -2, -2};
	static int[] dy = {2, 2, -2, -2, 1, -1, 1, -1};
	public static void main (String[] a) throws Exception {
		int testCaseCount = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		while(testCaseCount-- > 0){
			result.append(solve());
			result.append("\n");
		}
		System.out.println(result);
	}

	static class Pos {
		int x;
		int y;
		int cnt;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
		public boolean equals(Object o){
			if (!(o instanceof Pos)) return false;
			Pos p = (Pos)o;
			return this.x == p.x && this.y == p.y;
		}
	}
	public static int solve() throws Exception {
		int size = Integer.parseInt(br.readLine());
		boolean[][] visit = new boolean[size][size];

		StringTokenizer curPosToken = new StringTokenizer(br.readLine());
		Pos curPos = new Pos(Integer.parseInt(curPosToken.nextToken()), Integer.parseInt(curPosToken.nextToken()));
		StringTokenizer tarPosToken = new StringTokenizer(br.readLine());
		Pos tarPos = new Pos(Integer.parseInt(tarPosToken.nextToken()), Integer.parseInt(tarPosToken.nextToken()));

		Queue<Pos> q = new LinkedList<>();
		q.add(curPos);
		visit[curPos.x][curPos.y] = true;

		while(!q.isEmpty()){
			Pos p = q.poll();
			if(p.equals(tarPos)){
				return p.cnt;
			}
			for(int i=0; i<8; i++){
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];
				if(nextX < 0 || nextX > size-1 || nextY < 0 || nextY > size-1){
					continue;
				}
				if(!visit[nextX][nextY]){
					Pos next = new Pos(nextX, nextY);
					next.cnt = p.cnt + 1;
					q.add(next);
					visit[nextX][nextY] = true;
				}
			}

		}
		return -1;
	}

	static int solve2() throws Exception {
		int size = Integer.parseInt(br.readLine());
		boolean[][] visit = new boolean[size][size];

		StringTokenizer curPosToken = new StringTokenizer(br.readLine());
		Pos curPos = new Pos(Integer.parseInt(curPosToken.nextToken()), Integer.parseInt(curPosToken.nextToken()));
		StringTokenizer tarPosToken = new StringTokenizer(br.readLine());
		Pos tarPos = new Pos(Integer.parseInt(tarPosToken.nextToken()), Integer.parseInt(tarPosToken.nextToken()));

		Queue<Pos> q = new LinkedList<>();
		q.add(curPos);
		visit[curPos.x][curPos.y] = true;
        	int result = 0;
		while(!q.isEmpty()){
			int qs = q.size();
			for(int t=0; t<qs; t++){
				Pos p = q.poll();
				if(p.equals(tarPos)){
					return result;
				}
				for(int i=0; i<8; i++){
					int nextX = p.x + dx[i];
					int nextY = p.y + dy[i];
					if (nextX < 0 || nextX > size - 1 || nextY < 0 || nextY > size - 1) {
						continue;
					}
					if(!visit[nextX][nextY]){
						Pos next = new Pos(nextX, nextY);
						next.cnt = p.cnt + 1;
						q.add(next);
						visit[nextX][nextY] = true;
					}
				}
			}
            result++;
		}
		return -1;
	}
}
