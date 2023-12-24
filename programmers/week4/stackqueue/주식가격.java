package programmers.week4.stackqueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * 0
 *
 * prices[1] < prices[0]
 *
 * 1
 * 0
 *
 * prices[2] < prices[1]
 * 3 < 2
 *
 * 2
 * 1
 * 0
 *
 * prices[3] < prices[2]
 * answer[stack.peek()] = i - stack.peek();
 * answer[2] = 3 - 2
 *
 * 3
 * 1
 * 0
 *
 * prices[4] < prices[3]
 *
 * 4
 * 3
 * 1
 * 0
 *
 * answer[4] = 5 - 4 - 1 = 0
 * answer[3] = 5 - 3 - 1 = 1
 * answer[1] = 5 - 1 - 1 = 3
 * answer[0] = 5 - 0 - 1 = 4
 *
 * answer = {4,3,1,1,0}
 *
 * 1. for문으로 0 -> prices.length까지 i를 증가시킨다. 여기서 i는 day라고 볼 수 있다.
 *
 * 0번째 day부터 시작한다.
 *
 * stack이 비어있을 때는 다음 가격과 비교할 수 없으므로 stack에 담는다.
 *
 * 만약 현재 날짜보다 전 날짜의 가격이 더 낮다면 해당 날짜의 값을 현재 날짜 - 전 날짜로 계산한다.
 * 그리고 전 날짜를 stack에서 제거한다.
 *
 * 그리고 현재 날짜를 stack에 담는다.
 *
 * 이 과정을 prices.length만큼 모두 반복했다면
 *
 * stack에 담긴 값들을 하나씩 pop한다.
 * 이때 prices.length - 현재 날짜 - 1을 해준다.
 *
 * stack에 담긴 값들은 가격이 떨어지지 않은 가격들이기 떄문이다.
 *
 * -1을 해주는 이유는 최대로 나올 수 있는 가격이 prices.length-1이기 때문에 반드시 -1을 해줘야 한다.
 * */
public class 주식가격 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};

        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        // 가격이 떨어지는 경우를 answer 배열에 담아주는 과정
        for (int i = 0; i < prices.length; i++) {
            // 현재 날짜보다 이전 날짜 가격이 더 적을 경우
            // answer[현재날짜] = 현재 날짜 - 이전 날짜
            // 가격이 떨어진 경우 결과가 바로 나왔으므로 stack에서 제거해준다.
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            // 현재 날짜를 담아준다.
            stack.push(i);
        }

        // 한번도 가격이 떨어지지 않은 가격들은 전체 가격들의 개수에서 해당 날짜를 빼준다
        // 최대로 나올 수 있는 떨어지지 않은 기간은 prices.length-1이므로 -1을 반드시 해줘야 한다.
        while(!stack.isEmpty()){
            answer[stack.peek()] = prices.length-stack.pop()-1;
        }

        System.out.println(Arrays.toString(answer));
    }
}
