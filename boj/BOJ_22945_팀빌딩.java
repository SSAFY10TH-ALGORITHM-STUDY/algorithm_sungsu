package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개발자 2명이 반드시 모여야 한다.
 * 팀의 능력치 계산 방식
 * (개발자 A와 개발자 B 사이에 존재하는 다른 개발자 수) x min(개발자 A의 능력치, 개발자 B의 능력치)
 *
 * 팀을 이룬 개발자 수가 맞나?
 * 개발자 A와 개발자 B 사이에 존재하는 다른 개발자 수가 무슨 의미지?
 * 개발자 A가 1이고, 개발자 B가 5라면
 * 그 사이에 존재하는 다른 개발자 수는 4,5로 두명인것이고
 * A가 1, B가 5니까 최솟값인 1이 되면서 2 x 1 = 2가 되는 것.
 *
 * 개발자 A의 위치와 개발자 B의 위치를 선정해야겠지?
 * 1 4 2 5 수열에서 나올 수 있는 경우의 수는 어떻게 될까?
 * 개발자의 능력치는 서로 같을 수 있으므로 인덱스로 접근해야한다.
 * 순열로 나올 수 있는 경우의 수를 모두 구하고, 각 경우의 수마다
 * 팀 능력치 계산 방식을 적용해서 최댓값을 answer에 담고 출력해줘보자.
 *
 * 순열로 한 결과. "시간 초과" 발생.
 * 순열의 시간 복잡도 = O(n!)
 * N은 100,000의 경우의 수가 있으므로 100,000!은 거의 무한에 가까운 수..
 *
 * 1. 투포인터를 생성한다. A는 0번째 인덱스 B는 마지막 인덱스로 둔다.
 * 2. 최댓값을 구하기 위해선 A와 B 두 수중 더 작은 값이 인덱스가 움직여야 한다.
 */
public class BOJ_22945_팀빌딩 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int engineerCnt;
    static int[] powerList;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        engineerCnt = Integer.parseInt(br.readLine().trim());

        powerList = new int[engineerCnt];

        st = new StringTokenizer(br.readLine().trim());

        for (int i = 0; i < engineerCnt; i++) {
            powerList[i] = Integer.parseInt(st.nextToken());
        }

        int aIdx = 0;
        int bIdx = engineerCnt-1;

        int A = powerList[aIdx];
        int B = powerList[bIdx];

        int betweenCnt = 0; // A와 B사이 사람 수

        for (int i = 0; i < engineerCnt; i++) {
            betweenCnt++;
        }

        betweenCnt -= 2;

        int answer = Integer.MIN_VALUE;
//        System.out.println(betweenCnt);

        for (int i = 0; i < engineerCnt-1; i++) {
            answer = Math.max(answer, betweenCnt*Math.min(A,B));
//            System.out.println(i + " " + A + " " + B);
            betweenCnt--;
            if(A < B){
                A = powerList[++aIdx];
            }else{
                B = powerList[--bIdx];
            }
        }

        System.out.println(answer);
    }
}
