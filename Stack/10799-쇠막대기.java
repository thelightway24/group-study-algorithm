import java.io.*;
import java.util.*;

/*
* 문제의 조건에서 ()가 주어졌을 때, 바로 () 쌍이 완성되면 레이저이고
* 그렇지 않으면 막대기의 시작과 끝을 나타낸다.
*
* 이 상황에서 레이저와 막대기를 구분하기 위해서
* Stack을 사용할것인데, 이를 인덱스로 관리해서 ')' 이 나왔을 때
* 이전의 인덱스와 일치하게 되면 이는 레이저로 판단하여 레이저를 지우면서
* 막대의 개수를 카운트 해주는게 문제의 핵심이다.
*
* 만약에 레이저라고 판단이 되었을 때에는 스택의 사이즈만큼 값을 더해주게 되는데
* 이게 일반화가 되는 이유는 레이저가 막대기를 자르는 것이기에
* 레이저가 있을 경우, 스택에 쌓였다는것은 그만큼의 막대기가 존재한다는 것이다.
* 막대기를 레이저로 잘랐을 경우에, 막대기의 개수 + 1만큼이 잘려서 나오는데
* 막대기가 쌓여있을 때 == 스택의 개수 만큼 더해주면 되는것이다.
*
* 따라서 스택에 쌓인 막대기의 개수를 더해주다가
* 만약 레이저가 아니라 막대기의 끝일 경우에는
* 해당 인덱스를 스택에서 제거하고
* 막대기의 개수를 + 1만 해주는 방식으로 일반화를 시킬수 있다.
* */

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Deque<Integer> st = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i  < input.length(); ++i) {
            char c = input.charAt(i);;
            if (c == '(') {
                st.addLast(i);
            } else if (c == ')') {
                if (st.peekLast() == i - 1) {
                    st.pollLast();
                    ans += st.size();
                } else {
                    st.pollLast();;
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}