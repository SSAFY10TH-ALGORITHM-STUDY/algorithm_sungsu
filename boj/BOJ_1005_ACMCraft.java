package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * 방향을 가지고, 사이클이 없다는 것에서 비순환 그래프 특성을 가진다.
 * 따라서, 위상정렬을 사용할 수 있다.
 *
 * 위상 정렬 : 각 정점이 나열될 수 있는 순서를 파악하기 위해 사용되는 알고리즘.
 *
 * 자료구조.
 * - 인접리스트 사용.
 *
 */
public class BOJ_1005_ACMCraft {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int buildingCnt;
    static int ruleCnt; // 건물간의 건설순서 규칙의 총 개수

    static int[] numList; // 가중치 값을 저장할 리스트

    static int[] indegree; // 위상정렬 리스트

    static int W; // 백준이가 승리하기 위해 건설해야 할 건물의 번호 W

    static ArrayList<ArrayList<Integer>> graph; // 인접리스트
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 0; tc < T; tc++) {

            st = new StringTokenizer(br.readLine().trim());

            buildingCnt = Integer.parseInt(st.nextToken());

            ruleCnt = Integer.parseInt(st.nextToken());

            numList = new int[buildingCnt+1];

            graph = new ArrayList<>();

            for (int i = 0; i <= buildingCnt; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine().trim());

            for (int i = 1; i <= buildingCnt; i++) {
                numList[i] = Integer.parseInt(st.nextToken());
            }

            indegree = new int[buildingCnt+1];

            for (int i = 0; i < ruleCnt; i++) {
                st = new StringTokenizer(br.readLine().trim());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                indegree[b]++; // 진입차수 기록
            }

            W = Integer.parseInt(br.readLine().trim());

            bfs();
        }
    }

    /**
     * W 건물이 건설되는데까지 최솟값을 구하는 메서드
     */
    private static void bfs() {
        Queue<Integer> que = new ArrayDeque<>();

        // 각 건물이 건설되는데 소요되는 시간을 저장하는 리스트
        int[] answer = new int[buildingCnt+1];

        // 건물의 기본 소요시간으로 초기화
        for(int i=1; i <= buildingCnt; i++){
            answer[i] = numList[i];

            // 진입차수가 0이라면 que에 담는다.
            if(indegree[i] == 0){
                que.offer(i);
            }
        }

        // 건물의 총 소요시간 = 이전까지의 소요시간 + 현재 건물 소요시간
        // Math.max 이유는 이전 건물이 모두 세워져야 현재 건물을 지을 수 있기 때문
        while(!que.isEmpty()){

            int cur = que.poll(); // 건설이 완료된 건물

            // 다음으로 지을 수 있는 건물을 짓는다.
            for(Integer num : graph.get(cur)){

                // 다음 건물을 지을 때 나올 수 있는 최댓값이 해당 건물의 건설 소요시간이 된다.(이전 건물이 모두 지어져야 한다는 조건 때문)
                answer[num] = Math.max(answer[num], answer[cur] + numList[num]);
                indegree[num]--;

                if(indegree[num] == 0){
                    que.offer(num);
                }
            }
        }

        System.out.println(answer[W]);
    }
}
