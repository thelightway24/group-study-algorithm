import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());

        Deque<Long> stack = new ArrayDeque<>();

        long count = 0;
        for(int i =0; i<len; i++) {
            Long h = Long.parseLong(br.readLine());
            while(!stack.isEmpty() && stack.peekLast() <= h) { // 좌측에 있는 빌딩 중 낮은 빌딩은 stack에서 제거
                stack.pollLast();
            }
            count+= stack.size(); // stack에 남아있는 빌딩은 나를 볼 수 있는 빌딩들 이므로 추가
            stack.addLast(h); // stack에 빌딩 추가
        }

        System.out.println(count);
    }
}