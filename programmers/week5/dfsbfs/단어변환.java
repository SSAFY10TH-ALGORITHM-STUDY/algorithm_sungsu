package programmers.week5.dfsbfs;

/**
 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록
 solution 함수를 작성해주세요.

 변환할 수 없는 경우 0을 return 한다.
 */
public class 단어변환 {
    /*
    import java.util.*;

class Solution {

    static boolean compare(String word, String tmpStr){
        int cnt = 0;
        for(int i = 0; i < tmpStr.length(); i++){
            if(word.charAt(i) != tmpStr.charAt(i)) cnt++;
        }
        if(cnt == 1) return true;

        return false;
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<String> que = new ArrayDeque<>();

        HashSet<String> set = new HashSet<>(Arrays.asList(words));

        que.offer(begin); // 시작 문자열을 que에 담는다.
        set.remove(begin);

        if(!set.contains(target)) return 0;

        while(!que.isEmpty()){

            int len = que.size();

            for(int i = 0; i < len; i++){
                String tmpStr = que.poll();

                if(tmpStr.equals(target)) return answer;

                for(String word : set.toArray(new String[set.size()])){
                    if(compare(word,tmpStr)){
                        que.offer(word);
                        set.remove(word);
                    }
                }
            }
            answer++;
        }

        return answer;
    }
     */
}
