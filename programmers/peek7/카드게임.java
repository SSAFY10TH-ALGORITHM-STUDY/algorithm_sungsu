package programmers.peek7;

import java.util.*;

public class 카드게임 {


    private static int N;

    /**
     * N+1을 구하는데 세가지 방법이 있음
     * 첫번째. 현재 내가 손에 들고 있는 카드(hands)로 파악해보기
     * 두번째. 현재 내가 손에 들고 있는 카드와 뽑을 카드(draw)로 파악해보기
     * 세번째. draw로만 파악해보기
     * <p>
     * 만약 세가지 경우 모두 만족하지 않는다면 라운드는 증가하지 않을 것이다.
     */
    private static boolean canGoToNextRound(Set<Integer> s, Set<Integer> matching) {
        for (int card : s) {
            int matchingCard = (N + 1) - card;
            // System.out.println(matching.toString());
            // System.out.println(card+ " " + matchingCard);
            // 아 n + 1에서 card 를 뺐는데 남은 값이 존재한다는건 즉 n + 1이 가능하다는거니까
            // hashset에서 쓰기 좋을듯, 왜냐하면 HashSet은 중복된 값이 없으니까. N+1에서 card를 뺀 값이 set에 존재한다는건 즉, 그 두 조합이 N+1이 된다는 의미이므로.
            if (matching.contains(matchingCard)) {
                s.remove(card);
                matching.remove(matchingCard);

                return true;
            }
        }

        return false;
    }

    public static int solution(int coin, int[] cards) {
        int answer = 1;
        N = cards.length;
        Set<Integer> hands = new HashSet<>(); // 내가 현재 손에 들고 있는 카드
        Set<Integer> draw = new HashSet<>(); // 뽑을 카드

        // 처음 N/3개의 카드를 손에 가져간다.
        for (int i = 0; i < N / 3; i++) {
            hands.add(cards[i]);
        }

        int nextIdx = N / 3;

        while (nextIdx < N) {
            for (int i = 0; i < 2; i++) {
                draw.add(cards[nextIdx++]);
            }

            // 내가 보유한 카드들 중에서 두 수를 뽑았을 때 N + 1이 가능하다 그럼 그 두 수를 버리고 다음 라운드 진행
            if (hands.size() >= 2 && canGoToNextRound(hands, new HashSet<>(hands))) {
                answer++;
            }
            // 임시로 뽑아놓은 draw HashSet과 hands에서 두 수의 합이 N + 1이 가능한 경우가 존재할 때
            // draw에서 하나의 수만 빼기 때문에 코인 1개가 반드시 존재해야 한다.
            else if (hands.size() >= 1 && coin >= 1 && canGoToNextRound(hands, new HashSet<>(draw))) {
                answer++;
                coin--;
            }
            // draw에서 두 수의 합이 N + 1일 때 코인을 두개 써서 두 수를 버리고 코인 2개를 뺀 뒤 라운드 증가
            // 두 개를 뽑을 땐 코인 두개가 있어야한다.
            else if (coin >= 2 && canGoToNextRound(draw, new HashSet<>(draw))) {
                answer++;
                coin -= 2;
            } else {
                break;
            }
        }

        return answer;
    }
}
