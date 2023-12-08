package boj.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 */
public class BOJ_2573_빙산 {

    static class Position {
        public int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int height, width;

    static int[][] map;

    static int[] deltaX = {-1, 1, 0, 0};
    static int[] deltaY = {0, 0, -1, 1};

    static boolean[][] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int answer = 0;

        st = new StringTokenizer(br.readLine().trim());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new int[height][width];

        for (int row = 0; row < height; row++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int col = 0; col < width; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        flag = false;

        while (true) {
            // 1. 동서남북 체크해서 값 줄이기

            int[][] tmpMap = deepCopy(map);

            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    if (map[row][col] > 0) {
                        int cnt = 0;
                        for (int i = 0; i < 4; i++) {
                            int dx = row + deltaX[i];
                            int dy = col + deltaY[i];
                            if (dx < 0 || dy < 0 || dx >= height || dy >= width) continue;
                            if (map[dx][dy] > 0) continue;
                            cnt++;
                        }
                        tmpMap[row][col] -= cnt;

                        if (tmpMap[row][col] < 0) tmpMap[row][col] = 0;
                    }
                }
            }

            map = tmpMap;

//            for (int row = 0; row < height; row++) {
//                for (int col = 0; col < width; col++) {
//                    System.out.print(map[row][col] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            visited = new boolean[height][width];
            int level = 0;
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    if (map[row][col] > 0 && !visited[row][col]) {
                        bfs(row, col);
                        level++;
                    }
                }
            }

            answer++;
            if (level > 1) {
                break;
            }

            if (level == 0) {
                flag = true;
                break; // map의 모든 값이 0인 경우.
            }
        }
        if(flag){
            answer = 0;
        }

        System.out.println(answer);
    }

    private static void bfs(int row, int col) {
        Queue<Position> que = new ArrayDeque<>();

        que.offer(new Position(row, col));

        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                Position pos = que.poll();
                int x = pos.x;
                int y = pos.y;
                for (int j = 0; j < 4; j++) {
                    int dx = x + deltaX[j];
                    int dy = y + deltaY[j];
                    if (dx < 0 || dy < 0 || dx >= height || dy >= width) continue;
                    if (visited[dx][dy]) continue;
                    if(map[dx][dy] == 0) continue;
                    visited[dx][dy] = true;
                    que.offer(new Position(dx, dy));
                }
            }
        }

    }

    private static int[][] deepCopy(int[][] map) {
        int[][] tmpMap = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                tmpMap[row][col] = map[row][col];
            }
        }

        return tmpMap;
    }
}
