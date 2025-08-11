/**
시작시간: ‎2025‎년 ‎8‎월 ‎11‎일 ‎월요일, ‏‎오전 8:10:13
중간종료: 

/ 중간 점검 / 
이전 값 배열 만들고 추적하는게 더 효율적 (추후 구현)
visit[], previous[]

*/
import java.io.*;
import java.util.*;

class Main {
	//수빈 0~100_000
	//동생 0~100_000
	//최대 100_000  int 범위 안
	static int subinPos;
	static int youngPos;
	static class Path {
		LinkedList<Integer> path = new LinkedList<>();
		int dist = Integer.MAX_VALUE;
		int pos;
	}
	
	static Queue<Path> q = new ArrayDeque<>();
	static Path[] pathArr = new Path[100_001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" "))
							  .mapToInt(Integer::parseInt)
							  .toArray();
		subinPos = input[0];
		youngPos = input[1];
		solve(subinPos, youngPos);
	}
	
	static String[] solve(int start, int target){
		Path init = new Path();
		pathArr[start] = init;
		init.path.add(start);
		init.dist = 0;
		init.pos = start;
		q.add(init);
		
		while(!q.isEmpty()){
			Path cur = q.poll();
			if(cur.pos == target){
				break;
			}
			for(int i=0; i<3; i++){
				int next = nextPos(i, cur.pos);
				if(!validPos(next)){
					continue;
				}
				
				if(pathArr[next] == null){
					pathArr[next] = new Path();
					pathArr[next].path = cur.path.clone();
				}
				
				if(pathArr[next].dist > pathArr[cur].dist + 1){
					pathArr[next].dist = pathArr[cur].dist + 1;
					q.add(pathArr[next]);
				}
			}
		}
		
		String[] = new String[2];
		String[0] = String.valueOf(pathArr[target].dist); //dist
		
		StringBuilder st = new StringBuilder();
		for(Integer i : pathArr[target].path){
			st.append(String.valueOf(pathArr[target].dist)).append(" ");
		}
		
		String[1] = st; //path;
	
		
	}
	
	static int nextPos(int code, int cur){
		if(code == 0){ // Telpo
			return cur * 2;
		}
		
		if(code == 1) { // walkUp
			return cur + 1;
		}
		if(code == 2) { // walkDown
			return cur - 1;
		}
		return -1;
	}
	
	static boolean validPos(int pos){
		return -1 < pos && pos < 100_001;
	}
}