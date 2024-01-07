package programmers.week6.graph;

/**
 1번 노드로부터 가장 멀리 떨어진 노드가 몇개인지를 return 하시오.

 1에서 n 노드로 이동하는 최단 경로를 어떻게 구할 것인가?
 BFS?

 1. 최단 경로는 BFS로 구한다.
 2. maxCnt를 저장하는 변수를 생성
 3. HashMap으로 각 노드별 최단 경로 저장
 4. maxCnt와 동일한 값을 가지는 map 값을 만날 때마다 answer를 더해준다.
 */
public class 가장먼노드 {
    /*
    import java.util.*;

class Solution {
    static int maxCnt; // 최대 간선 수
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static HashMap<Integer, Integer> map; // 간선의 정보와 최단 경로를 저장할 map

    static void bfs(){
        Queue<Integer> que = new ArrayDeque<>();

        que.offer(1);
        int level = 1;
        visited[1] = true;

        while(!que.isEmpty()){
            int len = que.size();
            maxCnt = Math.max(maxCnt, level);
            for(int i = 0; i < len; i++){
                int curNode = que.poll();

                for(int j = 0; j < graph.get(curNode).size(); j++){
                    int nextNode = graph.get(curNode).get(j);
                    if(visited[nextNode]) continue;
                    visited[nextNode] = true;
                    que.offer(nextNode);
                    map.put(nextNode, level);
                }
            }
            level++;
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;

        graph = new ArrayList<>();

        // graph 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        maxCnt = 0;
        map = new HashMap<>();

        visited = new boolean[n+1];

        for(int i = 1; i <= n; i++){
            map.put(i,0);
        }

        bfs();

        // System.out.println(map.toString());

        // for(int i = 1; i <= n; i++){
        //     System.out.println(graph.get(i).toString());
        // }

        // System.out.println(maxCnt);

        for(int value : map.keySet()){
            if(map.get(value) == maxCnt-1){
                answer++;
            }
        }

        return answer;
    }
}
     */
}
