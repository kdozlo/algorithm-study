package baekjoon;

import java.io.*;

/**
 * 백준 1515
 * 수 이어 쓰기
 * 실버3
 * https://www.acmicpc.net/problem/1515
 */
public class Boj1515 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] array = br.readLine().toCharArray();
        int cur = Character.getNumericValue(array[0]);
        int i = 0;

        if(cur == 0)
            cur = 1;

        // 받은 숫자 한자리씩 비교
        while(i != array.length) {

            //받은 숫자의 한자리와 현재 나와야하는 숫자 하나씩 비교
            for(char c : (cur + "").toCharArray()) {
                // 비교하여 같은 숫자인 경우 받은 숫자의 인덱스 하나 증가
                if(c == array[i])
                    i++;

                // 받은 숫자가 마지막 수인 경우 반복문 종료
                if(i == array.length)
                    break;
            }

            // 비교할 숫자 증가
            cur++;
        }

        System.out.println(cur - 1);
    }
}
