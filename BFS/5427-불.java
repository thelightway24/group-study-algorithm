import java.io.*;
import java.util.*;
class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dx = {1, -1, 0,  0};
	static int[] dy = {0,  0, 1, -1};
	public static void main(String[] a) throws Exception{
		int testCase = Integer.parseInt(br.readLine);
		StringBuilder result = new StringBuilder();
		while(testCase-- > 0){
			result.append(solve());
		}
		System.out.println(result);
	}
	
	static char[][] map;
    static int[][] fire, person;
	class Pos {
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
		Pos personInit = new Pos();
		Pos fireInit = new Pos();
		
		for(int i=0; i<h; i++){
			char[] mapLine = br.readLine().toCharArray();
			for(int j=0; j<w; j++){
				char c = mapLine[j];
				map[i][j] = c;
				if(c == '*'){
					personInit.x = i;
					personInit.y = j;
					fire[x][y] = 0;
				}
				if(c == '@'){
					fireInit.x = i;
					fireInit.y = j;
					person[x][y] = 0;
				}
			}
		}
		
		//fire
		Queue<Pos> q = new LinkedList<>();
		q.add(fireInit);
		while(!q.isEmpty()){
			Pos cur = q.poll();
			for (int d=0; d<4; d++) {
                    int nextX = p.x + dx[d];
					int nexty = p.y + dy[d];
                    if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) continue;
                    if (map[nextX][nextY] == '#' || fire[nextX][nextY] <= fire[cur.x][cur.y] + 1) continue;
                    fire[nextX][nextY] = fire[cur.x][cur.y] + 1;
					
					Pos nextPos = new Pos();
					nextPos.x = nextX;
					nextPos.y = nextY;
                    q.add(nextPos);
            }
		}
		
		int answer = -1;
		q.add(personInit);
		while(!q.isEmpty()){
			Pos cur = q.poll();
			for (int d=0; d<4; d++) {
                    int nextX = p.x + dx[d];
					int nexty = p.y + dy[d];
                    if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) {
						answer = person[p.x][p.y] + 1;
                        personQ.clear();
                        break;
					};
                    if (map[nextX][nextY] == '#' || person[nextX][nextY] > 0) continue;
                    int time = person[cur.x][cur.y] + 1;
					if (fire[nextX][nextY] <= time) continue;
					person[nextX][nextY] = time;
					
					Pos nextPos = new Pos();
					nextPos.x = nextX;
					nextPos.y = nextY;
                    q.add(nextPos);
            }
		}
		return answer == -1 ? "IMPOSSIBLE\n" : answer + "\n";
	}
	
	
}