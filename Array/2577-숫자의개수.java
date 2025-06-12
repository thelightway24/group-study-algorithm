import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i;
        int[] input = new int[3];
        for(i=0; i<3; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        int res = 1;
        for(i=0; i<3; i++) {
            res *= input[i];
        }

        String s = Integer.toString(res);
        int[] countarr = new int[10];

        for(i=0; i<s.length(); i++) {
            countarr[s.charAt(i)-'0']++;
        }

        for(i=0; i<10; i++) {
            System.out.println(countarr[i]);
        }
    }
}
