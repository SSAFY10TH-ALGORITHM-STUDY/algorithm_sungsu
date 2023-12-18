package boj.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * * 문제 해석
 * 가장 먼 곳은 선택할 집에서 거리가 가장 가까운 친구의 집까지를 거리를 기준으로 한다.
 * -> A,B,C에서 해당 집으로 이동하는 거리에서 가장 작은 값을 선택한다.
 * -> 이와 같은 방식으로 1 ~ N 번까지 최단 거리를 구한다.
 * <p>
 * X 위치에서 A,B,C의 집까지의 거리가 3,5,4이고
 * Y 위치에서 A,B,C 집까지의 거리가 5,7,2라면
 * <p>
 * X 위치에서 가장 가깝게 이동할 수 있는 위치는 3이고,
 * Y 위치에서 가장 가깝게 이동할 수 있는 위치는 2이다.
 * <p>
 * 이때 친구들의 집으로부터 땅 X와 Y 중 더 먼 곳은 땅 X가 된다.
 * 왜냐하면 X에서 가장 가까운 친구의 집까지의 거리는 3이기 때문에 Y의 2보다
 * 더 멀기 때문이다.
 * <p>
 * 즉, 1 ~ N번 까지의 최단 거리를 구한 상태에서 가장 먼 집을 찾으면 되는 문제이다.
 */
public class BOJ_22865_가장먼곳 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int[] friendHome;
    static ArrayList<ArrayList<Edge>> graph;
    static int vertexCnt;

    static int[] d1;
    static int[] d2;
    static int[] d3;

    static class Edge implements Comparable<Edge> {
        public int vertex;
        public int distance;

        public Edge(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        // 거리를 기준으로 오름차순으로 정렬한다.
        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        vertexCnt = Integer.parseInt(br.readLine().trim());

        friendHome = new int[3];

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < 3; i++) {
            friendHome[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList<>();

        for (int i = 0; i <= vertexCnt; i++) {
            graph.add(new ArrayList<>());
        }

        int edgeCnt = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new Edge(vertex2, distance));
            graph.get(vertex2).add(new Edge(vertex1, distance));
        }

        d1 = solution(friendHome[0]);
        d2 = solution(friendHome[1]);
        d3 = solution(friendHome[2]);

        // 가장 가까운 친구 집에서 가장 먼거리를 파악하기 위해 거기를 저장하는 변수
        int maxDistance = -1;

        // 가장 가까운 친구 집에서 가장 먼 거리를 가지는 집 X 값을 담는 변수
        int maxHome = -1;
        for (int i = 1; i <= vertexCnt; i++) {
            // 각 집에서 A,B,C 친구의 집을 이동할 때 가장 짧은 경로를 가지는 곳을 찾는다.
            int a = d1[i];
            int b = d2[i];
            int c = d3[i];

            // X 집에서 A,B,C 친구 중 가장 가까운 값을 min에 담아준다.
            int min = Math.min(a, b);
            min = Math.min(min, c);

            // 가장 먼 곳이 여러 곳일 경우 번호가 가장 작은 땅의 번호를 출력하도록 한다.
            if (maxDistance == min && maxHome > i) maxHome = i;
                // 가장 거리가 먼 곳을 maxDistance에 담아준다.
            else if (maxDistance < min) {
                maxDistance = min;
                maxHome = i;
            }
        }
        System.out.println(maxHome);
    }

    /**
     * 다익스트라 알고리즘을 사용하여 각 집에서 A,B,C로 가는 거리를 최단 경로를 구한다.
     *
     * @param start
     * @return
     */
    private static int[] solution(int start) {
        // 1 ~ N까지의 집들의 거리를 최댓값으로 초기화해놓는다,.
        int d[] = new int[vertexCnt + 1];
        Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            int curVertex = pq.peek().vertex;
            int curDistance = pq.peek().distance;
            pq.poll();

            // 최단경로를 구할 때 nextDistance + curDistance이기 때문에 curDistance가 d[curVertex]보다
            // 값이 높다면 조건에 부합하지 않으므로 continue한다.
            if (d[curVertex] < curDistance) continue;

            // A,B,C 각각의 집에서 i 집으로 향하는 최단 경로를 d 배열에 저장한다.
            for (int i = 0; i < graph.get(curVertex).size(); i++) {
                int nextVertex = graph.get(curVertex).get(i).vertex;
                int nextDistance = graph.get(curVertex).get(i).distance;

                // X 집으로 향하는 최단 경로를 d 배열에 저장한다.
                if (d[nextVertex] > nextDistance + curDistance) {
                    d[nextVertex] = nextDistance + curDistance;
                    pq.add(new Edge(nextVertex, nextDistance + curDistance));
                }
            }
        }
        return d;
    }
}