package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 물건 1.
 * 바람의 방향을 좌 -> 우, 우 -> 좌
 *
 * 물건 2.
 * 바람의 방향을 하 -> 상, 상 -> 하
 *
 * 물건 3.
 * 바람의 방향을 하 -> 좌, 좌 -> 하, 우 -> 상, 상 -> 우
 *
 * 물건 4.
 * 바람의 방향을 하 -> 우, 좌 -> 상, 우 -> 하, 상 -> 좌
 *
 */


public class BOJ_21922_학부연구생민상 {
    static int[][] map;
    static int height, width, cnt;
    static boolean[][][] visit;
    // 인덱스에 따른 방향 : 0 : 상, 1 : 우, 2 : 하, 3 : 좌
    static int[] dx = {0, 1, 0, -1}; // 상우하좌
    static int[] dy = {-1, 0, 1, 0};
    static class Node {
        int y, x, dir;
        public Node(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }

    static Queue<Node> q = new LinkedList<Node>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        visit = new boolean[height][width][4];
        map = new int[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 9) {
                    for (int dir = 0; dir < 4; dir++) {
                        visit[i][j][dir] = true; // 4개의 방향을 모두 담으므로 방문 처리
                        q.add(new Node(i, j, dir)); // q에 4개의 방향을 모두 담는다.
                    }
                }
                map[i][j] = temp;
            }
        }

        bfs();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int dir = 0; dir < 4; dir++) {
                    // 방향이 이동한 곳이있다면 cnt를 증가시킨다.
                    if(visit[i][j][dir]) {
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            Node cur = q.poll();

            // 주어진 방향으로 이동.
            int nx = cur.x + dx[cur.dir];
            int ny = cur.y + dy[cur.dir];

            // 범위를 벗어나면 continue
            if(nx < 0 || nx >= width || ny < 0 || ny >= height) continue;

            // 한번이라도 방문한 곳이라면 continue
            if(visit[ny][nx][cur.dir]) continue;
            visit[ny][nx][cur.dir] = true;

            // 바람의 방향을 바꾼다.
            switch(map[ny][nx]) {
                case 1 :
                    if(cur.dir == 1 || cur.dir == 3) continue; // 좌, 우 방향으로 가는 바람을 차단.
                    break;
                case 2 :
                    if(cur.dir == 0 || cur.dir == 2) continue; // 상, 하 방향으로 가는 바람을 차단.
                    break;
                case 3 :
                    if(cur.dir == 0) cur.dir = 1;
                    else if(cur.dir == 1) cur.dir = 0;
                    else if(cur.dir == 2) cur.dir = 3;
                    else if(cur.dir == 3) cur.dir = 2;
                    break;
                case 4 :
                    if(cur.dir == 0) cur.dir = 3;
                    else if(cur.dir == 1) cur.dir = 2;
                    else if(cur.dir == 2) cur.dir = 1;
                    else if(cur.dir == 3) cur.dir = 0;
                    break;
            }

            // 변경된 방향이 적용된 값을 다시 q에 담는다.
            q.add(new Node(ny, nx, cur.dir));
        }
    }

}
