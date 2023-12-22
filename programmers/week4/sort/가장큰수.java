package programmers.week4.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내주세요.
 *
 * * 문제 풀이
 * 1. Arrays.sort를 override해서, 문자열 앞자리부터 내림차순으로 정렬한다.
 * 만약 문자열 앞자리가 같을 시 다음 문자간의 크기를 비교하여 정렬한다,
 * 2. '사전순 비교'
 * 비교하는 두 원소를 String으로 치환해서 이어붙였을 때 사전순으로 더 뒤에 있는 값이
 * 앞으로 가야한다.
 * ex ) 1, 2, 3, 4, 5.., 8,9에서 사전순으로 9가 가장 뒤에 있다.
 *
 * * 배운점.
 *
 */
public class 가장큰수 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        int[] numbers = {3, 30, 34, 5, 9};

        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 사전순으로 내림차순 정렬
        // [6,10,2] 배열이 존재할 때
        // 문자열 기준 사전순으로 내림차순하게 되면 [6,2,10]이 된다.
        // 반대로 오름차순하게 되면[10,2,6]이 된다.
        Arrays.sort(arr,(o1,o2) -> (o2+o1).compareTo(o1+o2));

        // 내림차순으로 정렬한 값이 0으로 시작한다면 가장 큰 수가 0이라는 의미이므로
        // return 0을 해준다
        if(arr[0].equals("0")){
            System.out.println("0");
        }

        // StringBuilder로 담아주는게 String을 합치는 연산보다 유리하다.
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}

/**
 * class Solution {
 *     public String solution(int[] numbers) {
 *         StringBuilder sb = new StringBuilder();
 *
 *         String[] arr = new String[numbers.length];
 *
 *         for(int i = 0; i < arr.length; i++){
 *             arr[i] = String.valueOf(numbers[i]);
 *         }
 *
 *         Arrays.sort(arr,(o1,o2)->(o2+o1).compareTo(o1+o2));
 *
 *         if(arr[0].equals("0")) return "0";
 *
 *         for(int i = 0; i < arr.length; i++){
 *             sb.append(arr[i]);
 *         }
 *
 *         return sb.toString();
 *     }
 * }
 */
