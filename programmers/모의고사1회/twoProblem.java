package programmers.모의고사1회;

/**
 당신의 반 학생들의 각 종목에 대한 능력치를 나타내는 2차원 정수 배열 ability가 주어졌을 때 선발된 대표들의
 해당 종목에 대한 능력치 합의 최댓값을 return 하는 solution 함수를 완성하시오.

 한 학생은 최대 한개의 종목 대표만 할 수 있다.

 A : 20 30 20
 B : 30 20 30

 완탐으로 풀 수 있나?

 뽑힌 친구는 visited 처리해서 다신 못뽑게 하고 완탐?
 20 , 30
 20, 20
 20, 30
 30, 30
 30, 20
 30, 30
 ...
 20, 30

 백트래킹 문제같은데..?

 */
public class twoProblem {
    /*
    import java.util.*;

class Solution {

    static boolean[] visited; // 뽑힌 학생
    static boolean[] colVisited; // 뽑힌 종목
    static int result;

    public void dfs(int depth, int[][] ability, int sum){
        int len = ability.length;

        if(depth == len){
            result = Math.max(result, sum);


            // System.out.println(result);
            // System.out.println();
            return;
        }

        for(int row = 0; row < len; row++){
            for(int col = 0; col < ability[row].length; col++){
                if(visited[row] || colVisited[col]) continue;
                sum += ability[row][col];
                visited[row] = true;
                colVisited[col] = true;
                // System.out.print(ability[row][col] + " ");
                dfs(depth+1, ability, sum);
                visited[row] = false;
                colVisited[col] = false;
            }
        }
    }

    public int solution(int[][] ability) {
        int answer = 0;

        int len = ability.length;

        int[][] tmp = {{20,30}, {30,20},{20,30}};

        visited = new boolean[len];
        colVisited= new boolean[ability[0].length];

        result = Integer.MIN_VALUE;

        dfs(0, tmp, 0);
        return result;
    }
}
     */
}
