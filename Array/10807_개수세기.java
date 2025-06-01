import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class prob5_10807_개수세기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(bf.readLine());
        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int num = Integer.parseInt(bf.readLine());
        int i;
        int count = 0;

        for(i=0; i<len; i++) {
            if(arr[i]==num) count++;
        }
        System.out.println(count);
    }
}
