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

			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {

				char[] chars = br.readLine().toCharArray();
				LinkedList<Character> list = new LinkedList<>();
				ListIterator<Character> iterator = list.listIterator();

				for (int j = 0; j < chars.length; j++) {

					if (chars[j] == '<') {
						if (iterator.hasPrevious()) iterator.previous();
					}else if (chars[j] == '>') {
						if (iterator.hasNext()) iterator.next();
					}else if (chars[j] == '-') {
						if (iterator.hasPrevious()) {
							iterator.previous();
							iterator.remove();
						}
					}else {
						iterator.add(chars[j]);
					}
				}

				for (char c : list) bw.write(c);
				if (i != n - 1) bw.newLine();
			}

			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}

// 가장 큰 성과 -> Iterator를 커서처럼 활용할 줄 알게 되어 시간복잡도를 압도적으로 단축할 수 있게 됨
