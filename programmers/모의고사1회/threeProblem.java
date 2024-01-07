package programmers.모의고사1회;

/**
 queries에 담긴 순서대로 n세대의 p번째 개체의 형질을 문자열 배열에 담아 return 하도록 하시오

 RR은 RR만
 Rr은 R:Rr:rr이 1:2:1 비율
 rr은 rr만

 queries[1,1]에서 행은 세대를, 열은 해당 세대에서 몇번째인지를 나타낸다.

 완탐으로 풀려면 n이 16까지 존재하므로 4^16
 2^32인데, 이러면 수가 너무 커져서 완탐은 불가능

 1세대 = 4^0
 2세대 = 4^1
 3세대 = 4^2
 ..
 n세대 = 4^(n-1)

 여기서 RR과 rr은 순종만 나오므로 열이 1 ~ 4^(n-2)사이에 있다면 RR 또는
 열이 4^(n-2)*3+1 ~ 4^(n-1)사이에 있다면 rr
 만약 그렇지 않다면 열을 % 4한 뒤에 나머지 값이 1이라면 RR, 2 ~ 3이라면 Rr, 4라면 rr이다.

 4,26

 콩의 개수 : 4^4-1 : 32
 1 ~ 4^4-2 (1~16): RR
 4^4-2*3 > col (~32): rr
 else
 col % 4 == 1 : RR
 col % 4 == 0 : rr
 else Rr

 3,5
 4^2 = 16
 1~4 = RR
 4*3+1~ = rr
 5 ~ 4*3
 col % 4 = 1 : Rr
 col % 4 = 0 : rr
 else Rr

 채점 : 60점
 */
public class threeProblem {
    /*
    import java.util.*;

class Solution {
    public ArrayList<String> solution(int[][] queries) {
        String[] answer = {};

        ArrayList<String> result = new ArrayList<>();



        for(int i = 0; i < queries.length; i++){
            int generation = queries[i][0];
            int col = queries[i][1];

            if(generation == 1){
                result.add("Rr");
                continue;
            }
//             System.out.println(generation);
//             System.out.println(col);

            if(generation == 2){
                if(col == 1) result.add("RR");
                else if(col == 4) result.add("rr");
                else if(col == 2 || col == 3) result.add("Rr");
                continue;
            }

            if(generation > 2){
                int key = generation-1;
                // System.out.println(Math.pow(4,key)-Math.pow(4,key-1));
                // System.out.println("??:" + Math.pow(4,key)*3);
                // System.out.println("값: " + Math.pow(4,key)*Math.pow(4,key-1)-1);
                if(col <= Math.pow(4,key-1)) {
                    result.add("RR");
                    System.out.println("asd");
                }
                else if(col > Math.pow(4,key)-Math.pow(4,key-1)) {
                    result.add("rr");
                    System.out.println("xcxc");
                }
                else
                {
                    if(col % 4 == 1) {
                        result.add("RR");
                        System.out.println("54545");
                    }
                    else if(col % 4 == 0){
                        result.add("rr");
                        System.out.println("123123");
                    }
                    else {
                        System.out.println("llll");
                        result.add("Rr");
                    }
                }
            }
        }

        return result;
    }
}
     */
}
