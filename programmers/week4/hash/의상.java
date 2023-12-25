package programmers.week4.hash;

import java.util.HashMap;

/**
 * * 문제
 * 코니가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를
 * return 하도록 solution 함수를 작성해주세요.
 *
 * headgear : yellow_hat, green_turban
 * eyewear : blue_sunglasses
 *
 * headgear = 2
 * eyewear = 1
 *
 * 자기 자신이 나오는 경우 3
 * 겹치지 않으면서 조합할 수 있는 경우가 2
 *
 */
public class 의상 {

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}};

        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        for(String key : map.keySet()){
            // answer *= map.get(key)를 하게 되면 해당 옷을 입은 경우의 수를 구하게 된다.
            // +1을 하는 이유는 입지 않은 경우의 수를 추가하기 위함이다.
            answer *= map.get(key)+1;
        }

        // -1을 하는 이유는 아무것도 입지 않은 경우를 제외하기 위함이다.

        System.out.println(answer-1);
    }
}
