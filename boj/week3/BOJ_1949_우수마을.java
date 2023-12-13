package boj.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * 참고 블로그 : https://lotuslee.tistory.com/96
 *
 * 1. 우수 마을로 선정된 마을 주민 수의 총 합을 최대로 해야 한다.
 * 2. 우수 선정된 마을과 인접해있는 마을은 우수 마을이 될 수 있다.
 * 3. 우수마을로 선정되지 못한 마을은 적어도 하나의 우수 마을과 인접해 있어야 한다.
 *
 * 트리에서 다이나믹 프로그래밍을 이용하여 푸는 문제이다.
 * dfs 방식으로 루트노드에서부터 리프노드까지 top-down으로 내려간 후, 다시 리프노드에서부터 위로 올라가면서
 * dp배열을 업데이트한다.
 *
 * dp 배열은 이차원 배열로 생상하여 n번 마을이 우수 마을인 경우와 그렇지 않은 경우로 나누었다.
 *
 * 우수 마을과 인접한 정점은 우수 마을이 될 수 없으므로
 * dp[우수마을][1] = dp[인접마을1][0] + dp[인접마을2][0] + .. + dp[자식노드m][0]이 된다.
 *
 * n번 정점이 우수 마을이 아닌 경우 자식 노드들의 부분집합으로 인구 수 합의 최댓값을 dp[n][0]에 담아준다.
 *
 * 메모리 : 21188
 * 시간 : 200
 *
 */
public class BOJ_1949_우수마을 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int[] populationList;

    static int townCnt;

    static int[][] dp;

    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args)  throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        townCnt = Integer.parseInt(br.readLine().trim());

        populationList = new int[townCnt+1];

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 1; i <= townCnt; i++) {
            populationList[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList<>();

        for (int i = 0; i <= townCnt; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < townCnt-1; i++) {
            st = new StringTokenizer(br.readLine().trim());

            int value1 = Integer.parseInt(st.nextToken());
            int value2 = Integer.parseInt(st.nextToken());

            graph.get(value1).add(value2);
            graph.get(value2).add(value1);
        }

        dp = new int[townCnt+1][2];

        solution(1,0);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    /**
     *
     * @param currentNode : 현재 정점
     * @param beforeNode : 바로 이전에 탐색했던 정점
     */
    private static void solution(int currentNode, int beforeNode) {

        for (int child : graph.get(currentNode)){
            if(child != beforeNode){
                solution(child, currentNode);
                // 현재 정점을 선택하지 않았을 때 인접 정점을 선택했을 경우와 선택하지 않았을 경우 중 최댓 값을 선택한다
                dp[currentNode][0] += Math.max(dp[child][0], dp[child][1]);
                // 현재 정점을 선택했을 때.
                // 인접 정점을 모두 선택하지 못한다.
                dp[currentNode][1] += dp[child][0];
            }
        }

        dp[currentNode][1] += populationList[currentNode];
    }
}
