package boj.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * N개의 도시가 있다. 한 도시에서 출발해서 다른 도시에 도착하는 버스가 M개 있다.
 * A는 시작도시, B는 도착도시, C는 버스를 타고 이동하는데 걸리는 시간이다.
 * 시간 C가 양수가 아닌 경우가 있다. C = 0인 경우는 순간 이동을 하는 경우,
 * C < 0인 경우는 타임머신으로 시간을 되돌아가는 경우이다.
 *
 * -> 방향 그래프, 가중치 존재, 음의 가중치 존재.
 * => 음의 가중치가 존재하므로 다익스트라 알고리즘을 사용할 수 없다.
 * 왜냐하면 음수 간선의 순환이 발생하게 되면 최단 거리가 음의 무한인 노드가 발생한다.
 * 다익스트라의 경우 현재 정점에서 최단 경로를 계속해서 갱신하기 때문에 음의 가중치가 존재할 경우 무한으로 음의 가중치를 구하게 된다.
 *
 * 1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간을 구하는 프로그램을 작성하시오.
 *
 * - 만약 1번 도시에서 출발해 어떤 도시로 가는 과정에서 시간을 무한히 오래 전으로 되돌릴 수 있다면 첫째 줄에 -1을 출력,
 * => 음의 사이클이 존재하는 그래프라면, -1을 출력하라.
 * => 음의 사이클이 존재하게 되면, 특정 노드에 가는데 걸리는 시간을 무한히 작게 만들 수 있다.
 *
 * - 그렇지 않다면 1번 도시에서 2 ~ N번 도시로 가는 가장 빠른 시간을 순서대로 출력
 *
 * - 만약 해당 도시로 가는 경로가 없다면 -1을 출력.
 *
 * 사용 가능한 알고리즘 : 벨만-포드 알고리즘
 *
 * 벨만-포드 알고리즘이란?
 * 음수 간선이 포함된 최단 거리 문제를 풀이할 때 적합한 알고리즘.
 *
 * 각 정점까지의 최단경로 길이를 반복적으로 업데이트 하는 방식이다.
 * 음의 가중치가 있는 경우 이를 감지하고 각 라운드에서 모든 간선을 확인하는 방식을 사용한다.
 *
 * 벨만포드의 기본 시간 복잡도는 O(VE)로 다익스트라보다 느리다.
 *
 * 벨만-포드 알고리즘 동작 원리
 * 1. 출발 노드를 설정한다.
 * 2. 최단 거리 테이블을 초기화한다.
 * 3. 다음의 과정을 N-1번 반복한다.
 *  3-1. 전체 간선 E개를 하나씩 확인한다.
 *  3-2. 각 간선을 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다.
 *
 * 만약 음수 간선 순환이 발생하는지 체크하고 싶다면 3번의 과정을 한 번 더 수행한다.
 *  이때 최단 거리 테이블이 갱신된다면 음수 간선이 존재하는 것이다.
 *
 * 음의 사이클이 발생하여 음수 값이 너무 크게 되면 오버플로우가 발생하면서 양수로 넘어가게 되고
 * 이때 음의 사이클이 발생하지 않은 것으로 판단할 수 있으므로 주의해야 한다.
 * 따라서 int형이 아닌 long형을 사용해야 한다.
 */
public class BOJ_11657_타임머신 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int cityCnt, edgeCnt;
    static final int INF = 987654321;


    static class City{
        int vertex;
        int distance;

        public City(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    static ArrayList<ArrayList<City>> graph;

    // 최단 거리를 기록할 리스트.
    static long[] dist;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine().trim());

        cityCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(); // 인접 리스트

        dist = new long[cityCnt+1]; // 최단거리 리스트

        for (int i = 0; i <= cityCnt; i++) {
            graph.add(new ArrayList<>());
            dist[i] = INF;
        }

        // 인접리스트 초기화
        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new City(vertex2,distance));
        }

        if(solution()) sb.append("-1\n"); // 음수 사이클이 발생한 것이므로 -1 출력
        else{
            // 시작정점 1번에서 시작하므로 2부터 최단 경로 출력
            for (int i = 2; i <= cityCnt; i++) {
                if(dist[i] == INF){
                    sb.append("-1\n"); // 도착 경로가 존재하지 않는 것이므로 -1 출력
                }else{
                    sb.append(dist[i]+"\n");
                }
            }
        }

        System.out.println(sb);
    }

    /*
    벨만포드 알고리즘 메서드
     */
    private static boolean solution() {
        dist[1] = 0; // 시작 정점은 1번, 0으로 초기화
        boolean flag = false;

        // cityCnt-1번 동안 최단거리 초기화 작업을 반복한다.
        /**
         * 벨만-포드 알고리즘에서 간선을 최대 cityCnt - 1번 확인하는 이유는, 최단 거리를 찾아내기 위해 각 정점까지의 경로는 최대
         * N−1개의 간선을 포함할 수 있기 때문 그 이상의 간선을 사용하는 경우 음의 사이클이 존재한다는 의미이다.
         */
        for (int i = 1; i < cityCnt; i++) {
            flag = false;

            // 최단거리 초기화
            // 다익스트라와 다르게 각 정점마다 최단 경로를 찾아나가면서 최단 경로를 갱신한다. 따라서 시간복잡도에서 더 오래 걸린다.
            for (int j = 1; j <= cityCnt; j++) {
                for (City city : graph.get(j)) {
                    // 현재 정점에 최단 경로가 저장되지 않았을 경우 break.
                    if(dist[j] == INF){
                        break;
                    }

                    // 최단 거리 경로 저장
                    if(dist[city.vertex] > dist[j]+city.distance){
                        dist[city.vertex] = dist[j]+city.distance;
                        flag = true;
                    }
                }
            }

            // 더이상 최단거리 초기화가 일어나지 않았을 경우 반복문을 종료
            if(!flag){
                break;
            }
        }

        // 음의 사이클 확인하기
        // cityCnt-1번까지 계속 업데이트가 된 경우
        if(flag){
            for (int i = 1; i <= cityCnt; i++) {
                for (City city : graph.get(i)) {
                    if(dist[i] == INF){
                        break;
                    }

                    // 이미 위에서 최단 경로를 구했음에도 불구하고 다시 최단 경로를 구하는 작업을 반복한다면 음의 사이클이 반복되는 것이기 때문에 return true해준다.
                    if(dist[city.vertex] > dist[i] + city.distance){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
