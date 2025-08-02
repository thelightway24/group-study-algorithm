import java.io.*;
import java.util.*;

class Main {
	static int[][] map = new int[301][301];
	static boolean visit[][];
	static int[] dx = {1, -1, 0,  0};
	static int[] dy = {0,  0, 1, -1};
	static int row;
	static int col;

	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] rcInput = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		row = rcInput[0];
		col = rcInput[1];

		// 초기값 셋팅
		for(int i=0; i<row; i++){
			int[] colInput = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			for (int j=0; j<col; j++){
				map[i][j] = colInput[j];
			}
		}

		int answer = 0;
		while(true){
			// 섬 개수 체크
			visit = new boolean[301][301];
			int count = 0;
			for(int i=0; i<row; i++){
				for(int j=0; j<col; j++){
					if(map[i][j] != 0 && !visit[i][j]){
						bfs(new int[]{i, j});
						count++;
					}
				}
			}
			if(count > 1){
				break;
			}
			//다 녹아버림
			if(count == 0){
				answer = 0;
				break;
			}
			answer++;
			// 숫자 줄이기 (녹임)
			int[][] melt = new int[301][301];
			for(int i=0; i<row; i++){
				for(int j=0; j<col; j++){
					for(int d=0; d<4; d++){
						int nextRow = i + dx[d];
						int nextCol = j + dy[d];
						if(0<=nextRow&&nextRow<row&&0<=nextCol&&nextCol<col){
							int nextNum = map[nextRow][nextCol];
							if(nextNum == 0){
								melt[i][j]++;
							}
						}
					}
				}
			}
			for(int i=0; i<row; i++) {
				for (int j = 0; j < col; j++) {
					map[i][j] = Math.max(0, map[i][j] - melt[i][j]);
				}
			}

		}
		System.out.println(answer);

	}

	static void bfs(int[] start){
		int sRow = start[0];
		int sCol = start[1];
		Queue<int[]> q = new LinkedList<>();
		visit[sRow][sCol] = true;
		q.add(start);
		while(!q.isEmpty()){
			int[] cur = q.poll();

			for(int d=0; d<4; d++){
				int nRow = cur[0] + dx[d];
				int nCol = cur[1] + dy[d];
				if(0<=nRow&&nRow<row&&0<=nCol&&nCol<col){
					if(map[nRow][nCol] != 0 && !visit[nRow][nCol]){
						q.add(new int[]{nRow, nCol});
					}
					visit[nRow][nCol] = true;
				}
			}
		}
	}
}
