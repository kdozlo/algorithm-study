package baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 18427
 * 함께 블록 쌓기
 * 골드4
 * https://www.acmicpc.net/problem/18427
 */
public class Boj18427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생수
        int M = Integer.parseInt(st.nextToken()); // 블록 수
        int H = Integer.parseInt(st.nextToken()); // 구하는 높이

        int[][] dp = new int[N + 1][H + 1];

        List<Integer>[] l = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            l[i] = new ArrayList<>();
            l[i].add(0); // 아무것도 안내는 경우
            while(st.hasMoreTokens()) {
                l[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0; i <= N; i++)
            dp[i][0] = 1;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= H; j++) {

                // i번째가 h를 내는 경우
                for(int h : l[i]) {
                    if(j >= h) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - h]) % 10007;
                    }
                }
            }
        }

        System.out.println(dp[N][H]);
    }

}
