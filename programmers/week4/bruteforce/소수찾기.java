package programmers.week4.bruteforce;

import java.util.HashSet;

public class 소수찾기 {

    static boolean[] visited;

    static HashSet<Integer> hashSet;

    static void permutation(String numbers, String temp, int depth){
        if(temp.length() == depth){
            int num = Integer.parseInt(temp);
            // 소수인지 판별하고, 소수라면 hashSet에 담아서 중복되지 않은 소수 값만 저장한다.
            if(primeNum(num)) hashSet.add(num);
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            temp += numbers.charAt(i);
            permutation(numbers, temp, depth);
            visited[i] = false;
            // temp의 마지막 한 글자를 제거
            temp = temp.substring(0, temp.length()-1);
        }
    }

    private static boolean primeNum(int num) {
        if(num < 2) return false;
        for (int i = 2; i*i <= num ; i++) {
            if(num%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String numbers = "17";

        visited = new boolean[7]; // numbers 문자열 길이는 1 ~ 7까지 이기 때문에 크기를 7로 설정

        hashSet = new HashSet<>();

        // 한자리 ~ numbers.length-1 자리까지 파악해야 한다.
        for (int i = 0; i < numbers.length(); i++) {
            permutation(numbers, "", i+1);
        }

        System.out.println(hashSet.toString());
    }
}
