package programmers.week5.graph;

/**
 정확하게 순위를 매길 수 있는 선수의 수를 구하라

 1 2 3 4 5
 1   1
 2         1
 3   1
 4   1 1
 5

 i < k
 j < k

 */
public class 순위 {
    /*
    import java.util.*;

class Solution {

    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] floyd = new int[n+1][n+1];

        for(int i = 0; i < results.length; i++){
            int a = results[i][0];
            int b = results[i][1];

            floyd[a][b] = 1;
            floyd[b][a] = -1;
        }

        // for(int i = 0; i < floyd.length; i++){
        //     System.out.println(Arrays.toString(floyd[i]));
        // }

        // 1 > 2, 2 > 5라면 1 > 5가 된다.
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(floyd[i][k] == 1 && floyd[k][j] == 1){
                        floyd[i][j] = 1;
                        floyd[j][i] = -1;
                    }

                    // i가 k한테 졌는데, k가 j한테 졌다면 i는 j한테 진다
                    if(floyd[i][k] == -1 && floyd[k][j] == -1){
                        floyd[i][j] = -1;
                        floyd[j][i] = 1;
                    }
                }
            }
        }

        // 승,패 관계가 확실한 경우가 n-1이라면 해당 선수는 순위를 알 수 있다.
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(floyd[i][j] != 0) cnt++;
            }
            if(cnt == n-1) answer++;
        }

        return answer;
    }
}
     */
}
