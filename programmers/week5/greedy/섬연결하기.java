package programmers.week5.greedy;

/**
 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 구하시오.

 그리디는 정렬을 사용해야하는편.

 어떻게 정렬을 할 것인가?
 무엇을 기준으로 할 것인가?

 [0,1,1],[1,3,1][0,2,2],[1,2,5],[2,3,8]

 싸이클 방지 필요(같은 부모를 가지고 있다면 union 된 상태이므로 continue)
 */
public class 섬연결하기 {
    /*
    import java.util.*;

class Solution {

    static int find(int[] parent, int node){
        if(parent[node] == node) return node;
        return find(parent, parent[node]);
    }

    static void union(int[] parent, int start, int arrive){
        int child1 = find(parent, start);
        int child2 = find(parent, arrive);

        if(child1 < child2){
            parent[child2] = child1;
        }else{
            parent[child1] = child2;
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;

        // 세 번째 열(인덱스 2)을 기준으로 costs 배열을 정렬
        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));

        int[] parent = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < costs.length; i++){
            int start = costs[i][0];
            int arrive = costs[i][1];
            int cost = costs[i][2];

            // 집합에 포함된 경우 = 서로 같은 부모 값을 가지는 경우 continue
            if(find(parent, start) == find(parent, arrive)) continue;

            answer += cost;
            union(parent, start, arrive);
        }

        return answer;
    }
}
     */
}
