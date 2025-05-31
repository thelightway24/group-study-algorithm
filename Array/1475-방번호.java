import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] arr = new int[10];

        for (int i = 0; i < input.length(); ++i) {
            int temp = input.charAt(i) - '0';
            if (temp == 6 || temp == 9)  {
                if (arr[6] == arr[9]) {
                    arr[6]++;
                } else {
                    arr[9]++;
                }
            } else {
                arr[temp]++;
            }
        }
        System.out.println(Arrays.stream(arr).max().getAsInt());
    }
}
