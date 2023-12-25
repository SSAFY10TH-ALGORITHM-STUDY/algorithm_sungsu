package programmers.week4.bruteforce;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 문제 ) 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성하라.
 *
 * brown = 10, yellow = 2
 * 둘이 더해서 = 12
 * 가로 x 세로 = 넓이
 * 가로 x 세로 == 12이다.
 * 가로 = 4, 세로 = 3일 수도 있다.
 * 가로 = 3, 세로 = 4는 불가능 하다. 왜냐하면 가로 >= 세로이기 때문
 *
 * 넓이 = brown + yellow
 * 넓이 = 12 x 1
 * 6 x 2
 * 4 x 3
 *
 * 세로는 반드시 3이상부터?
 *
 * 외각부터 뺴기 시작하면
 * 노란색 갯수는 = 가로 - 2  x 세로 - 2
 *
 *
 */
public class 카펫 {
    public static void main(String[] args) {
        int brown = 8;
        int yellow = 2000000;

        int sum = brown + yellow;

        int[] answer = new int[2];

        int width = 0;
        int height = 0;

        int tmp = 3;

        while(true){
            if(sum % tmp == 0){
                break;
            }
            tmp++;
        }

        width = sum/tmp;
        height = tmp;

        boolean flag = false;

        while(width >= height){
            int tmpWidth = width - 2;
            int tmpHeight = height - 2;

            // 외곽을 갈색으로, 중앙을 노란색으로 칠해가면서 정답인지 파악한다.
            while(tmpWidth >= 0 && tmpHeight >= 0){
                int tmpYellow = tmpWidth * tmpHeight;
//                System.out.println(tmpYellow);
//                System.out.println(width*height);
                // 중앙에 노란색 값이 yellow와 같으면서 전체 넓이에서 yellow를 뺀 값이 brown과 같다면 정답이다.
                if(tmpYellow == yellow && width*height-tmpYellow == brown){
                    answer[0] = width;
                    answer[1] = height;

                    flag = true;
                    break;
                }// 외곽을 갈색으로 칠한다.
                else{
                    tmpWidth -= 2;
                    tmpHeight -= 2;
                }
            }

            if(flag) break;

            // width와 height가 정답이 아니일 때 이 라인으로 오게되므로
            // width와 height 값을 변경해준다.
            height++;
            while(width>=height){
                if(sum % height == 0){
                    width = sum/height;
                    break;
                }
                height++;
            }
//            System.out.println(width + " " + height);
        }

        System.out.println(Arrays.toString(answer));
    }
}
