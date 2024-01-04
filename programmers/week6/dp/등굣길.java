package programmers.week6.dp;

/**
 오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단 경로의 개수를
 1,000,000,007(10억7)로 나는 나머지를 return 하시오

 왜 10억 7로 나눈 나머지를 구하는거임..?;;

 그냥 bfs로 풀 수 있는거 아님..?(x)
 -> 최단 경로의 개수를 구하는 문제이므로 단순 bfs로만 풀 수는 없음

 오른쪽 or 아래로만 이동할 수 있으므로 학교까지 가는 모든 루트가 최단거리가 될 수 밖에 없다.

 모든 가능한 경로의 개수를 구해야한다.

 오른쪽, 아래가 아닌 위쪽, 왼쪽으로 역으로 생각해서 dp를 적용해야 한다.


 dp 점화식

 위쪽(row == 0)일 때 위로 이동 불가능하므로
 if(row != 0){
 dp[row][col] += dp[row-1][col];
 }

 왼쪽(col == 0)일 때 왼쪽으로 이동 불가능하므로
 if(col != 0){
 dp[row][col] = dp[row][col-1];
 }

 */
public class 등굣길 {
    /*
    import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;

        int[][] dp = new int[n][m];

        for(int i = 0; i < puddles.length; i++){
            int a = puddles[i][1];
            int b = puddles[i][0];

            dp[a-1][b-1] = -1;
        }

        dp[0][0] = 1;

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(dp[row][col] == -1){
                    dp[row][col] = 0;
                    continue;
                }

                // 위쪽
                if(row != 0){
                    dp[row][col] += dp[row-1][col] % mod;
                }


                // 왼쪽
                if(col != 0){
                    dp[row][col] += dp[row][col-1] % mod;
                }
            }
        }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return dp[n-1][m-1] % mod;
    }
    }
     */
}
