package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 참고 블로그 : https://dingdingmin-back-end-developer.tistory.com/entry/%EB%B0%B1%EC%A4%80-21275-%EC%9E%90%EB%B0%94-java-%ED%8F%B0-%ED%97%88%EC%84%9D%EB%A7%8C
 *
 * * 문제 해석
 * 1. A와 B는 각각 2 ~ 36진법까지 가지고 있고, 서로 다른 진법이다.
 * 2. A와 B를 통해 X 값을 구해내어라. 만약, A와 B를 통해 X를 구하는 조합이
 * 2개 이상이라면 Multiple, 한개라면 X,A,B 값을, 0개라면 Impossible을 출력하라.
 */
public class BOJ_21275_폰호석만 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static String xA,xB,X,max; // max = X의 최댓값

    static long a, b; // count = 1일 때 출력될 a와 b 값

    static int count; // 조합의 수

    static int[] arr; // 2 ~ 36 진법을 담을 배열
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine().trim());
        xA = st.nextToken();
        xB = st.nextToken();
        max = String.valueOf(Math.pow(2,63));

        arr = new int[122+10+1]; // ascii code z = 122이므로 +10 + 1을 한다.(최대 진법)

        for (int i = 0; i < 9; i++) {
            arr[i+1] = i+1;
        }

        for (int i = 0; i < 26; i++) {
            arr['a'+i] = i+10;
        }

        solution();

        if(count == 0){
            System.out.println("Impossible");
        }else if(count == 1){
            String xResult = X.substring(0, X.length()-2);
            System.out.println(xResult + " " + a + " " + b);
        }else if(count == 2){
            System.out.println("Multiple");
        }
    }

    private static void solution() {
        // 2 ~ 36진법까지 돌면서 X가 나올 수 있는지 체크한다.
        for (int i = 2; i <= 36; i++) {
            for (int j = 2; j <=36 ; j++) {
                if(i == j) continue; // xA와 xB는 같을 수 없으므로 skip

                if(check(i,xA) && check(j, xB)){
                    if(find(i,xA).equals(find(j,xB))){ // xA와 xB를 십진법으로 변환하고 서로 같은 경우일 때만 탐색한다.
                        if(find(i,xA).compareTo(max)>=1) continue; // xA 값이 max보다 크다면 skip
                        count++;
                        X = find(i, xA); // X에 십진수로 변환된 xA 값을 담는다.
                        a=i; // a는 i진법
                        b=j; // b는 j진법이 된다.
                    }
                }
            }
        }
    }

    /**
     * 주어진 진법에서 표현된 값을 십진법으로 변환하는 함수
     * value : 변환하려는 대상 진법
     * str : value진법으로 표현된 숫자
     * 최종적으로 십진법으로 변환된 값을 문자열로 return
     */
    private static String find(int value, String str) {
        int curDigit = 0; // 현재 처리 중인 자릿수
        double result = 0; // 십진법 결과 저장
        for (int i = str.length()-1; i >= 0 ; i--) {
            int tmp = arr[str.charAt(i)]; // value 진법에서 해당 자릿수의 값을 나타내는 숫자를 얻는다.
            result += Math.pow(value, curDigit) * tmp; // 해당 자릿수의 값을 십진법으로 변환하여 결과에 더한다.
            curDigit++; // 다음 자릿수로 이동하기 위해 1 증가
        }
        return String.valueOf(result);
    }

    /**
     * 넘겨 받은 진법이 xA 또는 xB가 될 수 있는지 체크한다.
     * 만약 검증하려는 진법이 넘겨받은 문자열보다 작거나 같다면
     * 진법이 될 수 없으므로 return false
     */
    private static boolean check(int value, String str) {
        for (int i = 0; i < str.length(); i++) {
            if(value <= arr[str.charAt(i)]) return false;
        }
        return true;
    }
}