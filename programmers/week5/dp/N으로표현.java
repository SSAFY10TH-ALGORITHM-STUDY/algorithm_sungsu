package programmers.week5.dp;

/**
 N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 구하시오
 */
public class N으로표현 {
    /*
    import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;

        if(N == number) return 1;

        ArrayList<HashSet<Integer>> dp = new ArrayList<>();

        for(int i = 0; i <= 8; i++){
            dp.add(new HashSet<>());
        }

        // N이 1개일 때 가능한 수는 N뿐이므로 N을 넣어준다.
        dp.get(1).add(N);

        // 2 ~ 8까지 표현할 수 있는 N을 찾는다.
        // 만약 찾는다면 return i
        for(int i = 2; i <= 8; i++){

            // N의 개수에 따라 수가 이어붙여졌을때 값을 dp.get(i)에 담는다.
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < i; j++){
                sb.append(N);
            }

            dp.get(i).add(Integer.parseInt(sb.toString()));

            // dp.get(i)에 담기는 값은 dp.get(i)와 dp.get(i-j)과의 모든 사칙연산 결과이다.
            for(int j = 1; j < i; j++){
                int k = i-j;
                for(int num1 : dp.get(j)){
                    for(int num2 : dp.get(k)){
                        // System.out.println(num1 + " " + num2);
                        dp.get(i).add(num1+num2);
                        dp.get(i).add(num1-num2);
                        dp.get(i).add(num1*num2);
                        if(num2 == 0) continue;
                        dp.get(i).add(num1/num2);
                    }
                    // System.out.println("-------");
                }
            }

            for(int value : dp.get(i)){
                if(value == number) return i;
            }
        }

        return -1;
    }
}
     */
}
