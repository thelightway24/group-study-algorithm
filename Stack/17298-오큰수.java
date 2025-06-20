import java.io.*;
import java.util.*;

public class Main {
    private static class Pair { // 수열의 순서와 값을 담는 클래스
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
        for(int i=len-1;i>=0;i--) { // 입력받은 수열의 역순으로 순회 -> 이렇게 해야 stack의 가장 상단에 있는 값이 오큰수(오른쪽에 있으면서 가장 왼쪽에 있는 수)가 될 수 있음
            int curHeight = intLine[i];
            while(!stack.isEmpty()) {
                Pair last = stack.peekLast();
                if(last.h <= curHeight) {
                    stack.pollLast(); // 수열의 값이 작거나 같으면 stack 에서 버림
                } else {
                    break; // 수열의 값이 큰 경우 오큰수 이므로 break
                }
            }

            if(!stack.isEmpty()) { // 오큰수를 결과 배열에 저장
                res[i] = stack.peekLast().h;
            } else {
                res[i] = -1; // 없으면 -1 로 기본값 지정
            }

            stack.addLast(new Pair(i,curHeight)); // 다음 for문 에서 비교를 위해 현재 수열 정보 stack에 쌓기
        }
        for(int i=0; i<len; i++) {
            if(i == len-1) {
                sb.append(res[i]);
            }
            else {
                sb.append(res[i]).append(' ');
            }
        }
        System.out.println(sb);
    }


}


