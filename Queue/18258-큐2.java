import java.io.*;
import java.util.*;
public class Main {
	public static void main (String[] a) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		Deque<Integer> queue = new ArrayDeque<>();
		while (n-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			fun: {
				switch(st.nextToken()){
					case "push":
						queue.offer(Integer.parseInt(st.nextToken()));
						break fun;
					case "pop":
						if(queue.isEmpty()){
							bw.write("-1");
						} else {
							bw.write(String.valueOf(queue.poll()));
						}
						break;
					case "size":
						bw.write(String.valueOf(queue.size()));
						break;
					case "empty":
						if(queue.isEmpty()){
							bw.write("1");
						} else {
							bw.write("0");
						}
						break;
					case "front":
						if(queue.isEmpty()){
							bw.write("-1");
						} else {
							bw.write(String.valueOf(queue.peekFirst()));
						}
						break;
					case "back":
						if(queue.isEmpty()){
							bw.write("-1");
						} else {
							bw.write(String.valueOf(queue.peekLast()));
						}
						break;
				}
				bw.write("\n");
			}
		}
		bw.flush();
	}
}