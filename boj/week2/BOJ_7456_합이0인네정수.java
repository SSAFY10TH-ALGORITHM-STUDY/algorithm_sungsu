package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 참고 블로그 : https://loosie.tistory.com/553
 *
 * 1. a,b,c,d를 ab, cd 배열로 압축시킨다.
 * 2. ab와 cd배열을 정렬한 후 이진 탐색을 통해 합이 0이 되는 지점을 탐색한다.
 *  1. abv + cdv < 0, 값을 올려야 하므로 ab 포인터가 한 칸 앞으로 이동한다. adp += 1
 *  2. abv + cdb > 0, 값을 내려야 하므로 cd 포인터가 한 칸 뒤로 이동한다. cdp -= 1
 *  3. abv + cdv = 0, 0이 되는 구간이므로 중복되는 원소가 있는지 확인한 후 카운트를 해준다.
 * 3. ab포인터가 arrCnt*arrCnt가 되거나 cd 포인터가 -1이 되는 순간 탐색을 종료한다.
 *
 * 메모리 : 152912
 * 시간 : 3912
 */
public class BOJ_7456_합이0인네정수 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int arrCnt = Integer.parseInt(br.readLine().trim());

        int [][] abcd = new int[arrCnt][4];

        for (int i = 0; i < arrCnt; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < 4; j++) {
                abcd[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] ab = new int[arrCnt*arrCnt];
        int[] cd = new int[arrCnt*arrCnt];

        for (int i = 0; i < arrCnt; i++) {
            for (int j = 0; j < arrCnt; j++) {
                ab[i*arrCnt+j] = abcd[i][0] + abcd[j][1];
                cd[i*arrCnt+j] = abcd[i][2]+abcd[j][3];
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        int abp = 0;
        int cdp = arrCnt*arrCnt-1;

        long cnt = 0;
        while(abp<arrCnt*arrCnt && cdp > -1){
            long abv = ab[abp], cdv = cd[cdp];
            long result = abv + cdv;

            if(result<0){
                abp+=1;
            }else if(result>0){
                cdp-=1;
            }
            // 현재 탐색 위치에서 ab 배열과 cd 배열의 합이 0인 경우, 이 경우 중복된 값들을 처리한다.
            else if(result == 0){
                // xc와 yc는 각각 현재 abv와 cdv에 대해 중복된 값의 개수를 나타내는 변수이다.
                long xc=0, yc=0;
                // ab 배열에서 중복된 값들의 개수를 세어 xc에 더해준다.
                while(abp<arrCnt*arrCnt && abv == ab[abp]){
                    abp++;
                    xc++;
                }

                // cd 배열에서 중복된 값들을 세어 yc에 더해준다.
                while(cdp>-1 && cdv==cd[cdp]){
                    cdp--;
                    yc++;
                }

                // 최종적으로 xc와 yc의 곱을 cnt에 담아준다. 왜냐하면 xc와 yc는 각각 abv와 cdv에 대한
                // 중복된 값의 개수를 나타내기 때문에 xc * yc가 해당 값에 대한 중복된 조합의 개수를 의미한다.
                cnt += xc*yc;
            }
        }
        System.out.println(cnt);
    }
}
