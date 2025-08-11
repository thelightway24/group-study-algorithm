import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());

		while(testCaseCount > 0){
			Deque<Character> l = new ArrayDeque();
			Deque<Character> r = new ArrayDeque();
			char[] ca = br.readLine().toCharArray();

			for (char c : ca) {
				if(c == '>'){
					if(!r.isEmpty()) l.offerLast(r.pollFirst());
				} else if(c == '<'){
					if(!l.isEmpty()) r.offerFirst(l.pollLast());
				} else if(c == '-'){
					if(!l.isEmpty()) l.removeLast();
				} else {
					l.addLast(c);
				}

			}
			StringBuilder sb = new StringBuilder(l.size() + r.size());
			for (Character c : l)  sb.append(c);
			for (Character c : r) sb.append(c);
			System.out.println(sb);

			testCaseCount--;
		}
	}
}