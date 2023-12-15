package boj.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
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