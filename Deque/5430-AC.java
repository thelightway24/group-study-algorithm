import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		solution();
	}

	public static void solution() {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		) {
			// 0 < t <= 100, 1 <= p <= 100,000, 0 <= n <= 100,000, 1 <= x <=100
			int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

			for (int i = 0; i < t; i++) {
				String cmd = br.readLine(); // i + 1번째 테스트 케이스의 커맨드String
				int n = Integer.parseInt(br.readLine()); // i + 1번째 테스트 케이스의 배열 길이
				String arrStr = br.readLine(); // i + 1번쩨 테스트 케이스에 주어진 배열
				arrStr = arrStr.substring(1, arrStr.length() - 1); // "[", "]" 제거
				Deque<Integer> deque = new LinkedList<>();
				if (!arrStr.isEmpty()){ // 덱에 배열 담기
					for (String str : arrStr.split(",")) {
						deque.add(Integer.parseInt(str));
					}
				}
				boolean isError = false;
				boolean isFront = true;
				for (int j = 0; j < cmd.length(); j++) { // 커맨드 별로 실행
					if (cmd.charAt(j) == 'R'){ // reverse 처리
						isFront = !isFront;
					} else { // removeFirst 처리
						if (deque.isEmpty()){ //error 처리
							isError = true;
							break;
						}
						if (isFront){
							deque.removeFirst();
						} else {
							deque.removeLast();
						}
					}
				}
				if (isError){
					bw.write("error\n");
				}else {
					bw.write("[");
					Iterator<Integer> iterator = isFront ? deque.iterator() : deque.descendingIterator(); // 순서 판단
					while (iterator.hasNext()){
						bw.write(iterator.next() + "");
						if (iterator.hasNext()) bw.write(",");
					}
					bw.write("]\n");
				}
			}

			bw.flush();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	// public static void solution2() { //개같이 시간초과
	// 	try (
	// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// 	) {
	// 		// 0 < t <= 100, 1 <= p <= 100,000, 0 <= n <= 100,000, 1 <= x <=100
	// 		int t = Integer.parseInt(br.readLine());
	// 		for (int i = 0; i < t; i++) {
	// 			char[] cmd = br.readLine().toCharArray();
	// 			int n = Integer.parseInt(br.readLine());
	// 			String arrStr = br.readLine();
	// 			arrStr = arrStr.substring(1, arrStr.length() - 1);
	// 			LinkedList<Integer> list = new LinkedList<>();
	// 			if (!arrStr.isEmpty()){
	// 				for (String str : arrStr.split(",")) {
	// 					list.add(Integer.parseInt(str));
	// 				}
	// 			}
	// 			boolean isError = false;
	// 			boolean isFront = true;
	// 			for (int j = 0; j < cmd.length; j++) {
	// 				if (cmd[j] == 'R'){
	// 					if (isFront){
	// 						isFront = false;
	// 					} else {
	// 						isFront = true;
	// 					}
	// 				} else {
	// 					if (list.isEmpty()){
	// 						isError = true;
	// 						break;
	// 					}
	// 					if (isFront){
	// 						list.removeFirst();
	// 					} else {
	// 						list.removeLast();
	// 					}
	// 				}
	// 			}
	// 			if (isError){
	// 				bw.write("error\n");
	// 			}else {
	// 				bw.write("[");
	// 				if (isFront){
	// 					for (int j = 0; j < list.size(); j++){
	// 						bw.write(list.get(j)+"");//FIXME 여기서 타임아웃
	// 						if (j != list.size()-1){
	// 							bw.write(",");
	// 						}
	// 					}
	// 				}else {
	// 					for (int j = list.size() - 1; j >= 0; j--){
	// 						bw.write(list.get(j)+""); //FIXME 여기서 타임아웃
	// 						if (j != 0){
	// 							bw.write(",");
	// 						}
	// 					}
	// 				}
	// 				bw.write("]\n");
	// 			}
	// 		}
	//
	// 		bw.flush();
	// 	}catch (IOException e){
	// 		e.printStackTrace();
	// 	}
	// }
}