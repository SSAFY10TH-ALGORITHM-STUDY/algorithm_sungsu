package programmers.week5.dfsbfs;

import java.util.*;

/**
 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 한다.

 완전탐색을 할 경우 최대 10000 * 10000 = 1억이다.

 모든 경로를 다 방문해야 한다.(주어진 항공권은 모두 사용해야 한다)
 */
public class 여행경로 {

    /*
    import java.util.*;

class Solution {

    static boolean[] visited;

    static ArrayList<String> result;

    public void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            result.add(route);
            return;
        }

        for(int i = 0; i < tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];

        visited = new boolean[tickets.length+1];

        result = new ArrayList<>();

        dfs("ICN", "ICN", tickets, 0);

        Collections.sort(result);
        answer = result.get(0).split(" ");


        return answer;
    }
}
     */

}
