package programmers.week5.dfsbfs;

/**
 캐릭터가 주어진 목표 위치에 도착하는 최단 경로를 구하시오.

 1. 주어진 X, Y 좌표를 이용하여 2차원 배열에 값을 1로 직사각형 범위만큼 채워넣는다.
 2. 모든 X, Y 좌표를 이용하여 직사각형을 만들었다면 직사각형들의 테두리를 제외한 값들을 0으로 변경한다.
 이때,
 3. 캐릭터X, 캐릭터Y 좌표를 시작으로 상,하,좌,우로 이동할 수 있다. itemX, itemY에 도착하는 최단경로를 구한다.

 몰랐던 부분.
 캐릭터 좌표, item 좌표, 직사각형 입력 좌표 모두 2배로 늘려줘야 한다.
 예제 1번을 보면 이해할 수 있는데, 예를 들어 (5,3) 좌표에서 기대하는 이동 경로는 (5,4)여야하지만
 (6,3)으로 이동하게 될 수 있다. 이는 테두리로만 움직이는 것을 기대했지만 그렇지 못한 경우이다.

 그리고 그 원인은 간격이 1 차이라는 것이다.
 따라서 이를 해결하기 위해서는 간격을 두배로 늘려주는 것이다. 두배로 늘리게 되면 테두리로만 이동할 수 있게 된다.

 그리고 결괏값을 return할 때는 2로 다시 나누면 된다.

 결론.

 테두리로 이동해야할 때는 주어진 좌표 값 *2으로 map의 범위를 확장시켜야 한다.
 */

public class 아이템줍기 {
    /*
    import java.util.*;

class Solution {

    static int[] deltaX = {-1,1,0,0};
    static int[] deltaY = {0,0,-1,1};
    static int[][] map;
    static final int MAP_SIZE = 102; // 맵의 크기를 2배로 늘려준다.
    static boolean[][] visited;

    static int result;

    static class Data{
        int x, y, distance;

        public Data(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static void bfs(int characterX, int characterY, int itemX, int itemY){
        Queue<Data> que = new ArrayDeque<>();

        // 캐릭터 시작 위치를 담는다.
        que.offer(new Data(characterY, characterX, 0));

        visited[characterY][characterX] = true;

        while(!que.isEmpty()){
            int x = que.peek().x;
            int y = que.peek().y;
            int distance = que.peek().distance;

            que.poll();

            for(int i = 0; i < 4; i++){
                int dx = x + deltaX[i];
                int dy = y + deltaY[i];

                if(dx == itemY && dy == itemX){
                    result = distance+1;
                    return;
                }

                if(dx >= MAP_SIZE || dy >= MAP_SIZE || dx < 0 || dy < 0) continue;

                if(map[dx][dy] == 0 || visited[dx][dy]) continue;

                que.offer(new Data(dx,dy,distance+1));
                visited[dx][dy] = true;
            }
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        // 직사각형을 나타내는 모든 좌표값은 1 이상 50이하인 자연수이므로 map은 최대 50의 크기를 가질 수 있다.
        map = new int[MAP_SIZE][MAP_SIZE];

        // rectangle의 0,2는 열 1,3은 행의 길이다
        for(int i = 0; i < rectangle.length; i++){
            int rowStart = rectangle[i][1]*2;
            int rowEnd = rectangle[i][3]*2;
            int colStart = rectangle[i][0]*2;
            int colEnd = rectangle[i][2]*2;

            for(int row = rowStart; row <= rowEnd; row++){
                for(int col = colStart; col <= colEnd; col++){
                    map[row][col] = 1;
                }
            }
        }

        // 테두리를 제외한 모든 곳을 빈공간(0)으로 만들기
        for(int i = 0; i < rectangle.length; i++){
            int rowStart = rectangle[i][1]*2;
            int rowEnd = rectangle[i][3]*2;
            int colStart = rectangle[i][0]*2;
            int colEnd = rectangle[i][2]*2;

            for(int row = rowStart; row <= rowEnd; row++){
                for(int col = colStart; col <= colEnd; col++){
                    if(row == rowStart || row == rowEnd || col == colStart || col == colEnd) continue;
                    map[row][col] = 0;
                }
            }
        }

        visited = new boolean[MAP_SIZE][MAP_SIZE];

        result = 0;

        bfs(characterX*2, characterY*2, itemX*2, itemY*2);

        return result/2;
    }
}
     */

}
