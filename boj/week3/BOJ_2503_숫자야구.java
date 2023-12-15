package boj.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 조건 1. 세개의 숫자만 주어진다.
 * 조건 2. 세개의 숫자 중 0은 포함될 수 없으며, 서로 각자 다른 수이다.
 * <p>
 * 스트라이크 볼이 같은 경우는 true로
 * 같지 않은 경우는 false로.
 *
 * 메모리 : 12540
 * 시간 : 88
 */
public class BOJ_2503_숫자야구 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int inputCnt = Integer.parseInt(br.readLine().trim());

        int answer = 0;

        int[] arr = new int[1000];

        // 서로다른 숫자로 구성되어 있어야 한다.
        // 숫자에 0이 들어가선 안된다.
        for (int i = 123; i <= 987; i++) {
            String tmpStr = String.valueOf(i);

            if (tmpStr.charAt(0) == tmpStr.charAt(1)
                    || tmpStr.charAt(0) == tmpStr.charAt(2)
                    || tmpStr.charAt(1) == tmpStr.charAt(2)
                    || tmpStr.charAt(0) == '0'
                    || tmpStr.charAt(1) == '0'
                    || tmpStr.charAt(2) == '0') arr[i] = -1;
        }


        for (int i = 0; i < inputCnt; i++) {
            st = new StringTokenizer(br.readLine().trim());

            String inputStr = st.nextToken();

            int inputStrike = Integer.parseInt(st.nextToken());

            int inputBall = Integer.parseInt(st.nextToken());

            for (int j = 123; j <= 987; j++) {
                if(arr[j] == -1) continue;

                int strike = 0;
                int ball = 0;

                String tmpStr = String.valueOf(j);
                // 스트라이크 검사
                for (int k = 0; k < 3; k++) {
                    if(inputStr.charAt(k) == tmpStr.charAt(k)) {
                        strike++;
                    }
                }

                // 볼 검사
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        // 수가 같으면서 자릿수가 다를 때
                        if(inputStr.charAt(k) == tmpStr.charAt(l) && k != l){
                            ball++;
                        }
                    }
                }

                if(strike != inputStrike || ball != inputBall){
                    arr[j] = -1;
                    continue;
                }

                arr[j]++;
            }
        }

        // 총 입력받은 값과 같은 크기의 값이 존재할 때 answer +1
        for (int i = 123; i <= 987; i++) {
            if(arr[i] != -1 && arr[i] == inputCnt) answer++;
        }

        System.out.println(answer);
    }
}