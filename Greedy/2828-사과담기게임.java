import java.io.*;

public class Main {

    static int n, m, j;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        j = Integer.parseInt(br.readLine());
        int left = 1;
        int ans = 0;
        for (int i = 0; i < j; ++i) {
            int pos = Integer.parseInt(br.readLine());
            int right = left + m - 1;
            if (left <= pos && pos <= right) continue;
            else {
                if (pos < left) {
                    ans += left - pos;
                    left = pos;
                } else {
                    ans += pos - right;
                    left += pos - right;
                }
            }
        }
        System.out.println(ans);
    }


}