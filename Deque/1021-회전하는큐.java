import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] a) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 큐의 크기 N을 입력받는다.
		int n = Integer.parseInt(st.nextToken());

		// 입력받은 큐의 만큼 값들을 큐에 넣어준다.
		// 각 요소의 Index 위치를 알 수 있도록 LinkedList를 사용하였음.

		LinkedList<Integer> deque = new LinkedList<>();
		for(int i=1; i<=n; i++){
			deque.offerLast(i);
		}

		// 꺼내고자 하는 숫자 갯수를 입력 받는다.
		int m = Integer.parseInt(st.nextToken());

		// 꺼내고자 하는 수를 String Tokenizer로 입력 받음.
		StringTokenizer findValues = new StringTokenizer(br.readLine());

		// 결과값 반환용
		int result = 0;

		// 꺼내고자 하는 숫자 갯수만큼 반복 실행
		// 결국 최소값이 되는 방법으로 좌 / 우로 이동해야하는 것이므로
                         // 첫 번째 값을 뽑아서 맨 뒤로 보냄 -> 왼쪽으로 한칸 이동 (큐를 왼쪽으로 민다)
                         // 마지막 값을 뽑아서 맨 앞으로 보냄 -> 오른쪽으로 이동 (큐를 오른쪽으로 민다)


                         // 가고자 하는 값의 위치가 절반보다 작거나 같으면 --> 정방향 (왼쪽으로 밈)
                         // 가고자 하는 값의 위치가 절반보다 크면 --> 역방향 (오른쪽으로 밈)
                         // 밀때마다 result++ 하고, 마지막에 결과 출력
		while (m-- > 0){
			int target = Integer.parseInt(findValues.nextToken());
			while(deque.peekFirst() != target){
				if(deque.indexOf(target)> deque.size()/2){
					result++;
					deque.offerFirst(deque.pollLast());
				} else {
					result++;
					deque.offerLast(deque.pollFirst());
				}
			}
			deque.pollFirst();
		}
		System.out.println(result);
	}
}