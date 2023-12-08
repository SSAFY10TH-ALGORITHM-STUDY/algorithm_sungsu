package boj.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 임시 파일을 만드는데 필요한 비용 : 두 파일 크기를 더한다.
 * 최종 파일을 만드는데 필요한 비용 : 150
 *
 * 파일들을 하나로 합칠 때 필요한 최소 비용을 계산하라.
 *
 * 1. 우선순위 큐로 입력받은 정수를 오름차순 한다.
 * 2. 두 수를 꺼내어 더 한 뒤에 que에 넣는 것을 K-1번 반복한다.
 * 3. 최종 결과 answer는 1,000,000 x 10,000을 했을 때 값이 정수형 범위를 넘어서므로 long으로 형변환이 필요하다.
 */
public class BOJ_13975_파일합치기3 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < T; i++) {
            PriorityQueue<Long> que = new PriorityQueue<>();

            int numCnt = Integer.parseInt(br.readLine().trim());

            st = new StringTokenizer(br.readLine().trim());

            for (int j = 0; j < numCnt; j++) {
                que.offer(Long.parseLong(st.nextToken()));

            }
            Long answer = (long)0;

            for (int j = 0; j < numCnt-1; j++) {
                long a = que.poll();
                long b = que.poll();
                answer += a + b;
                que.add(a + b);
            }

            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}
