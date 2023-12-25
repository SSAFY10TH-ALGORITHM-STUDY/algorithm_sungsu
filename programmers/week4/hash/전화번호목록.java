package programmers.week4.hash;

import java.util.Arrays;

/**
 * 주어진 배열에서 접두어가 있는지 확인한다.
 *
 * 1. 오름차순으로 정렬한다.
 * 2. startsWith 메서드를 사용하여 접두어를 파악한다.
 * 접두어가 있다면 false를 없다면 true를 반환한다.
 */
public class 전화번호목록 {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                System.out.println("false");
                break;
            }
        }


    }
}
