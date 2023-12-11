package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 참고 블로그 : https://goto-pangyo.tistory.com/100
 *
 * 메모리 : 11564
 * 시간 : 80
 */
public class BOJ_16719_ZOAC {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static String inputStr;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        inputStr = br.readLine().trim();

        visited = new boolean[inputStr.length()];

        solution(0, inputStr.length()-1);

        System.out.println(sb);
    }

    private static void solution(int left, int right) {
        // 주어진 범위의 왼쪽 인덱스가 오른쪽 인덱스보다 크다면 범위가 잘못된 것이므로 메서드 종료
        if(left > right) return;

        // 현재 주어진 범위에서 가장 왼쪽에 있는 문자를 가리키는 인덱스
        int idx = left;

        // left와 right 사이에 있는 글자중 사전식 순서가 가장 낮은 글자를 찾는다(idx)
        for (int i = left; i <= right; i++) {
            if(inputStr.charAt(idx) > inputStr.charAt(i)) idx = i;
        }

        // 찾은 가장 작은 문자를 방문한 것으로 표시
        visited[idx] = true;

        for (int i = 0; i < inputStr.length(); i++) {
            if(visited[i]){
                sb.append(inputStr.charAt(i));
            }
        }
        sb.append("\n");

//        System.out.println(left + " " + right);
//        System.out.println(idx);

        // 찾은 가장 작은 문자의 오른쪽 부분에 대한 재귀 호출
        solution(idx + 1, right);

        // 찾은 가장 작은 문자의 왼쪽 부분에 대한 재귀 호출
        solution(left, idx-1);
    }
}
