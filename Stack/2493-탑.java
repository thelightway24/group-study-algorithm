import java.io.*;
import java.util.*;

public class Main {
    private static class Pair { // 탑의 위치와 높이를 담는 클래스
        int idx;
        int h;

        public Pair (int idx, int h) {
            this.idx = idx;
            this.h = h;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int len = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        int[] intLine = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        int[] res = new int[len];

        Deque<Pair> stack = new ArrayDeque<>(len);
        for(int i=0;i<len;i++) {
            int curHeight = intLine[i];
            while(!stack.isEmpty()) {
                Pair last = stack.peekLast();
                if(last.h < curHeight) {
                    stack.pollLast(); // 높이가 높거나 같은 탑이 나오기 전까지는 stack 에서 pop해서 없애버림
                } else {
                    break; // 신호 받는 탑이 있을 경우 루프 탈출
                }
            }

            if(!stack.isEmpty()) { // 루프 탈출했을 시 stack에 남아있는 탑이 있으면 해당 탑의 인덱스를 결과 배열에 저장
                res[i] = stack.peekLast().idx + 1;
            }
            // stack이 비어있는 경우 기본값인 0으로 지정됨

            stack.addLast(new Pair(i,curHeight)); // 다음 for문에서 비교를 위해 현재 탑정보 stack에 쌓기
        }
        for(int i=0; i<len; i++) {
            if(i == len-1) {
                sb.append(res[i]);
            }
            else {
                //sb.append(res[i]+" "); // 이런식으로 사용하면 res[i]를 int -> string으로 변환하면서 새로운 String 객체를 만들고 공백을 그뒤에 붙이면서 오버헤드 발생
                sb.append(res[i]).append(' '); // 이렇게 int를 append 하는 경우, Integer.toString을 통해 char를 하나씩 sb에 넣어줌 + ' '도 char 타입 공백이므로 String 을 직접 생성하는 오버헤드 발생 x
            }
        }
        System.out.println(sb);
    }


}


