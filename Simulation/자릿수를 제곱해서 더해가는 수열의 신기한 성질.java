import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        List<Integer> l = new ArrayList<>();

        for (int i = 1; i <= 9999999; ++i) {
            if (solve(i))
                l.add(i);
        }

        System.out.println(l.size());
        System.out.println("실행 시간: " + (System.currentTimeMillis() - start) + " ms");
    }

    private static boolean solve(int n) {
        while (n != 1 && n != 4) {
            n = square(n);
        }
        return n != 1;
    }

    private static int square(int n) {
        int sum = 0;
        while(n > 0) {
            int tempVal = n % 10;
            n /= 10;
            sum += tempVal * tempVal;
        }
        return sum;
    }
}