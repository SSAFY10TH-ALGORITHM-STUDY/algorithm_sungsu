package boj.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2의 제곱의 크기로 x가 증가한다.
 * k번째 값을 구하기 위해서는 1-solution(k-arr[k-1])을 재귀로 반복해서 구할 수 있다.
 * 예를 들어
 * 27번째 값을 구하기 위해서는
 * k에서 그 이전으로 등장했던 2의 4제곱인 16값을 뺀다. 그러면 11이 나온다.
 * 그 값을 k로하여 solution을 다시 재귀 호출한다.
 *
 * 이렇게 될 수 있는 이유는 구하고자 하는 k번째 값은 그 이전 제곱이었던 값만큼 역순을 했을 때
 * 나오는 값의 반대 값이기 때문이다.
 *
 * 예를 들어 10번째 값을 구하려한다면
 * 8번째 이전으로 역순하게 되면 해당 값의 반댓값이 나온다. 이를 반대로 구해주면 값이 나온다 그렇기 때문에
 *
 * 1에서 빼주는 것이다.
 *
 * 메모리 : 11520
 * 시간 : 76
 */
public class BOJ_18222_투에모스문자열 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static long[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        long k = Long.parseLong(br.readLine().trim());

        // 64번째 때 long의 범위를 넘어선다.
        arr = new long[65];

        arr[0] = 1;

        for (int i = 1; i < 65; i++) {
            arr[i] = arr[i-1]*2;
        }

        System.out.println(solution(k));
    }

    private static long solution(long k) {
        if(k == 1) return 0;
        for (int i = 0; i < 65; i++) {
            if(k <= arr[i]){
                return 1 - solution(k - arr[i-1]);
            }
        }
        return 0;
    }
}