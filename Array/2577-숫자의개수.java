import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 1;
        for (int i = 0; i < 3; ++i) {
            int input = Integer.parseInt(br.readLine());
            ans *= input;
        }

        String result = String.valueOf(ans);
        int[] arr = new int[10];
        for (int i = 0; i < result.length(); ++i) {
            arr[result.charAt(i) - '0']++;
        }
        for (int i = 0; i < 10; ++i)  {
            System.out.println(arr[i]);
        }
    }
}
