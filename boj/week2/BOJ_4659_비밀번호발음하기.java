package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * * 문제 풀이
 * 1. 각각의 조건을 충족하도록 구현한다.
 *
 * 메모리 : 11440
 * 시간 : 76
 */
public class BOJ_4659_비밀번호발음하기 {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        final String isAccept = "is acceptable.\n";
        final String isNotAccept = "is not acceptable.\n";

        ArrayList<String> inputStr = new ArrayList<>();

        while(true){
            String str = br.readLine().trim();
            if(str.equals("end")){
                break;
            }
            inputStr.add(str);
        }

        for (String str : inputStr){
            boolean flag = false; // a,e,i,o,u 중 반드시 하나를 포함하는지 체크한다.
            int sameChar = 0; // 같은 글자가 2개 이상 오는지 체크한다(단, ee와 oo는 제외)
            int consonantThreeCnt = 0; // 자음이 3개이상 오는지 체크한다.
            int gatherThreeCnt = 0; // 모음이 3개이상 오는지 체크한다.
            boolean threeCntFlag = false; // 자음 또는 모음이 3개 이상 존재했는지 체크
            boolean sameCharFlag = false; // 같은 글자가 2개 이상 오는지 체크

            int size = str.length();

            char[] cList = str.toCharArray();

            if(size > 1){
                char tmpChar = ' ';
                for (int i = 0; i < size; i++) {
                    if(cList[i] == 'a' || cList[i] == 'e' || cList[i] == 'o' || cList[i] == 'i' || cList[i] == 'u') {
                        flag = true;
                        gatherThreeCnt++;
                        consonantThreeCnt = 0;
                    }else{
                        consonantThreeCnt++;
                        gatherThreeCnt = 0;
                    }
                    if(gatherThreeCnt == 3 || consonantThreeCnt == 3){
                        threeCntFlag = true;
                    }

                    if(i > 0){
                        if(cList[i] == 'e' || cList[i] == 'o') continue;
                        if(cList[i] == cList[i-1])
                            sameCharFlag = true;
                    }
                }

//                System.out.println(flag);
//                System.out.println(sameCharFlag);
//                System.out.println(threeCntFlag);

                if(!flag){
                    sb.append("<"+str+"> " + isNotAccept);
                    continue;
                }

                if(sameCharFlag){
                    sb.append("<"+str+"> " + isNotAccept);
                    continue;
                }

                if(threeCntFlag){
                    sb.append("<"+str+"> " + isNotAccept);
                    continue;
                }

                sb.append("<"+str+"> " + isAccept);
            }else if(size == 1){
                for (int i = 0; i < size; i++) {
                    if(cList[i] == 'a' || cList[i] == 'e' || cList[i] == 'o' || cList[i] == 'i' || cList[i] == 'u') flag = true;
                }

                if(flag){
                    sb.append("<"+str+"> "+ isAccept);
                    continue;
                }else{
                    sb.append("<"+str+"> " + isNotAccept);
                    continue;
                }
            }
        }
        System.out.println(sb);
    }
}