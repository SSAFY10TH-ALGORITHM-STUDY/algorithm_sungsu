package programmers.week7;

/**

 1번 역삼각형
 왼쪽 방향의 삼각형을 포함하는 경우의 수
 윗 뿔이 있으므로 3개 (정삼각형, 평행 사변형, 마름모)
 오른쪽 방향의 삼각형을 포함하는 경우의 수
 1개 (평행 사변형)
 2번 역삼각형
 왼쪽 방향의 삼각형을 포함하는 경우의 수
 1번 역삼각형에서 왼쪽 방향의 삼각형을 포함하는 경우의 수에
 정삼각형과 마름모 케이스 조합이 생성될 수 있음
 오른쪽 방향의 삼각형을 포함하는 경우의 수
 이 경우는 1번 역삼각형이 왼쪽 삼각형을 포함하든, 오른쪽 삼각형을 포함하든 관계없으므로 아래와 같이 나타낼 수 있음
 1번 역삼각형이 왼쪽 삼각형을 포함하는 경우 + 1번 역삼각형이 오른쪽 삼각형을 포함하는 경우
 ...

 → 점화식 도출
 right_dir_cover[1] = 1
 left_dir_cover[1] = 3 if뿔 else 2

 right_dir_cover[idx] = right_dir_cover[idx - 1] + left_dir_cover[idx - 1]

 각 index에서 뿔이 있는 경우
 left_dir_cover[idx] = 2 * right_dir_cover[idx - 1] + 3 * left_dir_cover[idx - 1]
 각 index에서 뿔이 없는 경우
 left_dir_cover[idx] = right_dir_cover[idx - 1] + 2 * left_dir_cover[idx - 1]


 */
public class 산모양타일링 {

    /*
    import java.util.*;

class Solution {
        static final int MOD = 10007;

    public static int solution(int n, int[] tops) {
        int[] rightDirCover = new int[n + 1];
        int[] leftDirCover = new int[n + 1];

        rightDirCover[1] = 1;
        leftDirCover[1] = (tops[0] == 1) ? 3 : 2;

        for (int idx = 2; idx <= n; idx++) {
            if (tops[idx - 1] == 1) {
                leftDirCover[idx] = (2 * rightDirCover[idx - 1] + 3 * leftDirCover[idx - 1]) % MOD;
            } else {
                leftDirCover[idx] = (rightDirCover[idx - 1] + 2 * leftDirCover[idx - 1]) % MOD;
            }

            rightDirCover[idx] = (rightDirCover[idx - 1] + leftDirCover[idx - 1]) % MOD;

        }

        int answer = (leftDirCover[n] + rightDirCover[n]) % MOD;
        return answer;
    }
}
     */
}
