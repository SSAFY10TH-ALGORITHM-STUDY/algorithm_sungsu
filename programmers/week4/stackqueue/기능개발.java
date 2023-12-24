package programmers.week4.stackqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 현재 진행도 = 93%, 처리 속도 = 1% -> 7일
 * 현재 진행도 = 30%, 처리 속도 = 30% -> 3일
 * 현재 진행도 = 55%, 처리 속도 = 5% -> 9일
 *
 * 현재 진행도 = 95%, 처리 속도 = 1% -> 5일
 * 현재 진행도 = 90%, 처리 속도 = 1% -> 10일
 * 현재 진행도 = 99%, 처리 속도 = 1% -> 1일
 * 현재 진행도 = 99%, 처리 속도 = 1% -> 1일
 * 현재 진행도 = 80%, 처리 속도 = 1% -> 20일
 * 현재 진행도 = 99%, 처리 속도 = 1% -> 1일
 *
 * 5일째에 1개의 기능, 10일째에 3개의 기능, 20일째에 2개의 기능
 * [1,3,2]
 *
 * - Hash(x)
 * - stack
 * 93,30,55
 * 1,30,5
 *
 * 일차별로 함께 진행도가 증가.
 * progress
 * speed
 * dayCnt
 *
 * for i ->
 * progress += speed;
 * dayCnt = i+1;
 *
 * 1. Queue에 순서대로 담는다.
 * 2. 일차마다 모든 progress를 +speed, dayCnt+=1
 *  2-1. progress가 100이 되었다면 que에서 poll(), 그 다음으로 queue에 담긴 값도 100이라면 poll()
 *  poll할 때마다 cnt++, 100이 아닌 값을 만나면 cnt = 0,
 *
 */
public class 기능개발 {

    static class Data{
        int progress;
        int speed;
        int dayCnt;

        public Data(int progress, int speed, int dayCnt){
            this.progress = progress;
            this.speed = speed;
            this.dayCnt = dayCnt;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "progress=" + progress +
                    ", speed=" + speed +
                    ", dayCnt=" + dayCnt +
                    '}';
        }
    }
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        ArrayList<Integer> answerList = new ArrayList<>();

        Queue<Data> dataQueue = new ArrayDeque<>();

        // que에 data 초기화
        for (int i = 0; i < progresses.length; i++) {
            dataQueue.offer(new Data(progresses[i], speeds[i], 0));
        }

        int cnt = 0;

        while(!dataQueue.isEmpty()){
            // 모든 data의 progress, dayCnt를 증가시킨다.
            int len = dataQueue.size();
            for (int i = 0; i < len; i++) {
                Data data = dataQueue.poll();
                data.dayCnt++;
                data.progress += data.speed;
                dataQueue.offer(data);
            }

            // 앞에서부터 100%로 완료된 작업이 있는지 확인한다.
            // 앞에서부터 작업이 완료되어야 하므로 progress = 100%가 아니라면 break한다.
            for (int i = 0; i < len; i++) {
                if(dataQueue.peek().progress < 100) break;
                cnt++;
                dataQueue.poll();
            }

            if(cnt != 0) answerList.add(cnt);

            cnt = 0;
        }

        System.out.println(answerList.toString());
    }
}
