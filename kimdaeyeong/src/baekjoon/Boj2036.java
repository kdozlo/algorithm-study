package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 백준 2036
 * 수열의 점수
 * 골드4
 * https://www.acmicpc.net/problem/2036
 */
public class Boj2036 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 정수의 개수
        List<Long> plus = new ArrayList<>();
        Long answer = 0L;
        boolean zero = false;
        List<Long> minus = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            if(num > 1L)
                plus.add(num);
            else if(num < 0)
                minus.add(num);
            else if(num == 1L)
                answer++;
            else
                zero = true;
        }

        Collections.sort(plus);
        Collections.sort(minus);

        int plusSize = plus.size();
        int minusSize = minus.size();

        for(int i = plusSize - 1; i > 0; i-=2) {
            answer += plus.get(i) * plus.get(i - 1);
        }

        if(plusSize % 2 != 0)
            answer += plus.get(0);


        for(int i = 0; i < minusSize - 1; i+=2) {
            answer += minus.get(i) * minus.get(i + 1);
        }

        if(minusSize % 2 != 0 && !zero) {
            answer += minus.get(minusSize - 1);
        }

        System.out.println(answer);
    }
}
