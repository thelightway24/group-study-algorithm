import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			int t = Integer.parseInt(br.readLine());

			for (int i = 0; i < t; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());

				while (true){
					StringTokenizer st1 = new StringTokenizer(br.readLine());
					int x = Integer.parseInt(st1.nextToken());
					int y = Integer.parseInt(st1.nextToken());

				}

			}

			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}