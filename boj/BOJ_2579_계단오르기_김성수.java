package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class BOJ_2579_계단오르기_김성수 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int stairsCnt = Integer.parseInt(br.readLine().trim());

        int[] stairs = new int[stairsCnt + 1];

        for (int i = 1; i <= stairsCnt; i++) {
            stairs[i] = Integer.parseInt(br.readLine().trim());
        }

        int[] dp = new int[stairsCnt + 1];

        dp[1] = stairs[1];

        for (int i = 2; i <= stairsCnt; i++) {
            if(i==2){
                dp[2] = stairs[1] + stairs[2];
            }else if(i==3){
                dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
            }else{
                // 한칸을 움직였을 때 vs 두 칸을 움직였을 때 더 큰 값을 dp에 저장
                dp[i] = Math.max(dp[i-3]+stairs[i-1], dp[i-2])+stairs[i];
            }
        }
        // 마지막 계단은 반드시 밞아야 하므로 마지막 계단을 올랐을 때를 출력하는게 최댓값이다
        System.out.println(dp[stairsCnt]);
    }
}
