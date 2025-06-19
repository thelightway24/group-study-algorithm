import java.io.*;
import java.util.*;

/*
* n이 500,000으로 주어지는데 만일 동일한 높이의 값들이 주어질 경우에 나올 수 있는 쌍의 개수는
* N(N-1)/2이므로 500,000^2으로 25,000,000,000,000이 된다.
* 이 범위는 10^14 정도이므로 int 범위로는 불가능하고 Long으로 정답을 체크해야함
*
* 실제 로직을 구현할 때는 Deque로도 가능할 것 같다
* N이 50만으로 O(N^2)으로 구현하면 시간초과가 나서 O(N)으로 돌 수 있도록 해야한다.
* 즉 한번의 순회만으로 모든 쌍을 구할 수 있어야 한다.
*
* 실제 로직을 계산을 하면
* Stack을 사용할것인데 입력을 받으면서 Stack에 누적해서 쌓아가고
* 입력을 받을 때마다 Stack의 Top에 있는 값과 비교해서 누적해서 계산을 해줘야한다.
* 그런데 문제에서 같은 높이의 값들이 주어졌을 경우에도 가능하다고 나와있기 때문에
* 이전의 Stack문제를 푸는것처럼 풀게되면 동일한 높이의 값을 계산을 못해주게 된다.
* 그래서 동일한 높이의 값에서는 누적의 값을 계산하기 위해서 Pair 클래스를 만들어서
* 이 부분에서 높이와 이 높이를 통해 만들 수 있는 쌍의 개수를 저장해준다.
*
* 그래서 실제 예시를 들어보면
* 입력으로 주어진 7 2 4 1 2 2 5 1이 동작을 한다고 하면
* 우선 Stack에 2를 넣고
* 다음에 4가 들어오면 2를 pop하고 2의 count인 1을 더해주고
* 4를 Stack에 넣어준다. 이 떄 2와4의 한쌍의 개수는 이미 pop로직에서 계산이 되어있다.
* 다음에 1이 들어오면 pop을 하지 않고, 그대로 Stack에 누적이 되며 ans++로 인해서 쌍의 계산이 들어간다.
* 다음에 2가 들어오면 1을 pop하고 1의 count인 1을 더해주고, Stack이 비어있지 않으므로 ans++계산도 들어간다.
* 이 동작을 생각해보면 4-1, 1-2, 4-2의 쌍을 만들수 있기에 총 누적값이 지금까지 4로 계산이 제대로 누적이 되고있음을 확인할 수 있다.
* 다음에 2가 들어오면 이전에 들어온 2가 pop이 되고 이 떄의 count인 1을 더해주고, 다음에 들어가는 Stack에 들어가는 2의 cnt는 2로 누적해서 들어간다.
* 이 과정에서 ans++까지 진행되며 ans가 6이 된다.
* 다음에 5가 들어왔을 경우, 모든 값들이 pop이 되고 각 count였었던 (4의 count)1,(2의 count)2을 더해주게 되어 9가 된다.
* 마지막으로 1이 들어오면 pop은 동작하지 않고, Stack이 비어있지 않으므로 마지막 쌍 계산인 5-1이 계산되어(ans++) 10이 된다.
*
* */

public class Main {

    static int n;
    static long ans = 0;

    public static class Pair {
        int height;
        int count;

        Pair(int h, int c) {
            this.height = h;
            this.count = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < n; ++i) {
            int h = Integer.parseInt(br.readLine());
            int cnt = 1;

            while (!st.isEmpty() && st.peek().height <= h) {
                Pair p = st.pop();
                ans += p.count;
                if (p.height == h) {
                    cnt += p.count;
                }
            }

            if (!st.isEmpty()) ans++;
            st.push(new Pair(h, cnt));
        }
        System.out.println(ans);
    }
}
