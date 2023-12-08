package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 문자열에서 단어만 뒤집는다.
 *
 * 태그 내부에 담겨 있는 문자열은 뒤집지 않는다.
 * 그 이외에 문자열은 뒤집는다.
 *
 * - 어떻게 뒤집을 것인가?
 * 1. StringBuffer를 사용한다.
 *  1-1. StringBuffer에 reverse().toString()을 사용하면 문자열을 뒤집을 수 있다.
 *
 * 2. char[]를 사용
 *  2-1. 입력받은 문자열을 toCharArray()로 char 배열로 만든다.
 *  2-2. revereStr char 배열을 만든 다음 변경된 char배열의 첫번째 값을 끝자리부터 담아줄 수 있다.
 *
 * 3. List로 변환 후 Collections.reverse()를 사용해서 뒤집는다.
 *  3-1. 입력받은 문자열 str을 toCharArray()로 char[]로 변환한다.
 *  3-2. 변환된 str char[]을 List<Character>에 담아준다.
 *  3-3 해당 list를 Collections.reverse()를 사용해서 뒤집는다.
 *
 * - 시간초과 발생
 * 10000 길이의 문자열에서 뒤집어야하는 문자열을 만날때마다 StringBuffer로 뒤집는 과정에서 많은 연산이 발생되면서 시간초과 발생
 * 해결 : Stack을 사용.
 */
public class BOJ_17413_단어뒤집기2 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        boolean flag = false;

        String inputStr = br.readLine().trim();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputStr.length(); i++) {

            if(inputStr.charAt(i) == '<'){
                if(stack.size() != 0 && !flag){
                    int size = stack.size();
                    for (int j = 0; j < size; j++) {
                        sb.append(stack.pop());
                    }
                }
                sb.append(inputStr.charAt(i));
                flag = true;
                continue;
            }

            if(inputStr.charAt(i) == '>'){
                flag = false;
                sb.append(inputStr.charAt(i));
                continue;
            }

            if(flag){
                sb.append(inputStr.charAt(i));
                continue;
            }

            if(inputStr.charAt(i) == ' '){
                int size = stack.size();
                for (int j = 0; j < size; j++) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
                continue;
            }

            if(i == inputStr.length()-1 && !flag){
                stack.push(inputStr.charAt(i));
                int size = stack.size();
                for (int j = 0; j < size; j++) {
                    sb.append(stack.pop());
                }
                break;
            }

            stack.push(inputStr.charAt(i));
        }

        System.out.println(sb);
    }
}
