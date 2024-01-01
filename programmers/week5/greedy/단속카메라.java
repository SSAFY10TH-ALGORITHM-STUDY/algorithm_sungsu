package programmers.week5.greedy;
/**
 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치해야 하는가?
 */
public class 단속카메라 {
    /*
    import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        // 종료시점을 기반으로 오름차순
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        int min = Integer.MIN_VALUE;

        for(int i = 0; i < routes.length; i++){

            // 시작 시점이 카메라가 설치된 시점보다 더 큰 수라면 카메라에 찍히지 않으므로 해당 시점의 종료 시점을 min에 담아준다.
            if(min < routes[i][0]){
                answer++;
                min = routes[i][1];
            }
        }

        return answer;
    }
}
     */
}
