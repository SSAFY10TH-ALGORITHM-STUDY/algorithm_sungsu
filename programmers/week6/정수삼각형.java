package programmers.week6;

/**
 완탐으로 풀 시
 시간복잡도 : 2x(삼각형의높이!)
 최대 500일 때... 아주 큰 수가 나옴.
 따라서 dp를 사용해야함.
 (깊이 탐색만으로 답 찾는게 불가능)

 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.
 1번 행 ~ n번 행까지 더해나가면서 나올 수 있는 최댓값을 dp 배열에 담은 뒤에
 dp 배열의 마지막 인덱스 값을 출력해보자.(x)
 -> 다음 라인에서 나올 수 있는 최댓값이 다를 수 있기 때문에 옳지 않다.

 dp = bottomup + memoization
 */
public class 정수삼각형 {
    /*
    class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        int size = triangle.length;

        // 높이가 1이거나 2일 때 따로 처리
        if(size==1){
            return triangle[0][0];
        }else if(size == 2){
            return Math.max(triangle[1][0]+triangle[0][0],triangle[1][1]+triangle[0][0]);
        }

        int[][] dp = new int[size][size];

        // bottomup + memoization 방식이므로 맨 아래 값을 미리 dp에 담아둔다.
        for(int i = size-1; i <= size-1; i++){
            for(int j = 0; j < size; j++){
                dp[i][j] = triangle[i][j];
            }
        }

        // 올라가면서 최대로 나올 수 있는 수를 담는다.
        for(int i = size-2; i >= 1; i--){
            for(int j = 0; j < i+1; j++){
                    dp[i][j] = Math.max(dp[i+1][j]+triangle[i][j], dp[i+1][j+1]+triangle[i][j]);
            }
        }

        // 제일 꼭대기 값이 최댓값이 된다.
        dp[0][0] =  Math.max(dp[1][0]+triangle[0][0], dp[1][1]+triangle[0][0]);

        // for(int i = size-1; i >=1; i--){
        //     for(int j = 0; j < i+1; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return dp[0][0];
    }
}
     */
}
