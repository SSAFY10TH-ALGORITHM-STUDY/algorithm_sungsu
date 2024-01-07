package programmers.모의고사1회;

/**
 문자열이 주어졌을 때 외톨이 알파벳들을 알파벳순으로 이어 붙인 문자열을 return 하도록 solution 함수를 완성해주세요.
 만약 외톨이 알파벳이 없다면 문자열 N을 return 합니다.

 2회 이상 나타난 알파벳이 2개 이상의 부분으로 나뉘어 있다면.

 - 조건에 맞는 문자를 HashSet에 저장
 charArray에 저장한 뒤에 오름차순 정렬 후 문자열로 변환하고 출력

 2개 이상의 부분으로 나뉘어져 있다는걸 어떻게 판단할 것인가?
 HashMap에 해당 문자를 저장

 이전 문자와 다르면서 hashMap에 두번 들어간 값을 tmp에 저장
 */
public class oneProblem {
    /*
    import java.util.*;

class Solution {
    public String solution(String input_string) {
        String answer = "";

        ArrayList<Character> tmp = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();

        char curChar = input_string.charAt(0);

        map.put(input_string.charAt(0), 1);

        HashSet<Character> setMap = new HashSet<>();

        // System.out.println(map.toString());
        // System.out.println(curChar);

        for(int i = 1; i < input_string.length(); i++){
            char key = input_string.charAt(i);
            map.put(key, map.getOrDefault(key,0)+1);

            if(curChar != key && map.get(key) >= 2 && !setMap.contains(key)){
                tmp.add(key);
                setMap.add(key);
            }

            curChar = key;
        }

        Collections.sort(tmp);

        for(char c : tmp){
            answer += c;
        }


        if(answer.equals("")){
            return "N";
        }
        // System.out.println(map.toString());



        return answer;
    }
}
     */
}
