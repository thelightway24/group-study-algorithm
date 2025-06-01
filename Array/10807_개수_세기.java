import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int numberCount = Integer.parseInt(br.readLine());
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			int condition = Integer.parseInt(br.readLine());
			int result = 0;
			for(int i = 0; i < numberCount; i++){
				if(Integer.parseInt(tokenizer.nextToken()) == condition){
					result++;
				}
			}
			System.out.println(result);
		}
	}
}
