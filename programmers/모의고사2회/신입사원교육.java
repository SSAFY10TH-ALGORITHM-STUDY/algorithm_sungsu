package programmers.모의고사2회;

/**
 정렬중에서 두개의 수를 뽑아야 한다.
 ability의 길이가 백만이니까 완탐은 불가능.
 매번 정렬하면 될 것 같은데 ? 시도해보자.
 시간 초과 발생.

 정렬하는 것 자체가 반복 수행이 많을 수 밖에 없긴 함.
 전체를 정렬하지 말고 a + b를 더한 값보다 작은 값이 있는 부분이 있다면 위치를 변경해주는 방식 사용해보자

 PriorityQueue를 사용하면 시간 복잡도 문제 해결된다.
 */
public class 신입사원교육 {
    /*

import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : ability){
            pq.offer(num);
        }


        for(int i = 0; i < number; i++){
            int sum = pq.poll() + pq.poll();
            pq.offer(sum);
            pq.offer(sum);
        }

        int len = pq.size();
        for(int i = 0; i < len; i++){
            answer += pq.poll();
        }

        return answer;
    }
}
     */
}
