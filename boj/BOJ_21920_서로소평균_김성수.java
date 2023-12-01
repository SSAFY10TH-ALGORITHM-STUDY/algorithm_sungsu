package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21920_서로소평균_김성수 {
    static BufferedReader br;
    static StringTokenizer st;

    static int numCnt, X;
    static int[] numList;

    // 최대 공약수 구하기(gcd)
    // 두 수를 나눈 나머지가 0이면 val2가 val1과 val2의 최대 공약수이다.
    // 나머지가 0이 아니라면 val2 값을 val1 값에 담아주고, val2에 val1 % val2 값을 담아준다.
    public static int gcd(int val1, int val2) {
        if (val2 == 0) {
            return val1;
        }
        return gcd(val2, val1 % val2);
    }

    // 서로소 평균을 구하기 위함.
    public static void calculateAndPrintAverage() {
        double sum = 0;
        double sumCnt = 0;

        // numList에 담긴 값들을 주어진 X 값과 최대공약수를 구하여 서로소를 파악하고 sum 값과 sumCnt를 구한다.
        for (int i = 0; i < numCnt; i++) {
            int checkGcd = gcd(X, numList[i]);

            // 최대공약수가 1이라면 서로소이다.
            if (checkGcd == 1) {
                sum += numList[i];
                sumCnt++;
            }
        }

        double average = sum / sumCnt;
        System.out.println(average);
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        numCnt = Integer.parseInt(br.readLine().trim());
        numList = new int[numCnt];
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < numCnt; i++) {
            numList[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine().trim());

        // X와 서로소인 수의 평균을 계산하고 출력한다.
        calculateAndPrintAverage();
    }
}
