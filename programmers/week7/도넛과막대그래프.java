package programmers.week7;

/**
 도넛 : n개의 정점과 n개의 간선
 막대 : n개의 정점과 n-1개의 간선
 8자 : 2n+1개의 정점과 2n+2개의 간선

 임의의 생성한 정점?
 -> 들어오는 간선이 0개이면서 나가는 간선 수가 2 이상인 정점

 막대 : 들어오는 정점은 존재하지만 나가는 간선은 존재하지 않는 정점
 8자 : 나가는 간선이 2개 들어오는 간선이 2개인 정점
 도넛 : 막대와 8자가 아닌 정점

 풀이 : 정점을 탐색하면서 막대, 8자 두 조건중 하나라도 충족하는 정점을 만날 시 연관된 정점을 모두 visited 처리한다?
 모두 visited 되었는데 남아있는 정점이 존재한다면 해당 정점은 도넛이 된다.(단, 임의의 정점은 탐색에서 제외한다)

 간선의 수를 어떻게 파악할 것인가?
 각 정점의 진입차수와 진출 차수를 파악하고 8자 또는 막대에 해당하는지 파악한다.

 인접 행렬로 하면

 1 2 3 4
 1 1
 2 1   1
 3
 4     1

 만약 인접리스트로 하게되면 진출 차수만 파악할 수 있게 된다.
 진입 차수도 인접리스트로 만들려면?
 인접 행렬을 만들어놓고 열로 탐색해서 진입하는 정점들을 저장할 수 있다.

 그렇게 하면 로직 수행 시간을 단축시킬 수 있다.
 또한 인접리스트에서 진입 차수, 진출 차수 size()를 조회해서 빠르게 8자인지, 막대인지 파악할 수 있다.

 정점의 개수가 안주어져있는데?
 size 변수 파놓고 최댓값 저장하자.

 막대 모양일 때 진출 차수가 1개여야만하나?
 일단 1개여야만 한다는 조건을 빼고 나에게 들어온 정점의 진출 정점을 visited 처리

 임의의 정점이 구해졌다면 그 정점을 기준으로 뻗어나가지는 정점들 중 막대 or 도넛 or 8자 모양의 도넛이 존재한다
 따라서, 임의의 정점에서 뻗어나가는 정점의 개수 즉 진출 차수에서 막대 모양과 8자 모양의 정점 개수를 빼주면 해당 개수가 도넛 정점 개수가 된다.
 */

public class 도넛과막대그래프 {
    /*
    import java.util.*;

class Solution {

    static ArrayList<ArrayList<Integer>> outputGraph; // 진출 차수를 저장할 인접 리스트
    static ArrayList<ArrayList<Integer>> inputGraph; // 진입 차수를 저장할 인접 리스트
    static int size; // 정점의 크기
    static int tmpNode; // 임의의 정점
    static int[] result;

    // 임의의 정점 찾기
    static void findNode(){
        for(int i = 1; i <= size; i++){
            // 진출 차수가 2이상이면서 진입차수가 없는 정점
            if(outputGraph.get(i).size() >= 2 && inputGraph.get(i).size() == 0){
                tmpNode = i;
                return;
            }
        }
    }

    static void findStickAndEight(){
        for(int i = 1; i <= size; i++){
            if(tmpNode == i) continue;
            // 막대 모양인지 확인
            if(inputGraph.get(i).size() >= 1 && outputGraph.get(i).size() == 0){
                result[2]++;
            }

            // 8자 모양인지 확인
            else if(outputGraph.get(i).size() >= 2 && inputGraph.get(i).size() >= 2){
                result[3]++;
            }
        }
    }

    // 도넛 모양 정점 파악
    static void findDoughnut(){

        // 임의의 정점에서 막대 모양과 8자 모양 정점의 개수를 뺀 나머지가 도넛 모양 개수
        result[1] = outputGraph.get(tmpNode).size() - result[2] - result[3];
    }

    public int[] solution(int[][] edges) {
        int[] answer = {};

        size = 0;

        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            if(size < a){
                size = a;
            }else if(size < b){
                size = b;
            }
        }

        outputGraph = new ArrayList<>();
        inputGraph = new ArrayList<>();

        for(int i = 0; i <= size; i++){
            outputGraph.add(new ArrayList<>());
            inputGraph.add(new ArrayList<>());
        }

        // 인접리스트 진출 정점 저장
        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];

            outputGraph.get(a).add(b);
            inputGraph.get(b).add(a);
        }

        tmpNode = 0;
        result = new int[4]; // 정답을 저장할 배열

        // 임의의 정점을 찾기
        findNode();

        // 막대 모양 그래프와 8자 모양 그래프를 찾는다.
        findStickAndEight();

        // 임의의 정점 진출 차수 - 막대 모양 개수 - 8자 모양 개수
        findDoughnut();

//         for(int i = 1; i <= size; i++){
//             System.out.println(outputGraph.get(i).toString());
//         }

//         System.out.println("-0----------");

//         for(int i = 1; i <= size; i++){
//             System.out.println(inputGraph.get(i).toString());
//         }
        result[0] = tmpNode;

        return result;
    }
}
     */
}
