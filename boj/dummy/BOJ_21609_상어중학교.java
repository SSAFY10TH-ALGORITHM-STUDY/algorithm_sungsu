package boj.dummy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 그룹에 속한 블록의 개수는 2보다 크거나 같아야 한다.
 * 임의의 한 블록에서 그룹에 속한 인접한 칸으로 이동해서 그룹에 속한 다른 모든 칸으로 이동할 수 있어야 한다?
 * 블록 그룹의 기준 블록은 무지개 블록이 아닌 블록 중에서 행의 번호가 가장 작은 블록, 그러한 블록이 여러개면
 * 열의 번호가 가장 작은 블록이다?
 *
 * - 그룹에 속한 다른 모든 칸으로 이동할 수 있어야 한다??
 * - 블록 그룹의 기준이 왜 필요하지?
 *  - 크기가 가장 큰 블록 그룹을 찾을 때. 크기가 같은 블록 그룹이 여러개이고,
 *  포함된 무지개 블록 수 마저도 같은 그룹이 존재한다면 기준 블록을 기준으로 크기가 큰 블록 그룹을 찾아야 하기 때문에
 *  기준 블록이 필요하다.
 *
 * 오토 플레이는 다음과 같은 과정이 블록 그룹이 존재하는 동안 계속해서 반복된다.
 * 1. 크기가 가장 큰 블록 그룹을 찾는다. 블록 그룹이 여러개면 포함된 무지개 블록의 수가 가장 많은 블록 그룹,
 * 그러한 블록도 여러개라면 기준 블록의 행이 가장 큰 것을, 그 것도 여러개이면 열이 가장 큰 것을 찾는다.
 *
 * - 크기가 가장 큰 블록 그룹을 어떻게 찾을 것인가?
 * - 중력 작용은 어떻게 할 것인가 ?
 * - 90도 반시계 방향 회전은 어떻게 할 것인가?
 *
 */
public class BOJ_21609_상어중학교 {

    static class Position{
        public int x,y;

        public Position() {
        }

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int mapSize, colorCnt, maxBlockCnt, maxRainbowCnt;

    static int[][] map;

    static boolean[][] visited;

    static int[] deltaX = {-1,1,0,0};
    static int[] deltaY = {0,0,-1,1};

    static boolean flag;

    static Position maxTargetBlock;

    static int answer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine().trim());

        mapSize = Integer.parseInt(st.nextToken());

        colorCnt = Integer.parseInt(st.nextToken());

        map = new int[mapSize][mapSize];

        answer = 0;

