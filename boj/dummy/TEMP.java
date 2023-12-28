package boj.dummy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TEMP {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int cityCnt;
    static int planCnt;

    static int[] answerList;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        cityCnt = Integer.parseInt(br.readLine().trim());
        planCnt = Integer.parseInt(br.readLine().trim());

        answerList = new int[planCnt+1];

        for (int i = 1; i <= cityCnt; i++) {
            answerList[i] = i;
        }

        for (int i = 1; i <= cityCnt; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 1; j <= cityCnt; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value == 1){
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine().trim());

        int root = Integer.parseInt(st.nextToken());

        boolean flag = false;

        for (int i = 0; i < planCnt-1; i++) {

            int value = Integer.parseInt(st.nextToken());

            if(root != find(value)){
                flag = true;
                break;
            }
        }

        // flag = true일 때 NO 출력
        if (flag) System.out.println("NO");
        else System.out.println("YES");
    }

    private static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if(i < j){
            answerList[j] = i;
        }else{
            answerList[i] = j;
        }
    }


    private static int find(int i) {
        if(answerList[i] == i) return i;
        return find(answerList[i]);
    }


}