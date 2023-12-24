package programmers.week4.stackqueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 트럭이 정해진 순서로 건너야 한다.
 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 한다.
 * 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를
 * 견딜 수 있다.
 *
 * 7,4,5,6
 *
 * 7이 먼저 들어가고
 * 그 다음 수 4가 들어올 수 있는지를 체크한다.
 * 7 + 4를 했을 때 weight를 넘어서므로 들어오지 못하고 7 무게를 가지는 트럭이 다리를 건넌다.
 * 여기까지 2초
 * 4가 들어온다. 3초
 * 5가 들어올 수 있으므로 들어온다 4초
 * 6트럭은 bridge_length와 weight 모두 넘어서므로 당연히 못들어온다. 4 트력이 지나간다 5초
 * 5트럭이 지나간다 6초
 * 6트럭이 들어온다 7초
 * 6트럭이 지나간다 8초
 *
 * 1. weight보다 작을 때까지 들어간다.
 * 2. 더한 값이 weight를 넘어간다면 더하지 않는다.
 * 3. cnt 값이 truckLength보다 작다면 truckLength를 answer에 더해준다.
 * 4. 들어간 값이 truckLength이므로 나오는 값 +1 해준다.
 *
 * * 이해하기 어려운 부분
 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지를 파악하는 문제이다.
 *
 * answer + bridgeLength를 해주는 이유
 * bridgeLength를 초라고 생각해보자.
 * bridgeLength = 100은 다리의 길이가 100이라는 뜻이고 100초의 시간이 반드시 필요하다는 의미이다.
 * bridgeLength를 weight라고 생각하면 문제 풀이가 안된다.
 * 트럭의 무게가 몇이든간에 반드시 100초의 시간이 걸릴 수 밖에 없다.
 * 따라서 마지막 트럭이 다리에 입장한 시간 + bridgeLength를 해줘야 답이된다.
 *
 */
public class 다리를지나는트럭 {
    public static void main(String[] args) {

        int bridgeLength = 100;
        int weight = 100;
        int[] truckWeights = {10};

        int answer = 0;

        int idx = 0;
        int curWeight = 0;

        Queue<Integer> que = new ArrayDeque<>();

        for (int i = 0; i < bridgeLength; i++) {
            que.offer(0);
        }

        while(idx < truckWeights.length){
            int value = que.poll();
            curWeight -= value;
            answer++;
            if(curWeight + truckWeights[idx] <= weight){
                que.offer(truckWeights[idx]);
                curWeight += truckWeights[idx++];
            }else{
                que.offer(0);
            }
        }

        // 걸린 시간 + 마지막 트럭의 통과시간
        System.out.println(answer+bridgeLength);
    }
}
