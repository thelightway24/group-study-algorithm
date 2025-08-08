/* 
풀이시작 : ‎2025‎년 ‎8‎월 ‎9‎일 ‎토요일, ‏‎오전 12:50:05
풀이종료 : ‎2025‎년 ‎8‎월 ‎9‎일 ‎토요일, ‏‎오전 03:14:21
걸린시간 : 2시간 24분 16초

첫째 줄에 지도의 세로 크기 N, 가로 크기 M (1 ≤ N, M ≤ 20),
주사위를 놓은 곳의 좌표 x, y(0 ≤ x ≤ N-1, 0 ≤ y ≤ M-1),
그리고 명령의 개수 K (1 ≤ K ≤ 1,000)가 주어진다.
N M x y K
4 2 0 0 8

C>
한줄입력, 인트 배열로 변경



둘째 줄부터 N개의 줄에 지도에 쓰여 있는 수가 북쪽부터 남쪽으로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다.
주사위를 놓은 칸에 쓰여 있는 수는 항상 0이다. 지도의 각 칸에 쓰여 있는 수는 10 미만의 자연수 또는 0이다.
0 2
3 4
5 6
7 8

N * m (n4 m2)
n이 남한계
m이 동한계
서 --- 동  
  1 2    북
1 0 2    |
2 3 4    |
3 5 6    |
4 7 8    남


마지막 줄에는 이동하는 명령이 순서대로 주어진다.
동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로 주어진다.
4 4 4 1 3 3 3 2

주사위 ( 지도위 1, 동 3)
[동 서 남 북 윗면 아랫면]
              동 서  남  북  위  아래
4 - 남쪽으로 => [0, 0, 0, 0, 0, 3] - 0
4 - 남쪽으로 => [0, 0, 0, 3, 0, 5] - 0
4 - 남쪽으로 => [0, 0, 0, 5, 3, 0] - 3
1 - 동쪽으로 => [3, 0, 0, 5, 0, 8] - 0
3 - 북쪽으로 => [3, 0, 8, 0, 0, 6] - 0
3 - 북쪽으로 => [3, 0, 6, 0, 8, 4] - 8
3 - 북쪽으로 => [3, 0, 4, 8, 6, 2] - 6
2 - 서쪽으로 => [2, 6, 4, 8, 3, 0] - 3
남쪽: 남쪽 -> 바닥면 / 북-> 위 / 서-동 변동 X/ 위 -> 남 / 아래 - 북
동쪽: 남북변동X / 동쪽 -> 바닥면 / 위 -> 동 / 서쪽 -> 위 / 아래 -> 서
북쪽: 동 서 -> 변동 X / 아래 -> 남 / 위 -> 북 / 남 -> 위 / 북 -> 아래 /  / 
서쪽: 아래 -> 동 / 위->서 / 남북 변동X/ 동->위 / 서-> 아래

*/

import java.io.*;
import java.util.*;
class Main {
	static class Pos {
		int x;
		int y;
		int limitX;
		int limitY;
	}
	static class Dice {
		int up;
		int down;
		int e;
		int w;
		int s;
		int n;

		void goS(){
			//남쪽 -> 바닥 -> 북 -> 위 -> 남
			//남->바닥
			int tempS = s;
			s = down;

			// 바닥 -> 북
			down = n;

			// 북 -> 위
			n = up;

			// 위 -> 남
			up = tempS;
		}

		void goN(){
			// 남 > 위 > 북 > 아래 > 남
			int tempS  = s;
			s = up;
			up = n;
			n = down;
			down = tempS;
		}

		void goW(){
			// 동 -> 위 -> 서 -> 아래 -> 동
			int tempE = e;
			e = up;
			up = w;
			w = down;
			down = tempE;
		}
		void goE(){
			// 동 -> 아래 -> 서 -> 위 -> 동
			int tempE = e;
			e = down;
			down = w;
			w = up;
			up = tempE;
		}
	}

	static Pos dicePos = new Pos();
	static Dice dice = new Dice();
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] condition = Arrays.stream(br.readLine().split(" "))
						  .mapToInt(Integer::parseInt)
						  .toArray();
		dicePos.limitY = condition[0];
		dicePos.limitX = condition[1];
		dicePos.y = condition[2] + 1;
		dicePos.x = condition[3] + 1;
		int commandN = condition[4];

		map = new int[dicePos.limitX+1][dicePos.limitY+1];
		// 맵 만듬
		for(int i=0; i < dicePos.limitY; i++){
			int[] inputNums = Arrays.stream(br.readLine().split(" "))
							  .mapToInt(Integer::parseInt)
			 				  .toArray();
			for(int j=0; j < inputNums.length; j++){
				map[j+1][i+1] = inputNums[j];
			}
		}

		// 명령 시작
		int[] commands = Arrays.stream(br.readLine().split(" "))
								.mapToInt(Integer::parseInt)
								.toArray();

		StringBuilder result = new StringBuilder();

		for(int com : commands){
			int r = resolve(com);
			if(r!=-1){ // -1이면 무시된 명령 -1이 아니므로 정상 리턴
				result.append(r);
				result.append("\n");
			}
		}
		System.out.println(result);
	}

	static int resolve(int command){
		if(!주사위_이동(command)){ // 명령 무시 되면
			return -1;
		};
		맵_변경();
		return dice.up;
	}

	static boolean 주사위_이동(int command){
		if(command == 1){ //동
			int nextX = dicePos.x+1;
			if(0<nextX && nextX < dicePos.limitX+1){
				dicePos.x = nextX;
				dice.goE();
			} else {
				return false; // 명령 무시하도록 대충 수정
			}
		}
		if(command == 2){ //서
			int nextX = dicePos.x-1;
			if(0<nextX && nextX < dicePos.limitX+1){
				dicePos.x = nextX;
				dice.goW();
			} else {
				return false;
			}
		}
		if(command == 3){ //북
			int nextY = dicePos.y-1;
			if(0<nextY && nextY < dicePos.limitY+1){
				dicePos.y = nextY;
				dice.goN();
			} else {
				return false;
			}
		}
		if(command == 4){ //남
			int nextY = dicePos.y+1;
			if(0<nextY && nextY < dicePos.limitY+1){
				dicePos.y = nextY;
				dice.goS();
			} else {
				return false;
			}
		}
		return true;
	}

	static void 맵_변경(){
		if(map[dicePos.x][dicePos.y] == 0){
			map[dicePos.x][dicePos.y] = dice.down;
		} else {
			dice.down = map[dicePos.x][dicePos.y];
			map[dicePos.x][dicePos.y] = 0;
		}
	}
}