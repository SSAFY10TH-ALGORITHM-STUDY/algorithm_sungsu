package programmers.week5.dfsbfs;

/**
 1 1 0
 1 1 0
 0 0 1

 연결되어 있는 경우 연결된 모든 컴퓨터를 묶어서 하나의 네트워크라고 한다.
 만약 3개의 컴퓨터가 있는데  A,B는 연결되어 있고 C는 연결되어 있지 않다면
 A,B = 네트워크 1
 C = 네트워크 1
 1 + 1 = 2가 된다.

 만약 A,B,C가 모두 연결되어 있다면
 A,B,C = 네트워크 1이 된다.
 */
public class 네트워크 {
    // 연결되어 있는 모든 컴퓨터를 찾는다.
    static void bfs(int computerNum, boolean[] visited, int[][] computers, int n){
        for(int row = computerNum; row <= computerNum; row++){
            for(int col = 0; col < n; col++){
                // 해당 컴퓨터를 이미 방문한 적이 있다면 continue
                // 진입한 computerNum은 방문처리 x
                if(visited[col]) continue;
                // 서로 연결되어있을 때
                if(computers[row][col] == 1){
                    // System.out.println(col);
                    visited[col] = true;
                    bfs(col, visited, computers,n);
                }
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            // i = 컴퓨터 번호
            // bfs에 진입한 컴퓨터를 제외한 모든 연결된 컴퓨터를 찾고 visited 처리한다.
            if(!visited[i]) answer++;
            bfs(i, visited, computers, n);
        }



        return answer;
    }
}
