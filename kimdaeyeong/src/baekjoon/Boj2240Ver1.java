package baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 2240
 * 자두나무
 * 골드5
 * https://www.acmicpc.net/problem/2240
 */
public class Boj2240Ver1 {

    static class Info {
        int treeLocation; // 나무 위치
        int time; // 지속 시간

        public Info(int treeLocation, int time) {
            this.treeLocation = treeLocation;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken()); // 떨어지는 시간
        int W = Integer.parseInt(st.nextToken()); // 최대 움직임 수

        List<Info> infos = new ArrayList<>();
        int cnt = 1;
        int pre = Integer.parseInt(br.readLine());
        infos.add(new Info(0, 0));
        for(int i = 1; i < T; i++) {
            int cur = Integer.parseInt(br.readLine()); // 나무 위치 1, 2
            if(cur == pre) {
                cnt++;
            } else {
                infos.add(new Info(pre, cnt));
                cnt = 1;
                pre = cur;
            }
        }
        infos.add(new Info(pre, cnt));

        int[][] dp = new int[infos.size()][W + 1];
        for(int i = 1; i < infos.size(); i++) {
            Info cur = infos.get(i);

            for(int j = 0; j <= W; j++) {
                // 안 움직일때
                if(j == 0) {
                    if(cur.treeLocation == 1) {
                        dp[i][j] = dp[i - 1][j] + cur.time;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                    continue;
                }

                // 움직일때
                if(j % 2 == 0) {
                    if(cur.treeLocation == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j] + cur.time, dp[i - 1][j - 1]);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + cur.time, dp[i - 1][j]);
                    }
                } else {
                    if(cur.treeLocation == 2) {
                        dp[i][j] = Math.max(dp[i - 1][j] + cur.time, dp[i - 1][j - 1]);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + cur.time, dp[i - 1][j]);
                    }
                }
            }
        }

        int answer = 0;
        for(int j = 0; j <= W; j++)
            answer = Math.max(answer, dp[infos.size() - 1][j]);

        System.out.println(answer);
    }
}
