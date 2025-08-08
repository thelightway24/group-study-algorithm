import java.io.*;
import java.util.*;

public class Main {
	static int n, m, x, y, k; // n = 세로 크기, m = 가로 크기, 주사위 x, y 좌표, k = 명령의 개수
	static int[][] map;

	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
            //죄표는 왼쪽위부터 0,0 으로 시작. (위에서 부터 떨어진 거리(y)(n), 왼쪽으로부터 떨어진 거리(x)(m))

			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken()); // 테스트 케이스 다 통관데 안되길래 xy 바꾸니까 잘됨;;
			x = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] order = new int[k];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < k; i++) {
				order[i] = Integer.parseInt(st.nextToken());
			}

			Dice dice = new Dice();

            for (int i = 0; i < k; i++) {

                if (order[i] == 1) { // 오른쪽
                    if (x >= m - 1) continue;
                    dice.rollRight();
                    x++;
                    dice.processRoll(x, y);

                } else if (order[i] == 2) { // 왼쪽
                    if (x <= 0) continue;
                    dice.rollLeft();
                    x--;
                    dice.processRoll(x, y);

                } else if (order[i] == 3) { // 위
                    if (y <= 0) continue;
                    dice.rollUp();
                    y--;
                    dice.processRoll(x, y);

                } else if (order[i] == 4) { // 아래
                    if (y >= n -1) continue;
                    dice.rollDown();
                    y++;
                    dice.processRoll(x, y);
                }
                bw.write(dice.sideNums[dice.top] + "\n");
            }

			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class Dice {
		int[] sideNums = new int[7];
		int top, bottom, right, left, up, down;

		public Dice() {
			this.sideNums[1] = 0;
			this.sideNums[2] = 0;
			this.sideNums[3] = 0;
			this.sideNums[4] = 0;
			this.sideNums[5] = 0;
			this.sideNums[6] = 0;
			this.top = 1;
			this.bottom = 6;
			this.right = 3;
			this.left = 4;
			this.up = 2;
			this.down = 5;
		}

		public void rollRight() {
			int temp = top;
			top = left;
			left = bottom;
			bottom = right;
			right = temp;
		}

		public void rollLeft() {
			int temp = top;
			top = right;
			right = bottom;
			bottom = left;
			left = temp;
		}

		public void rollUp() {
			int temp = top;
			top = down;
			down = bottom;
			bottom = up;
			up = temp;
		}

		public void rollDown() {
			int temp = top;
			top = up;
			up = bottom;
			bottom = down;
			down = temp;
		}

        public void processRoll(int x, int y){
            if (map[y][x] == 0) {
                map[y][x] = sideNums[bottom];
            } else {
                sideNums[bottom] = map[y][x];
                map[y][x] = 0;
            }
        }
	}
}