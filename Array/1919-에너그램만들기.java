import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        String input2 = br.readLine();

        int[] arr = new int[26];
        for (int i = 0; i < input1.length(); ++i) {
            arr[input1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < input2.length(); ++i) {
            arr[input2.charAt(i) - 'a']--;
        }

        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            ans += Math.abs(arr[i]);
        }
        System.out.println(ans);
    }
}