package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 백준 12886
 * 돌 그룹
 * 골드4
 * https://www.acmicpc.net/problem/12886
 */
public class Boj12886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[1501][1501];
        int sum = A + B + C;
        int answer = 0;
        visited[A][B] = true;
        visited[B][A] = true;
        if(sum % 3 == 0 && dfs(sum, A, B, visited)) {
            answer = 1;
        }

        System.out.println(answer);
    }

    public static boolean dfs(int sum, int a, int b, boolean[][] visited) {
        int c = sum - a - b;

        if(a == b && b == c) {
            return true;
        }

        int[] array = {a, b, c};
        boolean checked = false;

        for(int i = 0; i < 3; i++) {
            for(int j = i + 1; j < 3; j++) {
                if(array[i] != array[j]) {
                    int na = array[i] > array[j] ? array[i] - array[j] : array[i] * 2;
                    int nb = array[i] < array[j] ? array[j] - array[i] : array[j] * 2;

                    if(!visited[na][nb]) {
                        visited[na][nb] = true;
                        visited[nb][na] = true;

                        checked = dfs(sum, na, nb, visited);
                    }

                    if(checked)
                        return true;
                }
            }
        }

        return false;
    }
}
