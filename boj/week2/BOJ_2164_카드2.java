package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * * 문제 풀이
 * 1. Queue를 사용하여 첫번째 수는 버리고 두번째 수는 뒤에 담는다.
 * 2. 1번 과정을 que size가 0이 될때까지 반복한다.
 * 3. 마지막으로 꺼낸 값을 출력한다.
 *
 * 메모리 : 31892KB
 * 시간 :  144MS
 */
public class BOJ_2164_카드2 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine().trim());

        Queue<Integer> que = new ArrayDeque<>();

        for (int i = 1; i <= num; i++) {
            que.offer(i);
        }

        int answer = 0;

        while(!que.isEmpty()){
            int first = que.poll();
            if(que.size() == 0) {
                answer = first;
                break;
            }
            int second = que.poll();
            if(que.size() == 0) {
                answer = second;
                break;
            }
            que.offer(second);
        }

        System.out.println(answer);
    }
}