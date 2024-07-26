package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 3584
 * 가장 가까운 공통 조상
 * LCA(Lowest Common Ancestor) 알고리즘 적용
 * 골드4
 * https://www.acmicpc.net/problem/3584
 */
public class Boj3584LCA {

    static int N; // 노드의 수
    static int[] parent; // 부모 자식 배열

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine()); // 노드의 수
            parent = new int[N + 1]; // 부모 자식 배열

            for(int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
               parent[b] = a; // 자식에서 부모를 갈 수 있도록 설정, 조상을 구하는 거니까
            }

            st = new StringTokenizer(br.readLine());
            int T1 = Integer.parseInt(st.nextToken());
            int T2 = Integer.parseInt(st.nextToken());

            sb.append(solution(T1, T2)).append("\n");
        }
        System.out.println(sb);
    }

    static int solution(int x, int y) {
        boolean[] visited = new boolean[N + 1];

        // x의 조상들 방문
        while(x > 0) {
            visited[x] = true;
            x = parent[x];
        }

        // y의 조상들 방문하면서 x의 조상과 겹치는 경우가 최소 공통 조상
        while(y > 0) {
            if(visited[y])
                return y;

            y = parent[y];
        }
        return -1;
    }
}
