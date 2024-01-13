package programmers.peek7;

/**
 A가 승리할 확률을 가장 높이기 위해 A가 골라야 하는 주사위 번호를 오름차순으로 1차원 정수 배열에
 담아 return 하도록 하시오.
 승리할 확률이 가장 높은 주사위 조합이 유일한 경우만 주어집니다.

 - 주사위의 개수는 총 10개까지가 가능하고.
 - 하나의 주사위는 6개의 수를 담으면서
 - 주사위 값의 크기는 최대 100이다.
 - 완탐으로 풀게되면
 - 하나의 주사위당 6X6의 경우의 수가 생긴다
 - 즉 4개의 주사위가 있다면 총 경우의 수는 1296(36X36)이 된다
 - 10개의 주사위라면 36^5가 된다.
 = 60466176 따라서 완탐으로 해결이 가능하다.

 - 부분집합과 그냥 집합을 사용하면
 - 부분집합으로 주사위를 결정하고
 - 집합을 사용해서 두 수의 크기 비교를 한 다음에 가장 큰 승을 가지고 있는 주사위 번호를 출력한다.

 가장 큰 승을 가지고 있는 주사위 번호를 int[] result 배열에 담는다.

 - A가 뽑은 주사위에서 나올 수 있는 모든 합을 구하고 aArr 배열에 저장한다.
 - B가 뽑은 주사위에서 나올 수 있는 모든 합을 구한다 bArr 배열에 저장한다.

 aArr의 0부터 size-1의 수를 bArr를 이분 탐색하여 승리하는 수의 개수를 구한 다음
 tmpWinCnt에 저장한다.
 그렇게 총 이기는 수를 구한다.

 이 과정을 모든 A의 주사위 경우의 수만큼 구한 다음 가장 크게 이기는 경우를 저장하여 출력한다.
 */
public class 주사위고르기 {
    /*
       static int size, idx;
    static int[] result;
    static int[][] map;
    static int[] selected;
    static int[] selectedA;
    static int[] selectedB;
    static int maxWinCnt;
    static ArrayList<Integer> A;
    static ArrayList<Integer> B;
    static ArrayList<Integer> aArr;
    static ArrayList<Integer> bArr;

    static void combination(int depth, int start){
        if(depth == size/2){
            HashSet<Integer> aHash = new HashSet<>();

            A = new ArrayList<>();
            B = new ArrayList<>();
            aArr = new ArrayList<>();
            bArr = new ArrayList<>();

            for(int i = 0; i < size/2; i++){
                aHash.add(selected[i]);
            }

            // A와 B 주사위를 각각 size/2 개씩 나눠 고른다
            for(int i = 0; i < size; i++){
                if(aHash.contains(i+1)){
                    A.add(i+1);
                }else{
                    B.add(i+1);
                }
            }

            makeSumAArr(0,0);
            makeSumBArr(0,0);

            int tmpWinCnt = findWinCnt();

            if(tmpWinCnt > maxWinCnt){
                maxWinCnt = tmpWinCnt;
                int idx = 0;
                for(int i = 0; i < size/2; i++){
                    result[idx++] = selected[i];
                }
            }

            // System.out.println(tmpWinCnt);
            return;
        }

        for(int i = start; i <=size; i++){
            selected[depth] = i;
            combination(depth+1,i+1);
        }
    }

    // A가 뽑은 주사위에서 나올 수 있는 합의 모든 경우를 aArr에 저장
    static void makeSumAArr(int depth, int sum){
        if(depth == size/2){
            aArr.add(sum);
            return;
        }

        for(int i = 0; i < 6; i++){
            makeSumAArr(depth+1, sum + map[A.get(depth)-1][i]);
        }
    }

    // B가 뽑은 주사위에서 나올 수 있는 합의 모든 경우를 aArr에 저장
    static void makeSumBArr(int depth, int sum){
        if(depth == size/2){
            bArr.add(sum);
            return;
        }

        for(int i = 0; i < 6; i++){
            makeSumBArr(depth+1, sum + map[B.get(depth)-1][i]);
        }
    }

    // 이분탐색
    static int findWinCnt(){
        int tmpWinCnt = 0;

        Collections.sort(bArr);
        Collections.sort(aArr);


        for(Integer a : aArr){
            int leftPoint = 0;
            int rightPoint = bArr.size();
            while(leftPoint + 1 < rightPoint){
                int mid = (leftPoint + rightPoint)/2;
                if(a > bArr.get(mid)){
                    leftPoint = mid;
                }else{
                    rightPoint = mid;
                }
            }
            tmpWinCnt += leftPoint;
        }
        // System.out.println(tmpWinCnt);

        return tmpWinCnt;
    }

    public int[] solution(int[][] dice) {
        int[] answer = {};

        // answer의 idx
        idx = 0;

        // 주사위 길이
        size = dice.length;

        map = new int[size][6];

        selected = new int[size/2];

        result = new int[size/2];

        maxWinCnt = Integer.MIN_VALUE;

        for(int row = 0; row < size; row++){
            for(int col = 0; col < 6; col++){
                map[row][col] = dice[row][col];
            }
        }

        selectedA = new int[size/2];
        selectedB = new int[size/2];

        combination(0,1);

        Arrays.sort(result);

        return result;
    }
}
     */
}
