package programmers.week6.binarysearch;

/**
 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return

 n 또는 times에 담길 수 있는 값이 10억부터이므로 int형 보다는 long형을 쓰는게 적합하다.

 이분탐색을 어떻게 적용할 것인가?

 통과 시간을 기준으로 적용한다.

 통과 시간을 최소와 최대 두개로 두고 이분탐색을 통해서 통과시간을 탐색 범위를 좁혀나간다.

 좁혀진 통과시간은 (최소 + 최대) / 2 즉, mid라고 했을 때

 mid 값을 입국 심사관의 시간 만큼 나누었을 때

 각각의 임국 심사관이 통과시키는 사람 수를 구할 수 있다.

 그렇게 mid 통과 시간 값의 통과 인원수와 주어진 n을 비교했을 때
 만약 통과 인원수가 더 크거나 n과 같다면 통과한 인원이 더 많다는 의미이므로
 통과 시간을 줄일 수 있고 이때 이분 탐색을 반복할 수 있다.
 만약 반대로 n명보다 적은 수를 통과시켰다면 해당 통과시간이 부족하다는 의미이므로
 더 큰 범위에서 탐색을 해야 한다.

 이렇게 이분 탐색을 반복하면
 최종적으로 최소 통과 시간을 구할 수 있게 된다는 원리이다.

 참고 링크 : [https://geunzrial.tistory.com/39]
 */
public class 입국심사 {
    /*
    import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        int len = times.length;

        long leftPoint = times[0]; // 최소 통과 시간

        long rightPoint = (long)times[len-1]*n; // 최대 통과 시간

        while(leftPoint <= rightPoint){
            long passPersonCnt = 0;
            long middlePoint = (leftPoint + rightPoint)/2;
            for(int time : times){
                passPersonCnt += middlePoint / time;
            }

            if(passPersonCnt >= n){
                rightPoint = middlePoint - 1;
                answer = middlePoint;
            }else{
                leftPoint = middlePoint + 1;
            }
        }


        return answer;
    }
}
     */
}
