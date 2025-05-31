import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        int k = Integer.parseInt(br.readLine());
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == k) {
                ans++; left++; right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(ans);
    }
}
