package programmers.week7;

/**
 친구들의 이름을 담은 1차원 문자열 배열 friends
 이번 달까지 친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열 gifts가 매개변수로 주어집니다.
 이때, 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 return 하도록 solution 함수를 완성해 주세요.

 두 사람이 선물을 주고 받은 기록을 어떤 자료구조로 표현할 것인가?
 인접행렬로 표현할 수 있을 것 같다.
 */
public class 가장많이받은선물 {
    /*
    import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        int size = friends.length;

        int[][] graph = new int[size][size]; // 둘이 선물을 주고 받았는지 파악하는 인접행렬
        int[][] present = new int[size][3]; // 선물 지수

        for(String str : gifts){
            StringTokenizer st = new StringTokenizer(str);

            String a = st.nextToken();
            String b = st.nextToken();

            int tmpA = 0;
            int tmpB = 0;

            for(int i = 0; i < size; i++){
                if(a.equals(friends[i])){
                    tmpA = i;
                }else if(b.equals(friends[i])){
                    tmpB = i;
                }

                if(tmpA != 0 && tmpB != 0) break;
            }

            graph[tmpA][tmpB]++;
        }

//         for(int i = 0; i < size; i++){
//             for(int j = 0; j < size; j++){
//                 System.out.print(graph[i][j] + " ");
//             }
//             System.out.println();
//         }

        // 선물 지수 구하기
        // 행 = 준 선물 총 수
        for(int row = 0; row < size; row++){
            int sum = 0;
            for(int col = 0; col < size; col++){
                sum += graph[row][col];
            }
            present[row][0] = sum;
        }

        // 열 = 받은 선물 총 수
        for(int col = 0; col < size; col++){
            int sum = 0;
            for(int row = 0; row < size; row++){
                sum += graph[row][col];
            }
            present[col][1] = sum;
        }

        // 선물 지수 구하기
        for(int i = 0; i < size; i++){
            int give = present[i][0];
            int receive = present[i][1];

            int sum = give - receive;
            present[i][2] = sum;
        }

        // for(int i = 0; i < size; i++){
        //     System.out.println(Arrays.toString(present[i]));
        // }

        boolean[][] visited = new boolean[size][size];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i == j) continue;
                if(visited[i][j] || visited[j][i]) continue;
                // 둘다 선물한 기록이 없는 경우
                if(graph[i][j] == 0 && graph[j][i] == 0){
                    visited[i][j] = true;
                    visited[j][i] = true;

                    if(present[i][2] > present[j][2]){
                            map.put(i, map.getOrDefault(i, 0)+1);
                        }else if(present[i][2] < present[j][2]){
                            map.put(j, map.getOrDefault(j, 0)+1);
                        }

                }// 한명이라도 선물한 기록이 있다면
                else{

                    visited[i][j] = true;
                    visited[j][i] = true;
                    int a = graph[i][j];
                    int b = graph[j][i];
                    // 선물 받은 사람이 내게 선물한 수를 파악
                    // a가 선물을 더 많이 했다면 하나를 받아야함
                    if(a > b){
                        map.put(i, map.getOrDefault(i, 0)+1);
                    }
                    // a보다 b가 선물을 더 많이 했다면 b가 하나를 받는다.
                    else if(a < b){
                        map.put(j, map.getOrDefault(j, 0)+1);
                    }
                    // 선물한 횟수가 같다면 선물 지수가 더 높은 쪽이 1개를 받는다.
                    else if(a == b){
                        if(present[i][2] > present[j][2]){
                            map.put(i, map.getOrDefault(i, 0)+1);
                        }else if(present[i][2] < present[j][2]){
                            map.put(j, map.getOrDefault(j, 0)+1);
                        }
                    }
                }
            }
        }

        // System.out.println(map.toString());
        int max = 0;
        for(int num : map.values()){
            max = Math.max(max, num);
        }

        return max;
    }
}
     */
}
