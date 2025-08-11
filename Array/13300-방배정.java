import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			StringTokenizer tokenizer = inputRead(br);
			int peopleCount = toTokenGetInt(tokenizer);
			int roomSize = toTokenGetInt(tokenizer);

			int[][] room = new int[7][2];

			int roomCount = 0;
			for(int i = 0; i < peopleCount; i++){
				tokenizer = inputRead(br);
				int gender = toTokenGetInt(tokenizer);
				int grade = toTokenGetInt(tokenizer);
				if(room[grade][gender] == 0 || room[grade][gender] % roomSize == 0){
					roomCount++;
				}
				room[grade][gender]++;
			}
			System.out.println(roomCount);
		}

	}

	private static int toTokenGetInt(StringTokenizer tokenizer) {
		return Integer.parseInt(tokenizer.nextToken());
	}

	private static StringTokenizer inputRead(BufferedReader br) throws IOException {
		String userInputRoomCondition = br.readLine();
		StringTokenizer tokenizer = new StringTokenizer(userInputRoomCondition, " ");
		return tokenizer;
	}
}
