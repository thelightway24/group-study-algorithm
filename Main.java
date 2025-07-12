import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] parent = new int[n];
		String[] input = br.readLine().split(" ");
		int delete = Integer.parseInt(br.readLine());

		if (delete == 0) {
			System.out.println(0);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (i == delete) {
				parent[i] = -2;
			} else {
				int p = Integer.parseInt(input[i]);
				if (p != -1 && parent[p] == -2) {
					parent[i] = -2;
				} else {
					parent[i] = p;
				}
			}
		}

		int leafCount = 0;
		for (int i = 0; i < n; i++) {
			if (parent[i] == -2) continue;
			boolean isLeaf = true;
			for (int j = 0; j < n; j++) {
				if (parent[j] == i) {
					isLeaf = false;
					break;
				}
			}
			if (isLeaf) {
				leafCount++;
			}
		}

		System.out.println(leafCount);
	}
}
