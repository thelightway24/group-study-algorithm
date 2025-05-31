import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		List<String> arr = new ArrayList<>(Arrays.asList(input));
        String k = br.readLine();

        System.out.println(Collections.frequency(arr, k));
    }
}
