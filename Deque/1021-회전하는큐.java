import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Deque<Integer> cq = new ArrayDeque<>(size);
        Deque<Integer> q = new ArrayDeque<>(n);

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            q.addLast(num);
        }

        for(int i=1;i<=size;i++) {
            cq.addLast(i);
        }

        int count = 0;
        while(!q.isEmpty()) {
            int current = q.pollFirst();

            // current 가 위치한 index 찾기
            int index = 0;
            Iterator<Integer> it = cq.iterator();
            while (it.hasNext()) {
                if(it.next() == current){
                    break;
                }
                index++;
            }

            // 해당 index가 deque 사이즈의 절반보다 작거나 같으면, => deque 앞의 값을 뒤로 옮기면서 진행
            if(index <= cq.size()/2) {
                while(cq.peekFirst()!=current){
                    cq.addLast(cq.pollFirst());
                    count++;
                }
            } else { // 해당 index가 사이즈의 절반보다 크면, => deque 뒤의 값을 앞으로 옮기면서 진행
                while(cq.peekFirst()!=current){
                    cq.addFirst(cq.pollLast());
                    count++;
                }
            }
            cq.pollFirst();
        }
        System.out.println(count);
    }


}


