package baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 2240
 * 자두나무
 * 골드5
 * https://www.acmicpc.net/problem/2240
 */
public class Boj2240Ver2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken()); // 떨어지는 시간
        int W = Integer.parseInt(st.nextToken()); // 최대 움직임 수

        int[][] dp = new int[T + 1][W + 1]; // 시간, 움직임 횟수
        for(int i = 1; i <= T; i++) {
            int cur = Integer.parseInt(br.readLine());

            for(int j = 0; j <= W; j++) {
                // 안 움직일때
                if(j == 0) {
                    if(cur == 1) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                    continue;
                }

                // 움직일때
                if(j % 2 == 0) {
                    if(cur == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1]);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                    }
                } else {
                    if(cur == 2) {
                        dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1] );
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 0; i <= W; i++) {
            answer = Math.max(answer, dp[T][i]);
        }

        System.out.println(answer);
    }
}