        for (int row = 0; row < mapSize; row++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int col = 0; col < mapSize; col++) {
                int value = Integer.parseInt(st.nextToken());
                map[row][col] = value;
            }
        }

        while(true){
            visited = new boolean[mapSize][mapSize];

            flag = false; // 격자 내부에 블록 그룹이 존재하는지 파악

            maxBlockCnt = 2; // 그룹은 2이상일 때부터 가능하므로.
            maxRainbowCnt = 0;

            maxTargetBlock = new Position();

            for (int row = 0; row < mapSize; row++) {
                for (int col = 0; col < mapSize; col++) {
                    if(map[row][col] == 6) continue;
                    if(map[row][col] > 0 && !visited[row][col]){
                        int color = map[row][col];
                        bfs(row,col,color);
                    }
                }
            }

            if(!flag) break; // 그룹이 존재하지 않는다는 의미이므로.

            visited = new boolean[mapSize][mapSize];

            System.out.println(maxTargetBlock.x + " " + maxTargetBlock.y);

            deleteGroup(maxTargetBlock.x, maxTargetBlock.y);

            // 중력 적용
            gravity();

            // 반시계 90도 회전
            turnReverseClock();

            // 중력 적용
            gravity();

//            for (int row = 0; row < mapSize; row++) {
//                for (int col = 0; col < mapSize; col++) {
//                    System.out.print(map[row][col] + " ");
//                }
//                System.out.println();
//            }
//
//            System.out.println("-----------------");
        }

        System.out.println(answer);
    }

    private static void turnReverseClock() {
        int[][] tmpMap = deepCopy(map);

        map = tmpMap;
    }

    private static int[][] deepCopy(int[][] map) {
        int[][] tmpMap = new int[mapSize][mapSize];

        // map의 0행 -> 0열
        for (int row = 0; row < mapSize; row++) {
            for (int col = 0; col < mapSize; col++) {
                tmpMap[mapSize-col-1][row] = map[row][col];
            }
        }

        return tmpMap;
    }

    private static void gravity() {
        for (int col = 0; col < mapSize; col++) {
            for (int row = mapSize-2; row >= 0; row--) {
                if(map[row][col] == 6 || map[row][col] == -1) continue;
                int addRow = row+1;
                while(true){
                    if(addRow >= mapSize) break;
                    if(map[addRow][col] == -1) break;
                    if(map[addRow][col] < 6 && map[addRow][col] >= 0) break;
                    int tmp = map[addRow-1][col];
                    map[addRow-1][col] = 6;
                    map[addRow][col] = tmp;
                    addRow++;
                }
            }
        }
    }

    private static void deleteGroup(int x, int y) {
        Queue<Position> que = new ArrayDeque<>();

        que.offer(new Position(x,y));

        int deletedBlock = 1;

        int color = map[x][y];

        while(!que.isEmpty()){
            Position position = que.poll();

            int curX = position.x;
            int curY = position.y;

            for (int i = 0; i < 4; i++) {
                int dx = curX + deltaX[i];
                int dy = curY + deltaY[i];

                if(dx < 0 || dy < 0 || dx >= mapSize || dy >= mapSize) continue;

                if(map[dx][dy] == -1 || visited[dx][dy]) continue;

                if(map[dx][dy] == 6) continue; // 공백이므로 continue;

                if(map[dx][dy] == color){
                    deletedBlock++;
                    que.offer(new Position(dx,dy));
                    visited[dx][dy] = true;
                    map[dx][dy] = 6; // 블록 제거
                    continue;
                }

                if(map[dx][dy] == 0){
                    deletedBlock++;
                    que.offer(new Position(dx, dy));
                    visited[dx][dy] = true;
                    map[dx][dy] = 6;
                    continue;
                }
            }
        }
//        System.out.println(deletedBlock-1);
        answer += Math.pow((deletedBlock-1),2);
    }

    private static void bfs(int row, int col, int color) {
        Queue<Position> que = new ArrayDeque<>();

        Position targetBlock = new Position(row,col); // 기준 블록

        visited[row][col] = true;

        que.offer(new Position(row,col));

        int blockCnt = 0;
        int rainbowCnt = 0;

        while(!que.isEmpty()){
            Position position = que.poll();

            blockCnt++;

            int curRow = position.x;
            int curCol = position.y;

            for (int i = 0; i < 4; i++) {
                int dx = curRow + deltaX[i];
                int dy = curCol + deltaY[i];

                if(dx < 0 || dy < 0 || dx >= mapSize || dy >= mapSize) continue;

                if(map[dx][dy] == -1 || visited[dx][dy]) continue;

                if(map[dx][dy] == 6) continue; // 공백이므로 continue

                if(map[dx][dy] == color){
                    que.offer(new Position(dx,dy));
                    visited[dx][dy] = true;
                    blockCnt++;
                    continue;
                }

                if(map[dx][dy] == 0){
                    que.offer(new Position(dx, dy));
                    visited[dx][dy] = true;
                    rainbowCnt++;
                }
            }
        }

        if(maxRainbowCnt == blockCnt){
            if(maxRainbowCnt == rainbowCnt){
                flag = true; // 블록이 두개 이상이라면 그룹이 존재한다는 의미이므로 flag를 true로 변환해준다.
                if(targetBlock.x == maxTargetBlock.x){
                    if(targetBlock.y > maxTargetBlock.y){
                        maxTargetBlock.y = targetBlock.y;
                    }
                }else if(targetBlock.x > maxTargetBlock.x){
                    maxTargetBlock.x = targetBlock.x;
                    maxTargetBlock.y = targetBlock.y;
                }
            }else if(maxRainbowCnt < rainbowCnt){
                flag = true;
                maxRainbowCnt = rainbowCnt;
                maxTargetBlock.x = targetBlock.x;
                maxTargetBlock.y = targetBlock.y;
            }
        }else if(blockCnt > maxBlockCnt){
            flag = true;
            maxBlockCnt = blockCnt;
            maxRainbowCnt = rainbowCnt;
            maxTargetBlock.x = targetBlock.x;
            maxTargetBlock.y = targetBlock.y;
        }
    }
}
