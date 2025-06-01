import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() throws Exception {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			// 0 < n < 1001
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int[] arr = new int[26];
				String s1 = st.nextToken();
				String s2 = st.nextToken();

				// for (int j = 0; j < s1.length(); j++) {
				// 	arr[s1.charAt(j) - 'a']++;
				// }
				//
				// boolean isPossible = true;
				//
				// for (int j = 0; j < s2.length(); j++) {
				// 	arr[s2.charAt(j) - 'a']--;
				// 	if (arr[s2.charAt(j) - 'a'] < 0) {
				// 		bw.write("Impossible\n");
				// 		isPossible = false;
				// 		break;
				// 	}
				// }
				// if (isPossible) bw.write("Possible\n");

				for (int j = 0; j < s1.length(); j++) {
					arr[s1.charAt(j) - 'a']++;
				}
				for (int j = 0; j < s2.length(); j++) {
					arr[s2.charAt(j) - 'a']--;
				}

				boolean isPossible = true;
				for (int j = 0; j < 26; j++) {
					if (arr[j] != 0) {
						isPossible = false;
						break;
					}
				}
				bw.write(isPossible ? "Possible\n" : "Impossible\n");
			}

			br.close();
			bw.flush();
			bw.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}


