package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 백준 12886
 * 돌 그룹
 * 골드4
 * https://www.acmicpc.net/problem/12886
 */
public class Boj12886SlowVer {

    static int answer = 0;
    static Set<String> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        visited = new HashSet<>();
        visited.add(A + "" + B + C);
        dfs(A, B, C);
        System.out.println(answer);
    }

    public static void dfs(int a, int b, int c) {

        if(answer == 1)
            return;

        if(a == b && b == c) {
            answer = 1;
            return;
        }

        int[] array = {a, b, c};
        Arrays.sort(array);
        String s1 = (array[0] + array[0]) + "" + (array[1] - array[0]) + array[2];
        if(!visited.contains(s1)) {
            visited.add(s1);
            dfs(array[0] + array[0], array[1] - array[0], array[2]);
        }

        String s2 = (array[0] + array[0]) + "" + array[1] + (array[2] - array[0]);
        if(!visited.contains(s2)) {
            visited.add(s2);
            dfs(array[0] + array[0], array[1], array[2] - array[0]);
        }

        String s3 = array[0] + "" + (array[1] + array[1]) + (array[2] - array[1]);
        if(!visited.contains(s3)) {
            visited.add(s3);
            dfs(array[0], array[1] + array[1], array[2] - array[1]);
        }
    }
}
