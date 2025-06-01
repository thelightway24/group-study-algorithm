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
			String s = br.readLine();
			String t = br.readLine();
			int count = 0;
			int[] arr = new int[26];

			for (int i = 0; i < s.length(); i++) {
				arr[s.charAt(i) - 'a']++;
			}
			for (int i = 0; i < t.length(); i++) {
				arr[t.charAt(i) - 'a']--;
			}

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0) {
					count+=Math.abs(arr[i]);
				}
			}
			bw.write(String.valueOf(count));


			br.close();
			bw.flush();
			bw.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}


