package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * * 문제의 핵심
 * -> 얼리어답터가 아닌 사람들은 자신의 모든 친구들이 얼리 어답터일 때만 아이디어를 받아들인다.
 * 즉, 부모 정점이 얼리어답터일 때는 자식 정점이 얼리어답터일 수도 있고 아닐 수도 있다.
 * 하지만 부모 정점이 얼리어답터가 아닐 때는 모든 자식 정점이 반드시 얼리어답터야 한다.
 *
 * * 문제 풀이
 * 1. ArrayList를 사용하여 정점과 간선을 표현한다.
 * 2. 2차원 dp 배열을 생성하고 얼리어답터일 때와 얼리어답터가 아닐 때를 구분해서 최솟값을 저장한다.
 * 3. dfs를 사용해서 자식 정점부터 탐색한다.
 *
 * 메모리 : 409772KB
 * 시간 : 2152ms
 */
public class BOJ_2533_사회망서비스 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int vertexCnt;

    static ArrayList<ArrayList<Integer>> graph;

    static boolean[] visited;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        vertexCnt = Integer.parseInt(br.readLine().trim());

        graph = new ArrayList<>();

        for (int i = 0; i <= vertexCnt; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < vertexCnt-1; i++) {
            st = new StringTokenizer(br.readLine().trim());

            int vertexOne = Integer.parseInt(st.nextToken());

            int vertexTwo = Integer.parseInt(st.nextToken());

            graph.get(vertexOne).add(vertexTwo);
            graph.get(vertexTwo).add(vertexOne);
        }

        visited = new boolean[vertexCnt+1];

        dp = new int[vertexCnt+1][2];

        solution(1); // 1번 정점부터 시작

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void solution(int vertex) {
        visited[vertex] = true;

        dp[vertex][0] = 0; // 0 = 얼리어답터가 아닐 때
        dp[vertex][1] = 1; // 1 = 얼리어답터일 때

        for (int child : graph.get(vertex)){
            if(visited[child]) continue;
            solution(child);
            dp[vertex][0] += dp[child][1]; // 부모 노드가 얼리어답터가 아닐 때, 자식 노드는 반드시 얼리어답터야 한다.
            dp[vertex][1] += Math.min(dp[child][0], dp[child][1]);
        }
    }
}
