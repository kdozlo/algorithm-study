package baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 4883
 * 삼각 그래프
 * 실버1
 * https://www.acmicpc.net/problem/4883
 */
public class Boj4883 {

    static int n; // 행의 개수
    static int[][] g; // 그래프

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int k = 0; // 테스트 케이스 번호
        while((n = Integer.parseInt(st.nextToken())) != 0) {
            k++;

            g = new int[n][3];
            int[][] dp = new int[n][3];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j  =0; j < 3; j++) {
                    g[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = 1000000;
                }
            }

            // 첫번째 행
            dp[0][1] = g[0][1];
            dp[0][2] = dp[0][1] + g[0][2];

            // 두번째 행
            dp[1][0] = dp[0][1] + g[1][0];
            dp[1][1] = Math.min(Math.min(dp[0][1], dp[0][2]), dp[1][0]) + g[1][1];
            dp[1][2] = Math.min(Math.min(dp[0][1], dp[0][2]), dp[1][1]) + g[1][2];

            // 세번째 행부터
            for(int i = 2; i < n; i++) {

                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + g[i][0];

                dp[i][1] = Math.min(
                        Math.min(
                                Math.min(dp[i - 1][0], dp[i - 1][1])
                                , dp[i - 1][2])
                        , dp[i][0]) + g[i][1];

                dp[i][2] = Math.min(Math.min(dp[i - 1][1], dp[i - 1][2]), dp[i][1]) + g[i][2];
            }

            sb.append(k).append(".").append(" ").append(dp[n - 1][1]).append("\n");
            st = new StringTokenizer(br.readLine());
        }

        System.out.println(sb.toString());
    }
}
