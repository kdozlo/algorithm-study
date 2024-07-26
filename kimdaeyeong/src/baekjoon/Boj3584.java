package baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 3584
 * 가장 가까운 공통 조상
 * 골드4
 * https://www.acmicpc.net/problem/3584
 */
public class Boj3584 {

    static int N; // 노드의 수
    static List<Integer>[] g; // 그래프
    static int T1; // 공통 조상을 구해야하는 값
    static int T2; // 공통 조상을 구해야하는 값
    static List<Integer>[] T1Child; // 깊이에 따른 자신의 조상
    static List<Integer>[] T2Child; // 깊이에 따른 자신의 조상

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            g = new ArrayList[N + 1];
            T1Child = new ArrayList[N];
            T2Child = new ArrayList[N];

            // 초기화
            for(int i = 1; i < N + 1; i++)
                g[i] = new ArrayList<>();

            // 초기화
            for(int i = 0; i < N; i++) {
                T1Child[i] = new ArrayList<>();
                T2Child[i] = new ArrayList<>();
            }

            for(int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                g[b].add(a); // 자식에서 부모를 갈 수 있도록 설정, 조상을 구하는 거니까
            }

            st = new StringTokenizer(br.readLine());
            T1 = Integer.parseInt(st.nextToken());
            T2 = Integer.parseInt(st.nextToken());

            dfs(T1, 0, new boolean[N + 1], T1Child);
            dfs(T2, 0, new boolean[N + 1], T2Child);

            sb.append(findMin()).append("\n");
        }
        System.out.println(sb);
    }

    // 조상 구하기
    static void dfs(int cur, int d, boolean[] visited, List<Integer>[] TChild) {

        visited[cur] = true;
        TChild[d].add(cur); // d 깊이에서의 조상 노드 저장

        for(int i = 0; i < g[cur].size(); i++) {
            int next = g[cur].get(i);

            if(visited[next])
                continue;

            dfs(next, d + 1, visited, TChild);
        }
    }

    // 두 노드의 가장 가까운 공통 조상 구하기
    static int findMin() {

        int min = Integer.MAX_VALUE; // 깊이 합의 최소값
        int answer = -1; // 공통 조상
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < T1Child[i].size(); j++) {
                int c1 = T1Child[i].get(j); // T1의 조상

                for(int x = 0; x < N; x++) {
                    for(int y = 0; y < T2Child[x].size(); y++) {
                        int c2 = T2Child[x].get(y); // T2의 조상

                        if(c1 == c2) {
                            if(i + x < min) {
                                min = i + x;
                                answer = c1;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}
