package programmers.week4.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 소요시간 - 작업이 요청되는 시간
 * 작업의 요청부터 종료까지 걸린 시간이 평균을 가장 줄이는 방법으로 처리하면
 * 평균이 얼마나 되는지 return 하도록 함수를 작성해주세요.
 * (단, 소수점 이하의 수는 버린다.)
 *
 * * 문제 풀이
 * 현재 시점에서 처리할 수 있는 작업들을 힙에 넣고.
 * 하나를 뽑아 현재 시점과 총 대기시간을 구해주는 것을 모든 작업을 처리할 때까지 반복한다.
 *
 * 힙에 push할 때는 작업의 소요 시간을 기잔으로 최소힙이 만들어져야하기 때문에
 * jobs의 요소를 그대로 넣지 않고 [작업의 소요 시간, 작업이 요청되는 시점]으로 요소를
 * 앞 뒤를 바꿔서 넣어준다.
 *
 * 현재 시점에서 처리할 수 있는 작업인지를 판별하는 조건은 작업의 요청 시간이 바로 이전에
 * 완료한 작업의 시작 시간보다 크고 현재 시점보다 작거나 같아야 한다.
 *
 * 만약 현재 처리할 수 있는 작업이 없다면, 남아 있는 작업들의 요청 시간이 아직 오지 않은
 * 것이기 때문에 현재 시점을 하나 올려준다.
 *
 * -> 현재 처리해야할 프로세스가 전혀 없다면(pq에 아무런 값이 담겨있지 않다면 요청시간이 가장 적은 녀석을 end에 담아준다.)
 *  -> 왜? "하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터
 *   처리해야하기 때문이다.)
 *
 * -> pq에는 요청 시간이 바로 이전에 완료한 작업의 요청시간보다 커야하고 현재 시점 값보다 작거나 같아야 한다.
 *  -> 그래야 평균값이 최솟값이 되기 때문에.
 *
 * -> pq에서 값을 뽑았다면 total에는 처리시간 + 현재 시간 - 요청시간을 해준다.
 * -> 현재 시간은 처리시간 + 현재시간이 될 것이다.
 * -> 위 과정을 주어진 프로세스의 수만큼 반복해야 한다.
 */
public class 디스크컨트롤러 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int solution(int[][] jobs){
        int total = 0; // 총 더해진 값
        int curValue = 0; // 현재 시간
        int index = 0; // 프로세스 인덱스
        int count = 0;

        // jobs 요청 시간 오름 차순
        Arrays.sort(jobs,(o1, o2) -> o1[0] - o2[0]);

        // jobs 처리 시간 오름차순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);

        while(count < jobs.length){

            // 하나의 작업이 완료되는 시점(curValue)까지 들어온 모든 요청을 큐에 넣는다.
            while(index < jobs.length && jobs[index][0] <= curValue){
                pq.offer(jobs[index++]);
//                int len = pq.size();
//                for (int i = 0; i < len; i++) {
//                    int [] value = pq.poll();
//                    System.out.print(value[0] + " " + value[1] + " ");
//                    pq.offer(value);
//                }
//                System.out.println();
            }

            // 만약 현재 처리할 수 있는 작업이 없다면, 남아 있는 작업들의 요청 시간이 아직 오지 않은것이기 때문에 현재 시점을 하나 올려준다
            if(pq.isEmpty()){
                curValue = jobs[index][0];

            } // 작업이 끝나기 전(curValue 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
            else{
                int[] value = pq.poll();

                // 처리 시간 + 현재 시간 - 요청 시간
                total += value[1] + curValue - value[0];

                // 현재 시간 += 처리 시간
                curValue += value[1];

                count++;
            }
        }

        return (int)Math.floor(total/ jobs.length);
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int[][] jobs = {{0,3}, {1,9}, {2,6}};

        System.out.println(solution(jobs));
    }
}
