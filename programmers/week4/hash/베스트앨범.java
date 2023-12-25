package programmers.week4.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 장르별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려고 한다.
 *
 * 1. 장르별로 두 개씩 모아야 한다.
 * 2. 장르별로 가장 많이 재생된 곡들을 먼저 담는다.
 *
 * classic : 1450
 * pop : 3100
 *
 * genre
 * number // 고유번호
 * totalPlayCnt
 * playCnt
 *
 * totalPlayCnt로 내림차순
 * totalPlayCnt가 같으면서 playCnt가 같으면 고유번호 오름차순
 *
 * genre별로 HashMap 만들어 놓고 앨범에 수록될때마다 +1해주자
 */
public class 베스트앨범 {

    static class Data implements Comparable<Data>{
        public String genres;
        public int playCnt;
        public int pkno;

        public Data(String genres, int playCnt, int pkno) {
            this.genres = genres;
            this.playCnt = playCnt;
            this.pkno = pkno;
        }

        @Override
        public int compareTo(Data o){
            if(o.playCnt == this.playCnt){
                return this.pkno - o.pkno; // 재생횟수가 같을 때는 고유 번호가 낮은 순서대로
            }
            return o.playCnt-this.playCnt; // 내림차순으로 정렬
        }

        @Override
        public String toString() {
            return "Data{" +
                    "genres='" + genres + '\'' +
                    ", playCnt=" + playCnt +
                    ", pkno=" + pkno +
                    '}';
        }
    }

    static ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            String key = genres[i];
            int value = plays[i];

            map.put(key, map.getOrDefault(key, 0)+value);
        }

        ArrayList<Data> arr = new ArrayList<>();

        // 장르별로 오름차순을 어떻게 해줄것인가?
        // 총 플레이 횟수가 많은 것을 기준으로 내림차순하여 arr 배열에 저장
        // 만약 총 플레이 횟수가 같다면 고유번호를 기준으로 오름차순 정렬
        for(String key : map.keySet()){
            Data data = new Data(key, map.get(key), 0);
            arr.add(data);
        }

        Collections.sort(arr);


        // 1. arr size만큼 돈다
        // 2. 해당 장르 고유 번호를 ArrayList에 저장한다.
        // 3. 값이 큰 값부터 정렬한다.
        // 4. 정렬된 값의 인덱스를 answer 배열에 차례대로 저장한다.
        // 조건 : 장르 별로 가장 많이 재생된 노래를 최대 두 개까지 모아 베스트 앨범을 출시하므로 2번 노래는 수록되지 않습니다.

        // 1
        for (int i = 0; i < arr.size(); i++) {
            int count = 0; // 2개까지만 담기 위해
            // 2
            ArrayList<Data> tmpArr = new ArrayList<>();
            // 총 플레이 횟수를 기준으로 내림차순 되어있는 arr에서 장르를 뽑는다.
            String genre = arr.get(i).genres;
            // 해당 장르와 같은 곡들을 tmpArr에 담는다.
            for (int j = 0; j < plays.length; j++) {
                if(genres[j].equals(genre)) {
                    tmpArr.add(new Data(genre, plays[j], j));
                }
            }

            // 3
            // 많이 재생된 곡을 기준으로 내림차순 정렬한다.
            Collections.sort(tmpArr);
//            System.out.println(tmpArr.toString());
            // 4
            // 앨범에 장르별로 두곡씩 담는다.
            for(Data tmp : tmpArr){
                answer.add(tmp.pkno);
                count++;
                if(count >= 2) break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(solution(genres, plays).toString());
    }
}
