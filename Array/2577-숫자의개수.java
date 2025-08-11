import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		int[] userInput = getUserInput();
		int multiplyValue = multiply(userInput);
		int[] solve = solve(multiplyValue);
		Arrays.stream(solve)
			.forEach(System.out::println);
	}

	private static int[] getUserInput() throws Exception {
		int[] userInput = new int[3];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 3; i++) {
			try{
				userInput[i] = Integer.parseInt(br.readLine());
			} catch(NumberFormatException e){}
		}
		return userInput;
	}

	/**
	 * 1000 * 1000 * 1000은 10억이므로 int 타입 사용 OK
	 */
	private static int multiply(int[] userInput) {
		return userInput[0] * userInput[1] * userInput[2];
	}

	private static int[] solve(int multiplyValue) {
		int[] result = new int[10];

		int temp = multiplyValue;
		while (true) {
			int value = temp % 10;
			temp /= 10;
			result[value]++;
			if (temp < 10) {
				result[temp]++;
				break;
			}
		}
		return result;
	}
}
