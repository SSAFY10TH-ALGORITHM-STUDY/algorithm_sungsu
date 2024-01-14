package programmers.모의고사2회;

/**
 로봇에 입력된 명령어를 순서대로 담고 있는 문자열 command가 주어집니다. 로봇이 주어진 명령어들을 순서대로 모두 수행한 뒤 도착한 최종 위치의 좌푯값 x, y를 순서대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.

 'R': 로봇이 오른쪽으로 90도 회전합니다.
 'L': 로봇이 왼쪽으로 90도 회전합니다.
 'G': 로봇이 한 칸 전진합니다.
 'B': 로봇이 한 칸 후진합니다.

 로봇이 어디 방향을 바라보고 있는지

 여기서 x = 열, y = 행, 기존의 나는 x = 행, y = 열로 처리했으니까 반대로 처리해줘야 함.

 바라보는 방향을 어떻게 바꾸더라?
 방향을 상,우,하,좌로 두고 각각 1,2,3,4로 둔다음 왼쪽이면 -1, 오른쪽이면 +1
 만약 1인데 -1을 한다면 4로
 4인데 +1을 한다면 1로 변경

 좌표를 0,0으로 시작해두고 여기서 왼쪽으로 이동했다면 -1,0이 되는거임
 */

public class 실습용로봇 {
    /*
    import java.util.*;

class Solution {
    static class Robot{
        int x, y, dir; // 좌표와 로봇이 어디 방향을 바라보고 있는지

        public Robot(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static final int UP = 1;
    static final int RIGHT = 2;
    static final int DOWN = 3;
    static final int LEFT = 4;

    public int[] solution(String command) {
        int[] answer = new int[2];

        Robot robot = new Robot(0,0,UP);

        for(char com : command.toCharArray()){
            if(com == 'R'){
                int dir = robot.dir;
                if(dir == 4){
                    dir = 1;
                }else{
                    dir += 1;
                }
                robot.dir = dir;
            }else if(com == 'L'){
                int dir = robot.dir;
                if(dir == 1){
                    dir = 4;
                }else{
                    dir -= 1;
                }
                robot.dir = dir;
            }else if(com == 'G'){
                int x = robot.x;
                int y = robot.y;
                int dir = robot.dir;
                if(dir == UP){
                    y += 1;
                }else if(dir == RIGHT){
                    x += 1;
                }else if(dir == DOWN){
                    y -= 1;
                }else if(dir == LEFT){
                    x -= 1;
                }
                robot.x = x;
                robot.y = y;
            }else if(com == 'B'){
                int x = robot.x;
                int y = robot.y;
                int dir = robot.dir;
                if(dir == UP){
                    y -= 1;
                }else if(dir == RIGHT){
                    x -= 1;
                }else if(dir == DOWN){
                    y += 1;
                }else if(dir == LEFT){
                    x += 1;
                }
                robot.x = x;
                robot.y = y;
            }
        }

        answer[0] = robot.x;
        answer[1] = robot.y;

        return answer;
    }
}
     */
}
