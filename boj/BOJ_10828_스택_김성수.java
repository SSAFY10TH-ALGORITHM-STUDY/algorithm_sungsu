package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 1. StackTemp 클래스를 생성한다.
 * 2. StackTemp 클래스 내부에 push, pop, size, empty, top 메서드를 생성하고 각각 조건에맞게 구현한다.
 * 3. 주어진 입력(push, pop, size, empty, top)에 따라 메서드를 실행하고 결과를 반환한다.
 *
 *
 */

public class BOJ_10828_스택_김성수 {

    static class StackTemp{
        private ArrayList<Integer> stackArr;

        private int stackArrSize = 0;

        public StackTemp(){
            stackArr = new ArrayList<>();
        };

        public void push(Integer item){
            stackArrSize++;
            stackArr.add(item);
        }

        public int pop(){
            int value = 0;
            if(stackArrSize > 0){
                stackArrSize--;
                value = stackArr.get(stackArrSize);
                stackArr.remove(stackArrSize);
            }else if(stackArrSize == 0){
                return -1;
            }
            return value;
        }

        public int size(){
            return stackArrSize;
        }

        public int empty(){
            if(stackArrSize == 0){
                return 1;
            }else{
                return 0;
            }
        }

        public int top(){
            if(stackArrSize==0) return -1;
            else{
                return (int)stackArr.get(stackArrSize-1);
            }
        }
    }

    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StackTemp stack = new StackTemp();

        int commandCnt = Integer.parseInt(br.readLine().trim());

        for (int idx = 0; idx < commandCnt; idx++) {
            st = new StringTokenizer(br.readLine().trim());

            String command = st.nextToken();

            if("push".equals(command)){
                int item = Integer.parseInt(st.nextToken());
                stack.push(item);
            }else if("pop".equals(command)){
                sb.append(stack.pop()+"\n");
            }else if("size".equals(command)){
                sb.append(stack.size()+"\n");
            }else if("empty".equals(command)){
                sb.append(stack.empty()+"\n");
            }else if("top".equals(command)){
                sb.append(stack.top()+"\n");
            }
//            System.out.println(stack.top());
        }

        System.out.println(sb);
    }
}
