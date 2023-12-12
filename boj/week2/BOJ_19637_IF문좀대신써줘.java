package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * * 사용 알고리즘 : 이분탐색(binarySearch)
 *
 * * 이분 탐색
 * - 반드시 정렬되어 있어야 한다.
 * - start, end, mid 변수 생성
 * - start = 0, end = size-1, mid = (start+end)/2
 * - value가 mid보다 크다면 start = mid+1
 * - value가 mid보다작다면 end = mid-1
 * - 위를 start <= end 일때 반복
 *
 * 메모리 : 73100
 * 시간 : 456
 */
public class BOJ_19637_IF문좀대신써줘 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static class Data{
        public String str;
        public int value;

        public Data(String str, int value) {
            this.str = str;
            this.value = value;
        }
    }

    static ArrayList<Data> list;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine().trim());

        int strCnt = Integer.parseInt(st.nextToken());

        int inputValueCnt = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();


        for (int i = 0; i < strCnt; i++) {
            st = new StringTokenizer(br.readLine().trim());

            String str = st.nextToken();

            int value = Integer.parseInt(st.nextToken());

            list.add(new Data(str, value));
        }

        for (int i = 0; i < inputValueCnt; i++) {
            int value = Integer.parseInt(br.readLine().trim());

            String answer = BinarySearch(value);

            sb.append(answer+"\n");
        }
        System.out.println(sb);
    }

    private static String BinarySearch(int value) {
        int start = 0, end = list.size()-1, mid = 0;

        while(start<=end){
            mid = (start+end)/2;
            if(value > list.get(mid).value) start = mid+1;
            else end = mid-1;
        }

        return list.get(end+1).str;
    }
}