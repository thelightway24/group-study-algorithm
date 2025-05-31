import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Map<Integer, Integer> s = new HashMap<>();
        Map<Integer, Integer> f = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            input = br.readLine().split(" ");
            int b = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            if (b == 0) {
                s.put(a, s.getOrDefault(a, 0) + 1);
            } else {
                f.put(a, f.getOrDefault(a, 0) + 1);
            }
        }
        int ans = 0;
        for (Map<Integer, Integer> map : List.of(s, f)) {
            for (int count : map.values()) {
                ans += (count + k - 1) / k;
            }
        }
        System.out.println(ans);
    }
}
