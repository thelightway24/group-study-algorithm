import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] arr = new int[28];
        for (int i = 0; i < input.length(); ++i) {
            arr[input.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}


