import java.io.*;
import java.util.*;

/*
* 이 문제는 괄호의 쌍을 통해서 값을 찾아내는 문제이다.
* 우선적으로 N이 30까지이므로, 최댓값을 생각해보면 최대 중첩을 생각하면 된다.
* 이 경우에는 3^15 = 14348907 으로 INT_MAX를 넘지 않으므로 int값으로 충분하다.
* 
* 괄호의 쌍을 생각해서 이 문제를 해결해야하는데,
* 중첩이 이 문제의 핵심이다.
* (()([[]])이 형태일 때
* 설명에서 중첩이 되는 경우를 지금 2 + 3 * 3 = 11 이 후, 2 * 11 = 22로 계산을 해줬는데
* 이 부분을 풀어서 해석을 하게 되면
* (2 * 2) + (2 * (3 * 3)) = 22로 계산이 된다.
* 즉 중첩 괄호 쌍일 때, 가중치를 도입해서 계산이 가능하다.
* 문제에 주어진 대로 입력을 받으며 가중치를 누적시켜버리고
* 괄호가 닫힐 때 마다 가중치를 나누어주는 방식으로 해결이 가능해지는 것이다.
* 
* 따라서 괄호가 열릴 때마다 가중치를 곱하고, 닫힐 때마다 가중치를 나누어주며
* 계산을 하는데, 이 부분에서 중요한 것은 이전의 문자를 기억해줘야하는 것이다.
* 
* 왜냐하면 중첩 괄호 쌍이 닫힐 때, 이전의 문자가 열리는 것인지를 확인해야지
* 값을 더해줘야하기 때문이다. 이렇게 하지 않으면 값이 중복으로 더해져서
* 원하는 값이 나오지 않는다.
* */


public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        System.out.println(solve(input));
    }

    public static int solve(String input) {
        Deque<Character> st = new ArrayDeque<>();

        int weight = 1;
        int ans = 0;
        char prev = 0;
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[') {
                st.addLast(c);
                weight *= (c == '(' ? 2 : 3);
            } else if (c == ')' || c == ']') {
                if (st.isEmpty()
                    || (c == ')'&& !(st.peekLast().equals('(')))
                    || (c == ']'&& !(st.peekLast().equals('[')))) return 0;
                if ((c == ')' && prev == '(') || (c == ']' && prev == '[')) ans += weight;
                weight /= (c == ')' ? 2 : 3);
                st.pollLast();
            }
            prev = c;
        }

        if (!st.isEmpty()) return 0;
        return ans;
    }
}
