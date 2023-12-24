package programmers.week4.stackqueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 1,1,9,1,1,1
 * location = 0
 * 내림차순 정렬
 * 9,1,1,1,1,1
 *
 * p[2] = 9
 * pq.peek() = 9
 *
 * pq.poll()
 *
 * pq = 1,1,1,1,1
 *
 * p[3] = 1
 * pq.peek() = 1
 * pq.poll()
 * pq = 1,1,1,1
 *
 * p[4] = 1
 * ..
 * p[5] = 1
 * ..
 * pq = 1,1
 *
 * p[0] = 1
 * pq.peek() = 1
 * i == location -> return answer
 *
 * PriorityQueue는 Heap 정렬을 사용한다.
 * Heap 정렬은 '최대 힙' 또는 '최소 힙'이 존재한다.
 * Heap은 부모 노드와 자식 노드의 크기로 비교하여 정렬하는 방식이다.
 * 최대 힙은 부모 노드가 항상 자식 노드보다 크거나 같아야 하고
 * 최소 힙은 부모 노드가 항상 자식 노드보다 작거나 같아야 한다.
 *
 * 2,1,3,2 배열을 내림차순 pq에 담는다고 가정하면
 * 2를 우선순위 큐에 삽입: {2}
 * 1을 우선순위 큐에 삽입: {2, 1}
 * 3을 우선순위 큐에 삽입: {3, 2, 1}
 * 2를 우선순위 큐에 삽입: {3, 2, 2, 1}
 * 위와 같은 방식으로 값이 담기게 된다.
 *
 * 1,1,9,1,1,1 값을 pq에 담는다고 가정하면
 *
 * {1}
 * {1,1}
 * {9,1,1}
 * {9,1,1,1}
 * ...
 * {9,1,1,1,1,1}
 * 가 된다.
 *
 * [2,1,4,5,6,2]
 * location = 1
 *
 * 6,5,4,2,2,1
 * pq.poll()
 * pq = 5,4,2,2,1
 * answer = 1
 *
 * pq = 4,2,2,1
 * answer = 2
 *
 * p[2] =4
 * pq.peek() = 4
 * pq.poll()
 * answer = 3
 *
 * p[5] = 2
 * pq.peeK() = 2
 * pq.poll()
 * answer = 4
 *
 * pq = 2,1
 *
 * p[0] = 2
 * pq.peek() = 2
 * pq.poll()
 * answer = 5
 *
 * p[1] = 1
 * pq.peek() = 1
 * pq.poll()
 * answer = 6
 * i == location return answer
 *
 * answer = 6
 *
 * -> pq에서 주어진 location에 해당하는 값이 동일한 순서에 뽑힐 때 return 해준다.
 */
public class 프로세스 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int[] priorities = {2,1,4,5,6,2};
        int location = 1;

        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
        }

        boolean flag = false;

        while(!pq.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                if(priorities[i] == pq.peek()){
                    pq.poll();
                    answer++;
                    if(i == location) {
                        System.out.println(answer);
                        flag = true;
                        break;
                    }
                }
            }
            if(flag) break;
        }

    }
}
