import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[] dx = {-1, 1, 1, -1};
  static int[] dy = {2, 2, -2, -2};
  public static void main (String[] a) throws Exception {
	int testCaseCount = Integer.parseInt(br.readLine());
	while(testCaseCount-- > 0){
	  System.out.println(solve());
	}
  }
  
  class Pos {
	  int x;
	  int y;
	  boolean visit;
	  List<Pos> next;
	  Pos(int x, int y){
		  this.x = x;
		  this.y = y;
		  next = new ArrayList<>();
		  for(int i=0; i<5; i++){
			  int nextX = x + dx[i]
			  int nextY = x + dy[i]
			  
			  if(0 < nextX && nextX < size && 0 < nextY && nextY < size){
				  next.add(new Post(nextX, nextY));
			  }
		  }
	  }
	  public boolean equals(Pos pos){
		  return (this.x == pos.x && this.y == pos.y) : true : false;
	  }
  }
  public static int solve() throws Exception {
    int size = Integer.parseInt(br.readLiIne());
	boolean[][] visit = new boolean[size+1][size+1];
	StringTokenizer curPosToken = new StringTokenizer(br.readLine());
	Pos curPos = new Pos(curPosToken.nextToken(), curPosToken.nextToken());
	StringTokenizer tarPosToken = new StringTokenizer(br.readLine());
	Pos tarPos = new Pos(tarPosToken.nextToken(), tarPosToken.nextToken());
	Queue<Pos> q = new LinkedList<>();
	q.add(curPos);
	curPos.visit = true;
	int count = 0;
	int result = 0;
	while(q.isEmpty()){
		Pos p = q.poll();
		if(p.equals(tarPos)){
			if(result == 0 || result > count){
				result = count;
			}
		}
		for(Pos n : pos.next){
			if(!n.visit){
				n.visit = true;
				q.add(n);
			}
		}
		count++;
	}
	return result;
  }
}