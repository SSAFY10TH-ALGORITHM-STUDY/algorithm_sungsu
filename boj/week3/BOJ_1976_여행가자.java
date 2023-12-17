package boj.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 풀이 참고 링크 : https://steady-coding.tistory.com/109
 *
 * * 문제 핵심
 * 최적화된 경로를 찾는게 아닌 경로 가능 유무를 파악하는 문제이기 때문에 union & find로 문제를 해결할 수 있다.
 *
 * * 문제 풀이
 * 1. 가장 첫 번째 도시인 1을 루트로 지정한다.
 * 2. 인접 행렬 값이 1인 도시를 union(a,b) 연산을 하여 부모 노드를 지정한다.
 *  2-1. 1이 루트노드이므로 작은 값이 루트 노드, 큰 값이 자식 노드가 되도록 설정한다.
 * 3. 여행 계획으로 주어진 도시들의 부모노드가 모두 일치하는지 확인한다. 만약 일치하지 않는다면 NO를 출력한다.
 *
 * 메모리 : 15808
 * 시간 : 132
 */
public class BOJ_1976_여행가자 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    static int[] rootList;

    static int cityCnt, edgeCnt;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        cityCnt = Integer.parseInt(br.readLine().trim());
        edgeCnt = Integer.parseInt(br.readLine().trim());

        rootList = new int[cityCnt+1];

        for (int i = 1; i <= cityCnt; i++) {
            rootList[i] = i;
        }

        for (int i = 1; i <= cityCnt; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 1; j <= cityCnt; j++) {
                int value = Integer.parseInt(st.nextToken());

                if(value == 1) union(i,j);
            }
        }

        st = new StringTokenizer(br.readLine().trim());

        int root = find(Integer.parseInt(st.nextToken()));

        boolean flag = false;

        for (int i = 0; i < edgeCnt-1; i++) {
            int value = Integer.parseInt(st.nextToken());

            if(root != find(value)){
                flag = true;
                break;
            }
        }

        if (flag) System.out.println("NO");
        else System.out.println("YES");
    }

    private static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if(i > j){
            rootList[i] = j;
        }else{
            rootList[j] = i;
        }
    }

    private static int find(int i) {
        if(i == rootList[i]) return i;
        int fi = find(rootList[i]); // 부모노드를 찾아나간다.
        return fi;
    }
}