import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) dq.addLast(i + 1);

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!dq.isEmpty()) {
            for (int i = 0; i < k - 1; ++i) dq.addLast(dq.pollFirst());
            sb.append(dq.pollFirst());
            if (!dq.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }


    public static void circularQueueVersion(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        CircularQueue cq = new CircularQueue(n);

        for (int i = 0; i < n; i++) {
            cq.enqueue(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!cq.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                cq.enqueue(cq.dequeueValue());
            }
            sb.append(cq.dequeueValue());
            if (!cq.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }

    public static class CircularQueue {
        private final int[] cq;
        private final int capacity;

        private int front = 0;
        private int rear = 0;
        private int size = 0;


        public CircularQueue(int capacity) {
            this.capacity = capacity;
            cq = new int[capacity];
        }

        public boolean isEmpty() { return size == 0; }

        public boolean isFull() { return size == capacity; }

        // Queue에 값 넣기
        // Index는 rear를 기준으로 증가
        public void enqueue(int value) {
            if (isFull()) throw new RuntimeException("CircularQueue is full");

            cq[rear] = value;
            rear = (rear + 1) % capacity;
            size++;
        }

        // Queue에서 값 빼기
        // Index는 front를 기준으로 증가
        public int dequeueValue() {
            if (isEmpty()) throw new RuntimeException("CircularQueue is empty");

            int val = cq[front];
            front = (front + 1) % capacity;
            size--;
            return val;
        }

        // Queue에서 현재 위치의 값 가져오기
        // front가 index의 기준이 됨
        public int peek() {
            if (isEmpty()) throw new RuntimeException("CircularQueue is empty");

            return cq[front];
        }
    }
}
