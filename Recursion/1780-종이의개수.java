import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int minus = 0, zero = 0, one = 0;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			recursion(0, 0, n);
			bw.write(minus + "\n" + zero + "\n" + one);
			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}


	static void recursion(int x, int y, int size) {
		if (check(x, y, size)) {
			if (map[y][x] == -1) {
				minus++;
			} else if (map[y][x] == 0) {
				zero++;
			} else {
				one++;
			}
			return;
		}

		// 3등분 분할
		int newSize = size / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				recursion(x + j * newSize, y + i * newSize, newSize);
			}
		}
	}

	static boolean check(int x, int y, int size) {
		int first = map[y][x];
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (map[i][j] != first) return false;
			}
		}
		return true;
	}
}

// divide & conquer