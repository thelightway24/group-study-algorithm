import java.io.*;
import java.util.*;

public class Main {

    public static boolean check(String a, String b) {
        if (a.length() != b.length())
            return false;

        int[] count = new int[26];

        for (int i = 0; i < a.length(); ++i) {
            count[a.charAt(i) - 'a']++;
            count[b.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; ++i) {
            String[] str = br.readLine().split(" ");
            String a = str[0];
            String b = str[1];
            if (check(a,b)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }
}