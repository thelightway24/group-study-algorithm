/*
문제를 잘 읽어야했다.
처음에 톱니바퀴가 회전한 뒤의 극을 비교한 뒤,
그 영향으로 다른 톱니바퀴가 돌아가는 줄 알고 코딩했음.

그런데, 테스트 결과 실패해서 확인해보니..

톱니바퀴가 회전할 때, 서로 맞닿은 극에 따라서 옆에 있는 톱니바퀴를 회전시킬 수도 있고, 회전시키지 않을 수도 있다. 
톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전하게 된다.

이 설명이 톱니가 회전하기 전에 회전 방향을 모두 결정하는 것이었음..

*/
import java.io.*;
import java.util.*;

class Main {
	
	/*
	톱니 바퀴 클래스
	head가 12시 방향이고, 회전 시킬 때 head의 값을 변경해서 회전의 효과를 만든다.
	right는 head에서 +2의 값을 (시계방향으로 2칸 옆)
	left는 head에서 -2의 값을  (반시계방향으로 2칸 옆) 을 반환해서 극 비교의 편의를 더함.
	*/
	static class Circle {
		int[] s;
		int head;

		public Circle(char[] stat){
			s = new int[9];
			int temp = 1;
			for (char c : stat){
				s[temp++] = c - '0';
			}
			head = 1;
		}

		//회전 메소드
		public void clock(){
			head = head-1;
			if(head < 1){
				head = 8;
			}
		}

		public void reverseClock(){
			head = head+1;
			if(head > 8){
				head = 1;
			}
		}

		public int right(){
			int rHead = head+2;
			if(rHead > 8){
				rHead = rHead - 8;
			}
			return s[rHead];
		}

		public int left(){
			int lHead = head-2;
			if(lHead < 1){
				lHead = lHead + 8;
			}
			return s[lHead];
		}
	}

	static Circle[] circleArr;
	public static void main (String[] args) throws Exception {
		//톱니바퀴 4개, 톱니 8개
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//1번째 톱니바퀴
		char[] stat1 = br.readLine().toCharArray();
		Circle c1 = new Circle(stat1);

		char[] stat2 = br.readLine().toCharArray();
		Circle c2 = new Circle(stat2);

		char[] stat3 = br.readLine().toCharArray();
		Circle c3 = new Circle(stat3);

		char[] stat4 = br.readLine().toCharArray();
		Circle c4 = new Circle(stat4);

		circleArr = new Circle[5];
		circleArr[1] = c1;
		circleArr[2] = c2;
		circleArr[3] = c3;
		circleArr[4] = c4;

		int rotateCount = Integer.parseInt(br.readLine());
		while(rotateCount-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int circleSel = Integer.parseInt(st.nextToken());
			int rNumber = Integer.parseInt(st.nextToken());
			int[] rotateNumber = checkRotate(circleSel, rNumber);
			for(int i = 1; i < 5; i++){
				if(rotateNumber[i] == 1){
					circleArr[i].clock();
				} else if(rotateNumber[i] == -1) {
					circleArr[i].reverseClock();
				}
			}
		}
		System.out.println(calcPoint());
	}
	
	//회전 시킬 방향 결정, 배열 인덱스 = 톱니 번호 / 배열 값 회전 방향
	static int[] checkRotate(int circleSel, int rNumber){
		int[] result = new int[5];
		result[circleSel] = rNumber;

		int curCircleNum = circleSel;
		while(curCircleNum < 4){
			int nextCircleNum = curCircleNum+1;
			Circle curCircle = circleArr[curCircleNum];
			Circle nexCircle = circleArr[nextCircleNum];
			if(curCircle.right() != nexCircle.left()){
				result[nextCircleNum] = result[curCircleNum] * -1; //-1을 곱해서 방향을 반대로 전환
			} else {
				break;
			}
			curCircleNum++;
		}


		curCircleNum = circleSel;
		while(curCircleNum > 1){
			int preCircleNum = curCircleNum-1;
			Circle curCircle = circleArr[curCircleNum];
			Circle preCircle = circleArr[preCircleNum];
			if(curCircle.left() != preCircle.right()){
				result[preCircleNum] = result[curCircleNum] * -1;
			} else {
				break;
			}
			curCircleNum--;
		}
		return result;
	}


	// 점수계산
	static int calcPoint(){
		int sum = 0;
		sum += circleArr[1].s[circleArr[1].head];
		sum += circleArr[2].s[circleArr[2].head]*2;
		sum += circleArr[3].s[circleArr[3].head]*4;
		sum += circleArr[4].s[circleArr[4].head]*8;
		return sum;
	}

}