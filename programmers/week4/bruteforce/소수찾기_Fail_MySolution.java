package programmers.week4.bruteforce;

import java.util.HashSet;

/**
 * "17" -> [1,7]
 *
 * 나올 수 있는 소수 7, 17, 71
 *
 * "011" -> [0,1,1]
 *
 * 나올 수 있는 소수 11, 101
 */
public class 소수찾기_Fail_MySolution {

    static boolean[] visited;

    static char[] numberList;

    static int[] selected;
    static boolean[] selectedTwo;

    static HashSet<Integer> hashSet;

    static void permutation(int depth){
        if (depth == numberList.length){
            String tmp = new String();
            for (int i = 0; i < numberList.length; i++) {
                if(i == 0 && selected[i] == 0) continue;
                tmp += selected[i];
            }
            if(tmp.length() <= 0) return;

            int value = 0;
            value = Integer.parseInt(tmp);

            if(checkPrimeNumber(value)){
                hashSet.add(value);
            }

            return;
        }

        for (int i = 0; i < numberList.length; i++) {
            if(visited[i]) continue;

            visited[i] = true;

            selected[depth] = numberList[i]-48;

            permutation(depth+1);

            visited[i] = false;
        }
    }

    static void powerSet(int depth){
        if(depth == numberList.length){
            String tmp = new String();
            for (int i = 0; i < numberList.length; i++) {
                if(selectedTwo[i]){
                    if(i == 0 && numberList[i] == '0') continue;
                    tmp += numberList[i];
                }
            }
            if(tmp.length() <= 0) return;
            int value = 0;
            value = Integer.parseInt(tmp);

            if(checkPrimeNumber(value)){
                hashSet.add(value);
            }

            return;
        }

        selectedTwo[depth] = true;
        powerSet(depth+1);
        selectedTwo[depth] = false;
        powerSet(depth+1);

    }

    private static boolean checkPrimeNumber(int value) {
        if(value == 1 || value == 0) return false;
        for (int i = 2; i < value ; i++) {
            if(value%i==0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String numbers = "00";

        numberList = numbers.toCharArray();

        visited = new boolean[numberList.length];

        selected = new int[numberList.length];
        selectedTwo = new boolean[numberList.length];

        hashSet = new HashSet<>();

        permutation(0);
        powerSet(0);

        int answer = hashSet.size();
        System.out.println(hashSet.toString());
        System.out.println(answer);
    }
}
