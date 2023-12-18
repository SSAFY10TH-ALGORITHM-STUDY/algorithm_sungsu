package boj.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 메모리 : 14344
 * 시간 : 172
 *
 * sum이 양수일 때 rp를 1 줄이고,
 * 음수일 때 lp를 1 늘리는 이유는
 * 그렇게 하지 않으면 간극이 줄어들지 않기 때문이다
 */
public class BOJ_2473_세용액 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int waterCnt;
    static long[] waterList;
    static long answer;
    static long[] answerList;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        waterCnt = Integer.parseInt(br.readLine().trim());

        waterList = new long[waterCnt];

        st = new StringTokenizer(br.readLine().trim());

        for (int i = 0; i < waterCnt; i++) {
            waterList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(waterList);

        answer = Long.MAX_VALUE;
        answerList = new long[3];

        /**
         * idx를 waterCnt-2까지만 알아보아도 모든 경우를 파악할 수 있다.
         */
        for (int i = 0; i < waterCnt - 2; i++) {
            solution(i);
        }

        Arrays.sort(answerList);

        for (int i = 0; i < 3; i++) {
            System.out.print(answerList[i] + " ");
        }
    }

    private static void solution(int idx) {
        // 이렇게 함으로써 중복된 조합을 피할 수 있다.
        int lp = idx+1;
        int rp = waterCnt-1;

        while(lp < rp){
            long sum = waterList[lp] + waterList[rp] + waterList[idx];
            long absSum = Math.abs(sum);

            // 두 용액 갱신
            if(absSum < answer){
                answerList[0] = waterList[lp];
                answerList[1] = waterList[rp];
                answerList[2] = waterList[idx];
                answer = absSum;
            }

            if(sum > 0){
                rp--;
            }else lp++;
        }
    }
}