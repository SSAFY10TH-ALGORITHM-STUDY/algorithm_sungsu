package programmers.week5.dfsbfs;

public class 타켓넘버 {
    static int answer;

    static boolean[] selected;

    static void powerSet(int depth, int[] numbers, int target){
        if(depth == numbers.length){
            int value = 0;
            for(int i = 0; i < numbers.length; i++){
                if(selected[i]){
                    value += numbers[i];
                }else{
                    value -= numbers[i];
                }

            }
            if(value == target) answer++;

            return;
        }

        selected[depth] = true;
        powerSet(depth+1, numbers, target);
        selected[depth] = false;
        powerSet(depth+1, numbers, target);
    }

    public int solution(int[] numbers, int target) {
        answer = 0;

        selected = new boolean[numbers.length];

        powerSet(0, numbers, target);

        return answer;
    }
}
