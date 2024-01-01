package programmers.week5.greedy;

/**
 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.

 */
public class 구명보트 {
    /*
    import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int idx = 0;

        // 몸무게가 가장 많이 나가는 사람과 가장 적게 나가는 사람을 함께 태운다.
        for(int i = people.length-1; i >= idx; i--){

            // idx가 증가한다는 의미는 함께 탈 수 있는 인원이 증가함을 의미
            if(people[idx] + people[i] <= limit){
                idx++;
                answer++;
                continue;
            }

            // 가장 무게가 많이 나가는 사람 + 가장 적게 나가는 사람을 더했을 때 limit를 넘어선다면
            answer++;
        }

        return answer;
    }
}
     */
}
