package baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 17485
 * 진우의 달 여행 (Large)
 * 골드5
 * https://www.acmicpc.net/problem/17485
 */
public class Boj17485 {

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열

        int[][] array = new int[N][M];
        int[][][] dp = new int[N][M][3]; // 행, 열, 앞으로 갈 방향(왼쪽 대각, 아래, 오른쪽 대각)
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                for(int d = 0; d < 3; d++)
                    dp[i][j][d] = 1000001;
            }
        }

        for(int j = 0; j < M; j++) {
            for(int d = 0; d < 3; d++) {
                dp[0][j][d] = array[0][j];
            }
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(j - 1 >= 0)
                    dp[i][j][0] = array[i][j] + Math.min(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
                else
                    dp[i][j][0] = array[i][j] + dp[i - 1][j][1];

                if(j - 1 >= 0 && j + 1 < M)
                    dp[i][j][1] = array[i][j] + Math.min(dp[i - 1][j + 1][0], dp[i - 1][j - 1][2]);
                else if(j - 1 >= 0 && j + 1 >= M)
                    dp[i][j][1] = array[i][j] + dp[i - 1][j - 1][2];
                else if(j - 1 < 0 && j + 1 < M)
                    dp[i][j][1] = array[i][j] + dp[i - 1][j + 1][0];

                if(j + 1 < M)
                    dp[i][j][2] = array[i][j] + Math.min(dp[i - 1][j][1], dp[i - 1][j + 1][0]);
                else
                    dp[i][j][2] = array[i][j] + dp[i - 1][j][1];
            }
        }

        int min = Integer.MAX_VALUE;
        for(int j = 0; j < M; j++) {
            for(int d = 0; d < 3; d++) {
                min = Math.min(min, dp[N -1][j][d]);
            }
        }

        System.out.println(min);
    }
}
