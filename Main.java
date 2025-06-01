import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = br.readLine().split(" ");
        int totalPeople = Integer.parseInt(condition[0]);
        int maxPeople = Integer.parseInt(condition[1]);
        String[] studentInfo;

        int[] genderCollector = new int[totalPeople];
        int[] gradeCollector = new int[totalPeople];

        int girl = 0;
        int man = 0;

        for (int i = 0; i < totalPeople; i++) {
            studentInfo = br.readLine().split(" ");
            genderCollector[i] = Integer.parseInt(studentInfo[0]);
            gradeCollector[i] = Integer.parseInt(studentInfo[1]);
        }

        int roomCount = 0;
        for(int i = 1; i <= 6; i++) {
            for (int j = 0; j<totalPeople; j++) {
                if (gradeCollector[j] == i) {
                    if (genderCollector[j] == 0) {
                        girl++;
                    } else {
                        man++;
                    }
                }
            }
            roomCount += (int) Math.ceil(girl/(maxPeople*1.0)) + (int) Math.ceil(man/(maxPeople*1.0));
            girl = man = 0;
        }

        System.out.println(roomCount);

    }
}


