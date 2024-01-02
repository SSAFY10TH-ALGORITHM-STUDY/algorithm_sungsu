package programmers.week5.dfsbfs;

/**
 규칙에 맞게 최대한 많은 퍼즐 조각을 채워 넣을 경우, 총 몇 칸을 채울 수 있는가?
 */
public class 퍼즐조각채우기 {
    /*

    import java.util.*;

    class Solution {

    List<List<Point>> t = new ArrayList<>();
    List<List<Point>> g = new ArrayList<>();

    int[] dx = {-1, 1, 0,0};
    int[] dy = {0, 0,-1,1};

    // 블록과 빈공간의 좌표가 블록 내의 같은 위치에서 비교되어야 하기 때문에
    // 블록과 빈공간의 좌표를 모두 오름차순으로 정렬한다.
    static class Point implements Comparable<Point>{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point o){
            if(this.x == o.x) return this.y-o.y; // x좌표가 같다면 y 좌표를 기준으로 오름차순
            return this.x - o.x;
        }
    }

    public void bfs(int x, int y, int[][] board, boolean[][] visited, List<List<Point>> list){

        visited[x][y] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        List<Point> sub_list = new ArrayList<>();
        // 블록과 빈공간의 좌표를 비교해가며 모양이 일치하는지 확인하기 위해 0,0을 기준점으로 둔다.
        // 0,0을 기준으로 넣기 때문에 nx-x, ny-y를 해준 뒤list에 넣어줘야 한다.
        sub_list.add(new Point(0, 0)); //(0,0) 기준으로 넣어줌

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx<0 || ny<0 || nx>=board.length || ny>=board.length) continue;

                // 해당 빈공간과 블록모양을 sub_list에 좌표로 담아준다.
                if(!visited[nx][ny] && board[nx][ny]==1){
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                    sub_list.add(new Point(nx-x, ny-y)); //(0, 0) 기준으로 넣기 때문에
                }
            }
        }

        list.add(sub_list);
    }

     public int compareBlock(List<List<Point>> table, List<List<Point>> board, int answer){
        int table_size = table.size();
        int board_size = board.size();

        boolean[] visited = new boolean[board_size];

        for(int i=0; i<table_size; i++){
            for(int j=0; j<board_size; j++){
                //일치하면
                // 이미 채워져있는 블록이거나, 크기가 맞지 않는 블럭이라면 continue
                if(visited[j] || table.get(i).size()!=board.get(j).size())
                    continue;

                if(isRotate(table.get(i), board.get(j))){
                    visited[j] = true; //블록으로 채워짐
                    answer += board.get(j).size();
                    break;
                }

            }
        }

        return answer;
    }

     public boolean isRotate(List<Point> table, List<Point> board){
        //오름차순 정렬
        Collections.sort(board);

        //90도씩 회전시켜보기. 0, 90, 180, 270
        for(int i=0; i<4; i++){
            //오름차순 정렬. table은 회전할때마다 다시 정렬해줌.
            Collections.sort(table);

            int curr_x = table.get(0).x;
            int curr_y = table.get(0).y;

            //회전하면서 좌표가 바뀌기 때문에, 다시 (0,0) 기준으로 세팅
            for(int j=0; j<table.size(); j++){
                table.get(j).x -= curr_x;
                table.get(j).y -= curr_y;
            }

            boolean check = true;
            //좌표 비교
            for(int j=0; j<board.size(); j++){
                if(board.get(j).x != table.get(j).x || board.get(j).y != table.get(j).y){
                    check = false;
                    break;
                }
            }

            if(check){
                return true;
            }
            else{
               //90도 회전시키기. x, y -> y, -x
                for(int j=0; j<table.size(); j++){
                    int temp = table.get(j).x;
                    table.get(j).x = table.get(j).y;
                    table.get(j).y = -temp;
                }
            }
        }

        return false;
    }

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        int len = game_board.length;

        // game_board 0,1 서로 바꿔주기
        for(int i=0; i < len; i++){
            for(int j=0; j<len; j++){
                if(game_board[i][j]==1) game_board[i][j] = 0;
                else game_board[i][j] = 1;
            }
        }

        boolean[][] visited_t = new boolean[len][len];
        boolean[][] visited_g = new boolean[len][len];

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                //table에서 블록 추출
                if(table[i][j]==1 && !visited_t[i][j])
                    bfs(i, j, table, visited_t, t);

                //game_board에서 빈공간 추출
                if(game_board[i][j]==1 && !visited_g[i][j])
                    bfs(i, j, game_board, visited_g, g);
            }
        }

        //table의 블록과 board 빈 공간의 블록을 회전하면서 비교해주기
        answer = compareBlock(t, g, answer);

        return answer;
    }
}
     */
}
