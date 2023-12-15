package boj.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * * 문제 해결 방법
 * 1. 이전 문자와 현재 문자가 다를 때를 비교한다.
 * 2. 만약 다르다면 이전 값들을 저장해놓은 HashSet에서 현재 문자가 존재하는지 파악한다.
 * 3. 만약 존재한다면 return false
 * 4. solution 함수가 return true를 반환한다면 해당 갑은 그룹 단어이므로 answer를 +1 해준다.
 *
 * 메모리 : 11656
 * 시간 : 80
 */
public class BOJ_1316_그룹단어체커 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static HashSet<Character> hashSet;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        hashSet = new HashSet<>();

        int strCnt = Integer.parseInt(br.readLine().trim());

        int answer = 0;

        for (int i = 0; i < strCnt; i++) {
            String str = br.readLine().trim();

            char[] charStr = str.toCharArray();

            if(solution(charStr)) answer++;
        }

        System.out.println(answer);
    }

    private static boolean solution(char[] charStr) {
        hashSet = new HashSet<>();

        char beforeTmp = ' ';
        hashSet.add(charStr[0]);
        for (int i = 1; i < charStr.length; i++) {
            beforeTmp = charStr[i-1];
            char currentTmp = charStr[i];

            if(beforeTmp != currentTmp){
                if(hashSet.contains(currentTmp)){
                    return false;
                }
            }

            hashSet.add(currentTmp);
        }
        return true;
    }
}