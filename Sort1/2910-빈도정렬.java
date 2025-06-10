import java.io.*;
import java.util.*;

public class Main {

    static int n, c;
    static Map<Integer, Integer> index = new HashMap<>();
    static Map<Integer, Integer> count = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        for (int i = 0; i < input.length; ++i) {
            int num = Integer.parseInt(input[i]);
            if (!index.containsKey(num)) {
                index.put(num, i);
            }
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> ll = new ArrayList<>(count.entrySet());
        ll.sort((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return index.get(a.getKey()) - index.get(b.getKey());
            }
            return b.getValue() - a.getValue();
        });
        for (Map.Entry<Integer, Integer> entry : ll) {
            for (int i = 0; i < entry.getValue(); ++i) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }


}