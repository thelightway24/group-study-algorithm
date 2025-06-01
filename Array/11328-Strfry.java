import java.io.*;
import java.util.*;
public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{
		int caseCount = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		while (caseCount-- > 0) {
			StringTokenizer token = new StringTokenizer(br.readLine()," ");
			result.append(
				solve(token.nextToken(), token.nextToken()) ?
				"Possible\n" :
				"Impossible\n");
		}
		System.out.println(result.toString());

	}

	private static boolean solve(String a, String b){
		char[] aArray = a.toCharArray();
		char[] bArray = b.toCharArray();
		Arrays.sort(aArray);
		Arrays.sort(bArray);
		for(int i = 0 ; i < aArray.length ; i++){
			if(aArray[i] != bArray[i]){
				return false;
			}
		}
		return true;
	}
}
