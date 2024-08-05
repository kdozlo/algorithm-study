package baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 9177
 * 단어 섞기
 * 골드4
 * https://www.acmicpc.net/problem/9177
 */
public class Boj9177BFS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            char[] s1 = st.nextToken().toCharArray();
            char[] s2 = st.nextToken().toCharArray();
            char[] s3 = st.nextToken().toCharArray();

            sb.append("Data set ").append(t).append(": ").append(bfs(s1, s2, s3)).append("\n");
        }

        System.out.print(sb);
    }

    public static String bfs(char[] s1, char[] s2, char[] s3) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[201][201];

        q.add(new int[] {0, 0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[2] == s3.length) {
                return "yes";
            }

            if(cur[0] < s1.length && !visited[cur[0] + 1][cur[1]] &&
                    s1[cur[0]] == s3[cur[2]]) {
                q.add(new int[] {cur[0] + 1, cur[1], cur[2] + 1});
                visited[cur[0] + 1][cur[1]] = true;
            }

            if(cur[1] < s2.length && !visited[cur[0]][cur[1] + 1] &&
                    s2[cur[1]] == s3[cur[2]]) {
                q.add(new int[] {cur[0], cur[1] + 1, cur[2] + 1});
                visited[cur[0]][cur[1] + 1] = true;
            }
        }

        return "no";
    }

}
