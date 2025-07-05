import java.io.*;
import java.util.*;

public class Main {

    static int n, k, ans;
    static LinkedList<Integer> belt = new LinkedList<>();
    static LinkedList<Boolean> robot = new LinkedList<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        for (String s : input) {
            belt.addLast(Integer.parseInt(s));
            robot.addLast(false);
        }
        while (!check()) {
            ans++;
            move();
        }
        System.out.println(ans);
    }

    public static void move() {
        // 벨트 회전
        belt.addFirst(belt.pollLast());
        robot.addFirst(robot.pollLast());
        if (robot.get(n - 1)) robot.set(n - 1, false);
        // 로봇만 이동
        for (int i = n - 2; i >= 0; --i) {
            if (robot.get(i) && !robot.get(i + 1) && belt.get(i + 1) > 0) {
                robot.set(i + 1, true);
                robot.set(i, false);
                belt.set(i + 1, belt.get(i + 1) - 1);
            }
        }
        if (robot.get(n - 1)) robot.set(n - 1, false);
        if (belt.get(0) > 0 && !robot.get(0)) {
            robot.set(0, true);
            belt.set(0, belt.get(0) - 1);

        }
    }

    public static boolean check() {
        int check = 0;
        for (Integer i : belt) if (i == 0) check++;
        return (check >= k);
    }

}