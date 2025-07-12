import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		int result = 0;
		int count = 0;
		char prev = ' ';

		for (int i = 0; i < line.length(); i++) {
			char curr = line.charAt(i);

			if (curr == '(') {
				count++;
			} else {
				count--;

				if (prev == '(') {
					result += count;
				} else {
					result += 1;
				}
			}
			prev = curr;
		}

		System.out.println(result);
	}
}
