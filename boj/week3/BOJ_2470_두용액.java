package boj.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * - 같은 양의 두 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들려고 한다.
 * - 같은 종류의 알칼리성 용액 또는 산성 용액만으로 특성 값이 0에 가까운 혼합 용액을 만드는 경우도 존재한다.
 * - 두 개의 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들어내는 프로그램을 작성하시오.
 * - 특성값이 0에 가장 가까운 용액을 만들어내는 경우가 두 개 이상일 경우 그 중 아무것이나 하나 출력한다.
 *
 * 부분집합 시간 복잡도 : O(N * 2^N), N = 100,000 이하이므로 시간 초과
 * -99,-2,-1,4,98
 *
 * 두 용액의 합이 음수라면 lp(leftPoint)가 오른쪽으로 이동
 * 양수라면 rp(rightPoint)가 왼쪽으로 이동하면서 두 용액의 합의 절댓값이 최대로 낮은 값을 출력한다.
 * 만약 0이 나온다면 break하고 바로 출력해준다.
 *
 * 메모리 : 31744
 * 시간 : 296
 */
public class BOJ_2470_두용액 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int waterCnt;
    static int[] waterList;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        waterCnt = Integer.parseInt(br.readLine().trim());

        waterList = new int[waterCnt];

        st = new StringTokenizer(br.readLine().trim());

        for (int i = 0; i < waterCnt; i++) {
            waterList[i] = Integer.parseInt(st.nextToken());
        }

        // waterList 오름차순 정렬
        Arrays.sort(waterList);

        int lp = 0;
        int rp = waterCnt-1;

        int answer = Integer.MAX_VALUE;

        int[] minLpRp = new int[2];

        while(lp < rp){
            // 두 용액의 합을 구한다.
            int min = Math.abs(waterList[lp] + waterList[rp]);

            // lp와 rp 값을 저장한다.
            // 두 용액의 합이 0이 되었을 때 더이상 탐색할 필요가 없으므로 break
            if(min == 0){
                minLpRp[0] = lp;
                minLpRp[1] = rp;
                break;
            }

            // 0과 가장 가까운 값을 갱신한다.
            if(answer > min){
                answer = min;
                minLpRp[0] = lp;
                minLpRp[1] = rp;
            }

            // 두 용액의 합이 음수일 때 lp를 1증가
            // 양수 일 때 rp를 1 감소한다.
            if(waterList[lp] + waterList[rp] < 0) lp++;
            else if(waterList[lp] + waterList[rp] > 0) rp--;
        }

        System.out.println(waterList[minLpRp[0]] + " " + waterList[minLpRp[1]]);
    }
}
