package boj.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 달력의 높이는 해당 일자 일정 개수의 최댓값이다.
 * 2. 코팅 면적 = 달력의 높이 x 일정의 기간(길이)
 *
 * 메모리 : 12328
 * 시간 : 96
 */
public class BOJ_20207_달력_김성수 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static final int DAY_OF_YEAR = 365;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int scheduleCnt = Integer.parseInt(br.readLine().trim());

        int[] scheduleList = new int[DAY_OF_YEAR+1];

        for (int idx = 0; idx < scheduleCnt; idx++) {
            st = new StringTokenizer(br.readLine().trim());

            int startDay = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            // 해당 날짜의 일정의 개수를 증가 시킨다.
            for (int i = startDay; i <= endDay ; i++) {
                scheduleList[i]++;
            }
        }

        int area = 0; // 면적
        int maxHeight = 0; // 이어지는 일정에서 최대로 많은 일정의 개수
        int width = 0; // 이어지는 일정의 길이

        for (int i = 0; i <= DAY_OF_YEAR; i++) {
            // 해당 날짜에 일정이 존재하지 않을 때.
            if(scheduleList[i] == 0){
                area += maxHeight * width; // 일정이 비는 날이 존재하므로 코팅 면적을 구한다.
                maxHeight = width = 0; // 코팅 면적을 구했으므로 이어지는 일정의 길이와 최대로 많은 일정의 개수를 0으로 바꿔준다.
                continue;
            }

            width++; // 일정이 비지 않으므로 이어지는 일정의 수를 +1해준다.
            maxHeight = Math.max(maxHeight, scheduleList[i]); // 가장 많은 일정의 개수를 담아준다.
        }
        area += maxHeight * width; // 마지막으로 area 값을 구하여 최종 코팅 면적을 구한다.
        System.out.println(area);
    }
}
