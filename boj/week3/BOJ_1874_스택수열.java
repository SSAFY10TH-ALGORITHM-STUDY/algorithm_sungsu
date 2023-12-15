package boj.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * * 문제 풀이
 * 주어진 수대로 수열이 만들어지는지 확인하는 문제이다.
 * 예를 들어 첫번째 입력 예시는 4 3 6 8 7 5 2 1 수열이 만들어지는지 확인해야 하는 문제이다.
 * 그 전에 stack에 입력하는 값은 주어진 숫자 값들이 오름차순 되어진 상태여야 하므로
 * 주어진 숫자들을 배열에 저장한뒤 오름차순으로 정렬해준다.
 *
 * 오름차순으로 정렬된 리스트에서 값을 하나씩 스택에 담는다. 이때 입력받은 수열에 0번째와 같은 값을 만나면 해당 값을 pop하고
 * 0 -> 1번째로 idx 위치를 변경시켜준다. 이를 반복하면서 입력받은 수열이 만들어지는지를 파악한다.
 *
 * 메모리 : 36756
 * 시간 : 444
 */
public class BOJ_1874_스택수열 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int numCnt = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[numCnt];
        int[] sortedArr = new int[numCnt];

        for (int i = 0; i < numCnt; i++) {
            int num = Integer.parseInt(br.readLine().trim());

            arr[i] = num;
            sortedArr[i] = num;
        }

        Arrays.sort(sortedArr);

        Stack<Integer> stack = new Stack<>();

        int sortedIdx = 0;
        int arrIdx = 0;

        boolean flag = false;

        while(true){
            if(stack.size() > 0){
                if(stack.peek().equals(arr[arrIdx])){
                    sb.append("-\n");
                    stack.pop();
                    arrIdx++;
                    if(stack.isEmpty() && arrIdx == numCnt) break;
                    continue;
                }
            }
            if(sortedIdx < numCnt){
                stack.push(sortedArr[sortedIdx++]);
                sb.append("+\n");
            }else{
                if(stack.peek() != arr[arrIdx]) {
                    flag = true;
                    break;
                }
            }
            if(arrIdx == numCnt) break;
        }

        if(!flag){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }
    }
}