package baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 22251
 * 빌런 호석
 * 골드5
 * https://www.acmicpc.net/problem/22251
 */
public class Boj22251 {

    // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    static boolean[][] digit = {
            {true, true, true, false, true, true, true},
            {false, false, false, false, false, true, true},
            {false, true, true, true, true, true, false},
            {false, false, true, true, true, true, true,},
            {true, false, false, true, false, true, true},
            {true, false, true, true, true, false, true},
            {true, true, true, true, true, false, true},
            {false, false, true, false, false, true, true},
            {true, true, true, true, true, true, true},
            {true, false, true, true, true, true, true},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 총 엘리베이터 층수
        int k = Integer.parseInt(st.nextToken()); // k자리 수
        int p = Integer.parseInt(st.nextToken()); // 최대 반전 가능 횟수
        int x = Integer.parseInt(st.nextToken()); // 현재 층수

        int answer = 0;


        int[][] change = new int[10][10]; // i에서 j로 숫자를 바꿀 때 반전 횟수
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                change[i][j] = dif(i, j);
            }
        }

        // 1부터 n(엘리베이터 마지막 층수)까지의 숫자와 현재 층수를 비교하여 몇번 반전 해야 바꿀 수 있는지 확인
        for(int i = 1; i <= n; i++) {
            if(i == x)
                continue;

            int curP = 0;
            boolean flag = true;
            int n1 = x;
            int n2 = i;

            // 자리수 별 반전 횟수 구하기
            for(int j = 1; j <= k; j++) {
                curP += change[n1 % 10][n2 % 10];
                n1 /= 10;
                n2 /= 10;
                // 최대 반전 횟수 초과인 경우
                if(curP > p) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    // n1에서 n2가 되기 위한 반전 횟수
    public static int dif(int n1, int n2) {
        boolean[] b1 = digit[n1].clone();
        boolean[] b2 = digit[n2].clone();

        int cnt = 0;

        for(int i = 0; i < 7; i++) {
            if(b1[i] != b2[i])
                cnt++;
        }

        return cnt;
    }
}
