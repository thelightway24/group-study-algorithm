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

			//str.length <= 100
			String str = br.readLine();
			int[] alphabets = new int[26];

			for (int i = 0; i < str.length(); i++) {
				alphabets[str.charAt(i) - 'a']++;
			}
			for (int i = 0; i < alphabets.length; i++) {
				bw.write(alphabets[i] + " ");
			}

			br.close();
			bw.flush();
			bw.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}


