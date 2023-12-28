package programmers.week5.dfsbfs;

import java.util.*;

/**
 캐릭터가 상대 팀 진영에 도착하기 위해 지나가야 하는 칸의 개수의 최솟값을 return 하시오
 상대 팀 진영에 도착하지 못한다면 -1을 return 해주세요.

 */
public class 게임맵최단거리 {
    static int[][] map;

    static int[] deltaX = {-1,1,0,0};
    static int[] deltaY = {0,0,-1,1};

    static void bfs(){
        Queue<Integer> queX = new ArrayDeque<>();
        Queue<Integer> queY = new ArrayDeque<>();
        Queue<Integer> resultQue = new ArrayDeque<>();

        queX.offer(1);
        queY.offer(1);
        resultQue.offer(1);

        while(!queX.isEmpty()){

            int x = queX.poll();
            int y = queY.poll();
            int tmpResult = resultQue.poll();

            for(int i = 0; i < 4; i++){
                int dx = x + deltaX[i];
                int dy = y + deltaY[i];

                if(dx == rowSize && dy == colSize){
                    visited[rowSize][colSize] = true;
                    result = tmpResult+1;
                    return;
                }

                if(dx > rowSize || dy > colSize || dx < 1 || dy < 1) continue;

                if(visited[dx][dy] || map[dx][dy] == 0) continue;

                queX.offer(dx);
                queY.offer(dy);
                resultQue.offer(tmpResult+1);
                visited[dx][dy] = true;
            }
        }
    }

    static boolean[][] visited;
    static int rowSize;
    static int colSize;

    static int result;

    public int solution(int[][] maps) {

        rowSize = maps.length;
        colSize = maps[0].length;

        map = new int[rowSize+1][colSize+1];

        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                map[i+1][j+1] = maps[i][j];
            }
        }

        visited = new boolean[rowSize+1][colSize+1];

        result = 0;

        bfs();

        if(!visited[rowSize][colSize]) return -1;

        return result;
    }
}
