package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * * 참고 링크 : https://lackofwillpower.tistory.com/56
 *
 * * 문제 풀이
 * 1. 부분행렬을 구하기 위해선 (1,1) ~ (row,col)까지 더해야 한다.
 * 2. dp[][] 를 구할 때 부분 행렬로 구해야하므로 현재 원소 값 + 위칸 원소 값 - 대각선 원소 값 + 왼쪽 원소 ㄱ밧
 * 대각선 원소를 빼는 이유는 대각선 원소가 두번 더해지기 때문이다.
 *
 * 메모리 : 19016
 * 시간 : 816
 */
public class BOJ_1749_점수따먹기 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine().trim());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] map = new int[height+1][width+1];
        int[][] dp = new int[height+1][width+1];

        for (int row = 1; row <= height; row++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int col = 1; col <= width; col++) {
                int value = Integer.parseInt(st.nextToken());
                map[row][col] = value;
                // 부분 행렬 누적합 구하는 dp 배열
                dp[row][col] = dp[row][col-1] + dp[row-1][col] - dp[row-1][col-1] + value;
            }
        }

        int answer = Integer.MIN_VALUE;

        for(int rowStart = 1; rowStart <= height; rowStart++){
            for (int rowEnd = rowStart; rowEnd <= height ; rowEnd++) {
                for (int colStart = 1; colStart <= width ; colStart++) {
                    for (int colEnd = colStart; colEnd <= width ; colEnd++) {
                        // 부분 행렬에서 포함되지 않는 부분을 제거해준다. 그리고 왼쪽위 대각선 값이 두번 빼지므로 한번 더해준다.
                        answer = Math.max(answer, dp[rowEnd][colEnd] - dp[rowEnd][colStart-1] - dp[rowStart-1][colEnd] + dp[rowStart-1][colStart-1]);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}