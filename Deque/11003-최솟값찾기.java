import java.io.*;
import java.util.*;



/* 11003번 - 최솟값 찾기
* 단순하게 우선순위 큐를 사용하면서 {값, 인덱스}로 관리하면서 인덱스 범위가 벗어나는 형태로
* 해당 코드를 구현하면 이 문제의 경우 시간 복잡도가 O(n log n)으로 해결이 된다. (우선순위 큐의 정렬 방식의 속도가 O(log n)이므로)
* 그런데도 이 문제를 우선순위 큐로 풀게 되면 시간초과가 발생한다.
* 아마 Java에서 메모리를 관리하고 처리하는 부분이 C++보다 느리기 때문인 것 같다.
* C++의 경우에는 우선순위 큐로 풀린다. (진짜 화남)
* 그래서 이 문제는 다른 방식인 덱을 이용해서 풀어야한다.
*
* 덱을 이용해서 풀어내야하는데 이 문제에서는 슬라이딩윈도우 라는 알고리즘을 사용해야한다.
* 슬라이딩 윈도우는 주어진 범위에서 최소값을 찾는 문제로,
* 덱을 이용해서 현재 윈도우의 최소값을 유지하면서, 새로운 값이 들어올 때마다
* 덱의 마지막에 있는 값보다 작거나 같은 값은 모두 제거하고,
* 덱의 첫 번째 값이 현재 윈도우의 범위를 벗어나면 제거하는 방식으로 구현한다.
* 이 방식은 O(n) 시간 복잡도로 해결할 수 있다.
* 작동하는 방식은 Deque에 값을 넣어주는데, 매번 새로운 값이 들어올 때마다
* 덱에 마지막에 있는 값을 비교하여 마지막 값이 새로운 값보다 크거나 같으면
* 마지막 값을 제거하고, 새로운 값을 추가한다.
* 이 후, 덱의 첫 번째 값이 현재 윈도우의 값을 벗어나면
* 첫 번쨰의 값을 제거하고, 그 다음의 첫 번째 값이 최솟값이 된다.
* 왜냐하면 덱에서 값을 추가하는 방식에서 항상 최솟값이 맨 앞이 되도록 유지하기 때문에
* 앞의 값이 범위를 벗어나더라도 다음값이 최솟값이 된다는 것이 보장이 되는 것이다.
* 문제를 예를 들어보면
* 12 3
* 1 5 2 3 6 2 3 7 3 5 2 6
* 윈도우의 값은 3이고 12개의 값이 주어졌을 때,
* 덱은 다음과 같이 작동한다.
* 1이 들어왔을 때, 1이 덱에 들어가고
* 다음에 5의 값이 들어 왔을 때, 5는 1보다 크기때문에 1이 안없어지고
* 덱은 [1, 5]가 된다.
* 그 다음 2가 들어왔을 때, 2는 5보다 작기 때문에 5가 제거되고, 그 다음인 1은 2보다 작기 때문에
* 제거되지 않아서 덱은 [1, 2]가 된다.
* 그 다음 3이 들어왔을 때, 3은 2보다 크기 때문에 2가 안없어지고
* 덱은 [1, 2, 3]이 된다.
* 그 다음 6이 들어왔을 때, 6은 3보다 크기 때문에 3이 안없어지고
* 덱은 [1, 2, 3, 6]이 된다.
* 이 때, 윈도우의 크기가 3이기 때문에 맨 앞의 값인 1이 범위를 벗어나서 제거된다.
* 덱은 [2, 3, 6]이 되고, 이 때 최솟값은 2가 된다.
* 이런 식으로 계속 진행되면서
* 덱의 첫 번째 값이 항상 현재 윈도우의 최솟값이 되도록 유지하면서
* 새로운 값이 들어올 때마다 덱의 마지막 값을 비교하여
* 덱의 마지막 값이 새로운 값보다 크거나 같으면
* 덱의 마지막 값을 제거하고 새로운 값을 추가한다.
* 덱의 첫 번째 값이 현재 윈도우의 범위를 벗어나면
* 덱의 첫 번째 값을 제거한다.
* 이게 반복되어 최종적으로 결과값이
* 1 1 1 2 2 2 2 2 3 3 2 2 가 된다.
* */

public class Main {

    static int n, l;

    static class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        l = Integer.parseInt(input[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) arr[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        Deque<Pair> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.getLast().val >= arr[i]) dq.pollLast();

            dq.offerLast(new Pair(arr[i], i));

            if (dq.getFirst().idx <= i - l) dq.pollFirst();

            sb.append(dq.getFirst().val).append(" ");
        }
        System.out.println(sb);
    }


    // public static void priorityQueue(String[] args) throws Exception {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //
    //     String[] input = br.readLine().split(" ");
    //     n = Integer.parseInt(input[0]);
    //     l = Integer.parseInt(input[1]);
    //     StringTokenizer st = new StringTokenizer(br.readLine());
    //     int[] arr = new int[n];
    //     for (int i = 0; i < n; ++i) arr[i] = Integer.parseInt(st.nextToken());
    //
    //     StringBuilder sb = new StringBuilder();
    //
    //     PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p[0]));
    //
    //     for (int i = 0; i < n; ++i) {
    //         pq.add(new int[]{arr[i], i});
    //
    //         while (pq.peek()[1] < i - l + 1) pq.poll();
    //
    //         sb.append(pq.peek()[0]).append(" ");
    //     }
    //     System.out.println(sb);
    // }
}