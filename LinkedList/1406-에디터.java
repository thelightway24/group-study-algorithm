import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int n = Integer.parseInt(br.readLine());
        LinkedList<Character> ll = new LinkedList<>();
        for (char c: input.toCharArray())  ll.add(c);
        ListIterator<Character> it = ll.listIterator(ll.size());

        for (int i = 0; i < n; ++i) {
            String temp = br.readLine();
            char op = temp.toCharArray()[0];
            if (op == 'L' && it.hasPrevious()) {
                it.previous();
            } else if (op == 'D' && it.hasNext()) {
                it.next();
            } else if (op == 'B' && it.hasPrevious()) {
                it.previous();
                it.remove();
            } else if (op == 'P') {
                char c = temp.toCharArray()[2];
                it.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : ll) {
            sb.append(c);
        }
        System.out.println(sb);
    }

    private static void dqVersion(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Deque<Character> dq = new ArrayDeque<>();
        Deque<Character> dq2 = new ArrayDeque<>();
        for (char c: input.toCharArray())  dq.addLast(c);

        for (int i = 0; i < n; ++i) {
            String temp = br.readLine();
            char op = temp.toCharArray()[0];
            if (op == 'L') {
                if (!dq.isEmpty()) dq2.addFirst(dq.removeLast());
            } else if (op == 'D') {
                if (!dq2.isEmpty()) dq.addLast(dq2.removeFirst());
            } else if (op == 'B') {
                if (!dq.isEmpty()) dq.removeLast();
            } else if (op == 'P') {
                String[] orders = temp.split(" ");
                String newString = orders[1];
                dq.addLast(newString.charAt(0));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : dq) sb.append(c);
        for (Character c : dq2) sb.append(c);
        System.out.println(sb);
    }

    private static void stVersion(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);

        for (int i = 0; i < n; ++i) {
            String temp = br.readLine();

            if (temp.toCharArray()[0] == 'L' && !stack.isEmpty()) {
                stack2.push(stack.pop());
            } else if (temp.toCharArray()[0] == 'D' && !stack2.isEmpty()) {
                stack.push(stack2.pop());
            } else if (temp.toCharArray()[0] == 'B' && !stack.isEmpty()) {
                stack.pop();
            } else if (temp.toCharArray()[0] == 'P') {
                String[] orders = temp.split(" ");
                String newString = orders[1];
                stack.push(newString.charAt(0));
            }


        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) sb.append(c);
        for (int i = stack2.size() - 1; i >= 0; --i) sb.append(stack2.get(i));
        System.out.println(sb);
    }

}

