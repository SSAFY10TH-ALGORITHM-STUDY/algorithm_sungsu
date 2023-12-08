package boj.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 오름차순 PQ(최대 힙), 내림차순 PQ사용(최소 힙).
 * 최대 힙의 peek() 값을 뽑으면 최솟 값을 얻을 수 있고, 최소 힙의 peek() 값을 뽑으면 최댓 값을 얻을 수 있다.
 * 최대 힙과 최소 흽의 개수를 1개 차이가 나도록 유지하면 1개가 많은 힙의 최솟값 또는 최댓값이 중앙값이 되게 된다.
 *
 * 그렇다면 두 힙에 데이터를 어떤 식으로 넣어야 할 지가 중요한 포인트가 된다.
 * 최대 힙의 최솟값과 최소힙의 최댓값이 더 크다면 두 값을 바꿔 추가함으로써 값을 조정할 수 있다.
 *
 * 크게 세 과정이 필요하다.
 *
 * 1. 입력 받은 값이 홀수번째일때는 maxPQ에, 짝수번째일 때는 minPQ에 값을 담는다.
 * 2. 만약 maxPQ에 담긴 peek() 값이 minPQ에 담긴 peek()값보다 작다면 두 수를 교환한다.
 * 3. 홀수번째 입력받는 타이밍에 maxPQ peek() 값을 출력에 담아준다.
 *
 */
public class BOJ_2696_중앙값구하기_김성수 {

    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 0; tc < T; tc++) {
            int sequenceSize = Integer.parseInt(br.readLine().trim());

            sb.append(sequenceSize/2+1+"\n");

            // 최소 힙과 최대 힙 초기화
            // 최소 힙은 내림차순, 최대 힙은 오름차순으로 정렬하여 중앙값을 접근할 수 있도록 한다.
            PriorityQueue<Integer> minPQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>();

            int cnt = 0; // 한 줄에 10개씩 출력하기 위해.

            for (int i = 0; i < sequenceSize; i++) {
                // 입력 시 한 줄에 10개 입력
                if(i%10 == 0) st = new StringTokenizer(br.readLine().trim());
                int value = Integer.parseInt(st.nextToken());

                // 1
                // 두 힙의 사이즈가 같을 경우 : 이번에 추가될 수가 홀수번째 라는 의미 -> 최대 힙에 저장
                // 두 힙의 사이즈가 다를 경우 : 반대로 이번에 추가될 수가 짝수번째 라는 의미 -> 최소 힙에 저장.
                if(minPQ.size() == maxPQ.size()) maxPQ.add(value);
                else minPQ.add(value);


                // 2
                // 값이 입력될 때마다 최소 힙의 최댓값과 최대 힙의 최솟값과 비교한다.
                // 최소 힙의 최댓값이 최대 힙의 최솟값보다 크다면
                // 서로 다른 힙에 저장된 값이므로 교환한다.
                if(!minPQ.isEmpty() && !maxPQ.isEmpty()){
                    if(minPQ.peek() > maxPQ.peek()){
                        int tmp = maxPQ.poll();
                        maxPQ.add(minPQ.poll());
                        minPQ.add(tmp);
                    }
                }

                // 3
                // 홀수 번째 수를 읽을 때마다 중앙값 출력
                // 이 때 최대 힙을 기준으로 값을 추가했기 때문에
                // 최대 힙의 최솟값이 중앙값이 된다.
                if(i%2==0){
                    sb.append(maxPQ.peek()+" ");

                    cnt++;

                    if(cnt%10==0) sb.append("\n");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
