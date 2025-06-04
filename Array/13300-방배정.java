package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Array13300방배정 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 참가하는 학생 수, 최대 방 배정 인원
		String[] condition = br.readLine().split(" ");
		int totalPeople = Integer.parseInt(condition[0]);
		int maxPeople = Integer.parseInt(condition[1]);
		String[] studentInfo;

		// 성별, 학년 카운트를 위한 배열 선언
		int[] genderCollector = new int[totalPeople];
		int[] gradeCollector = new int[totalPeople];

		// 남, 여 카운트를 위한 변수 선언
		int girl = 0;
		int man = 0;

		// 전체 인원 수 만큼 순회하여 성별, 학년을 분리
		for (int i = 0; i < totalPeople; i++) {
			studentInfo = br.readLine().split(" ");
			genderCollector[i] = Integer.parseInt(studentInfo[0]);
			gradeCollector[i] = Integer.parseInt(studentInfo[1]);
		}

		// 방 개수를 구하는 로직
		int roomCount = 0;
		// 1 ~ 6학년 순회
		for(int i = 1; i <= 6; i++) {
			// 모든 학생을 대상으로 순회
			for (int j = 0; j<totalPeople; j++) {
				// 학년이 매칭되면 성별 분류
				if (gradeCollector[j] == i) {
					if (genderCollector[j] == 0) {
						girl++;
					} else {
						man++;
					}
				}
			}
			// 방의 개수는 소수점에서 올림하여야 함으로 double로 계산하여 올림
			roomCount += (int) Math.ceil(girl/(maxPeople*1.0)) + (int) Math.ceil(man/(maxPeople*1.0));
			// 학년별 후속 계산을 위해 초기화
			girl = man = 0;
		}

		System.out.println(roomCount);

	}
}