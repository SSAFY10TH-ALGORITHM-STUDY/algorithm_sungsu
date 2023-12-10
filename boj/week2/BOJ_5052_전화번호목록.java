package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 주어진 문자열들 중 접두어가 없는 경우 YES를 출력
 * 2. 주어진 문자열들 중 접두어가 존재하는 경우 NO를 출력
 *
 * * 문제 핵심 풀이
 * 1. Java의 startsWith을 사용해서 대상 문자열이 특정 문자 또는 문자열로 시작하는지 체크한다.
 * 2. 오름차순으로 정렬한 뒤 탐색하여 시간 초과를 방지한다.
 *  2-1. 오름차순으로 정렬했을 때 접두어를 파악하는 것은 현재 문자열과 그 다음 문자열만 비교하면 된다.
 *
 * 메모리 : 31048
 * 시간 : 576
 */
public class BOJ_5052_전화번호목록 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 0; tc < T; tc++) {
            int strCnt = Integer.parseInt(br.readLine().trim());

            String[] phoneList = new String[strCnt]; // 전화번호 목록

            for (int i = 0; i < strCnt; i++) {
                String str = br.readLine().trim();
                phoneList[i] = str;
            }

            Arrays.sort(phoneList);

            if(checkSolution(strCnt, phoneList)) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }

    private static boolean checkSolution(int strCnt, String[] phoneList) {
        // 대상 문자열에 접두어가 존재하는지 체크할 때 오름차순으로 정렬되어 있기 때문에 현재 문자열과 그 다음 문자열 접두어 관계만 확인하면 된다.
        for (int i = 0; i < strCnt - 1; i++) {
            if(phoneList[i+1].startsWith(phoneList[i])) return false; // 접두어가 존재한다면 return false
        }
        return true;
    }
}