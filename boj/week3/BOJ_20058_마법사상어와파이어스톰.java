package boj.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 얼음이 있는 칸 3개 또는 그 이상과 인접해있지 않은 칸은 얼음의 양이 1 줄어든다.
 * => 얼음이 있는 칸에서 상,하,좌,우로 인접한 칸에서 얼음이 존재하는 칸이 3 미만이라면 해당 칸을 -1해준다.
 *
 * * 문제 풀이
 * 1. 격자를 2^L x 2^L 크기의 부분 격자로 나눈다.
 * 2. 모든 부분 격자를 시계 방향으로 90도 회전시킨다.
 * 3. 얼음이 있는 칸 (r,c)에서 인접한 4개의 칸 중 얼음이 존재하는 칸이 3 미만이라면 (r,c)를 1 감소시킨다.
 * 4. Q번 시전하고 난 뒤 1. 남아있는 얼음의 합을 구한다. 2. 남아 있는 얼음 중 가장 큰 덩어리가 차지하는 칸의 개수를 구한다.
 *
 * 메모리 : 47408
 * 시간 : 260
 */
public class BOJ_20058_마법사상어와파이어스톰 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int size, tryCnt;

    static int[][] map;

    static int[] lList;

    static int[] deltaX = {-1,1,0,0};
    static int[] deltaY = {0,0,-1,1};

    static int totalIce;
    static int maxLand;

    static boolean[][] visited;
    static int lListIdx;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine().trim());

        size = Integer.parseInt(st.nextToken());
        tryCnt = Integer.parseInt(st.nextToken());

        size = (int)Math.pow(2,size);

        map = new int[size][size];

        for (int row = 0; row < size; row++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int col = 0; col < size; col++) {
            map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        lList = new int[tryCnt];

        st = new StringTokenizer(br.readLine().trim());

        for (int i = 0; i < tryCnt; i++) {
            lList[i] = Integer.parseInt(st.nextToken());
        }

        lListIdx = 0;

        for (int i = 0; i < tryCnt; i++) {
            // 1. 격자를 2^L x 2^L 크기의 부분 격자로 나눈다., 2. 모든 부분 격자를 시계 방향으로 90도 회전시킨다.
            map = divideAndRotate();

            // 3. 얼음이 있는 칸 (r,c)에서 인접한 4개의 칸 중 얼음이 존재하는 칸이 3 미만이라면 (r,c)를 1 감소시킨다.
            map = reduce();
        }

        // 4. Q번 시전하고 난 뒤 1. 남아있는 얼음의 합을 구한다. 2. 남아 있는 얼음 중 가장 큰 덩어리가 차지하는 칸의 개수를 구한다.
        visited = new boolean[size][size];
        result();

        System.out.println(totalIce);
        System.out.println(maxLand);
    }

    private static int[][] divideAndRotate() {
        // 부분 격자를 띄어낸다.
        // lList에 담긴 값을 기준으로 realSize를 구한다.
        int realSize = (int)Math.pow(2,lList[lListIdx++]);

        int[][] tmpMap = new int[size][size];

        for (int row = 0; row < size; row += realSize) {
            for (int col = 0; col < size; col += realSize) {
                rotate(row,col,realSize,tmpMap);
            }
        }

        return tmpMap;
    }

    private static void rotate(int row, int col, int realSize, int[][] tmpMap) {
        // 0열 -> 0행, 1열 -> 1행
        // 0행 -> 0 + realSize - i - 1열 만약 realSize가 4이고, 1행이라면 1 + 4 -1 -1이 되어 2열에 배치.
        for (int i = 0; i < realSize; i++) {
            for (int j = 0; j < realSize; j++) {
                tmpMap[row+j][col+realSize-i-1] = map[row+i][col+j];
            }
        }
    }

    private static void result() {
        visited = new boolean[size][size];
        totalIce = 0;
        maxLand = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(visited[row][col]) continue;
                if(map[row][col] <= 0) continue;
                totalIce += map[row][col];
                bfs(row,col);
            }
        }
    }

    private static void bfs(int row, int col) {
        Queue<int[]> que = new ArrayDeque<>();

        que.offer(new int[]{row,col});

        visited[row][col] = true;

        int iceCount = 1;

        while(!que.isEmpty()){
            int[] tmpArr = que.poll();
            int curRow = tmpArr[0];
            int curCol = tmpArr[1];
            for (int i = 0; i < 4; i++) {
                int dx = curRow+deltaX[i];
                int dy = curCol+deltaY[i];
                if(!rangeCheck(dx,dy)) continue;
                if(map[dx][dy] <= 0) continue;
                if(visited[dx][dy]) continue;
                totalIce += map[dx][dy];
                iceCount++;
                que.offer(new int[]{dx,dy});
                visited[dx][dy] = true;
            }
        }
        maxLand = Math.max(maxLand, iceCount);
    }

    private static int[][] reduce() {
        int[][] tmpMap = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                tmpMap[row][col] = map[row][col];
            }
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int cnt = 0;
                // 얼음이 있는 곳을 기준으로 인접한 얼음을 조사하기 때문에 얼음이 없는 곳은 continue
                if(map[row][col] == 0) continue;

                // 인접한 얼음 확인
                for (int i = 0; i < 4; i++) {
                    int dx = row+deltaX[i];
                    int dy = col+deltaY[i];

                    // 범위를 벗어나면 continue
                    if(!rangeCheck(dx,dy)) continue;
                    if(map[dx][dy] <= 0) continue;
                    cnt++;
                }
                // 만약 인접한 지역들의 얼음의 개수가 0이 아닌 경우가 3개 미만이라면 (row,col) 값을 -1해준다
                if(cnt < 3) tmpMap[row][col]--;
            }
        }
        return tmpMap;
    }

    private static boolean rangeCheck(int dx, int dy) {
        if(dx < 0 || dy < 0 || dx >= size || dy >= size) return false;

        return true;
    }
}