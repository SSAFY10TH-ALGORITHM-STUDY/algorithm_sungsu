package boj.dummy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TEMP {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < T; i++) {
            int sequenceSize = Integer.parseInt(br.readLine().trim());

            PriorityQueue<Integer> maxPQ = new PriorityQueue<>();
            PriorityQueue<Integer> minPQ = new PriorityQueue<>(Collections.reverseOrder());

            sb.append(sequenceSize/2+1+"\n");

            int cnt = 0;

            for (int j = 0; j < sequenceSize; j++) {

                if(j%10==0) st = new StringTokenizer(br.readLine().trim());

                int value = Integer.parseInt(st.nextToken());

                // 1.
                if(maxPQ.size() == minPQ.size()) maxPQ.add(value);
                else minPQ.add(value);

                // 2.
                if(!maxPQ.isEmpty() && !minPQ.isEmpty()){
                    if(maxPQ.peek() < minPQ.peek()){
                        int tmp = maxPQ.poll();
                        maxPQ.add(minPQ.poll());
                        minPQ.add(tmp);
                    }
                }

                // 3.
                if(j%2==0){
                    sb.append(maxPQ.peek() + " ");

                    cnt++;

                    if(cnt % 10 == 0) sb.append("\n");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}