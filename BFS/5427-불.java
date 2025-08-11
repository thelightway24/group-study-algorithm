import java.io.*;
import java.util.*;
class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dx = {1, -1, 0,  0};
	static int[] dy = {0,  0, 1, -1};
	public static void main(String[] a) throws Exception{
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		while(testCase-- > 0){
			result.append(solve());
		}
		System.out.println(result);
	}

	static char[][] map;
	static int[][] fire, person;
	static class Pos {
		int x;
		int y;
	}
	static String solve() throws Exception{
		StringTokenizer mapSizeToken = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(mapSizeToken.nextToken());
		int h = Integer.parseInt(mapSizeToken.nextToken());
		map = new char[h+1][w+1];
		fire = new int[h+1][w+1];
		person = new int[h+1][w+1];



		Queue<Pos> fireQ = new LinkedList<>();
		Queue<Pos> personQ = new LinkedList<>();
        int max = w * h + 1;
		for(int i=0; i<h; i++){
			char[] mapLine = br.readLine().toCharArray();
			for(int j=0; j<w; j++){
				char c = mapLine[j];
				map[i][j] = c;
				fire[i][j] = max;
				person[i][j] = -1;
				if(c == '*'){
					Pos f = new Pos();
					f.x = i;
					f.y = j;
					fireQ.add(f);
					fire[i][j] = 0;
				}
				if(c == '@'){
					Pos p = new Pos();
					p.x = i;
					p.y = j;
					personQ.add(p);
					person[i][j] = 0;
				}

			}
		}

		//fire

		while(!fireQ.isEmpty()){
			Pos cur = fireQ.poll();
			for (int d=0; d<4; d++) {
				int nextX = cur.x + dx[d];
				int nextY = cur.y + dy[d];
				if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) continue;
				if (map[nextX][nextY] == '#' || fire[nextX][nextY] <= fire[cur.x][cur.y] + 1) continue;
				fire[nextX][nextY] = fire[cur.x][cur.y] + 1;

				Pos nextPos = new Pos();
				nextPos.x = nextX;
				nextPos.y = nextY;
				fireQ.add(nextPos);
			}
		}

		int answer = -1;
		while(!personQ.isEmpty()){
			Pos cur = personQ.poll();
			for (int d=0; d<4; d++) {
				int nextX = cur.x + dx[d];
				int nextY = cur.y + dy[d];
				if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) {
					answer = person[cur.x][cur.y] + 1;
					personQ.clear();
					break;
				};
				if (map[nextX][nextY] == '#' || person[nextX][nextY] != -1) continue;
				int time = person[cur.x][cur.y] + 1;
				if (fire[nextX][nextY] <= time) continue;
				person[nextX][nextY] = time;

				Pos nextPos = new Pos();
				nextPos.x = nextX;
				nextPos.y = nextY;
				personQ.add(nextPos);
			}
		}
		return answer == -1 ? "IMPOSSIBLE\n" : answer + "\n";
	}
}
