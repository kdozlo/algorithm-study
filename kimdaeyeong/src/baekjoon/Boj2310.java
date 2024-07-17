package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 백준 2310
 * 어드벤처 게임
 * 골드4
 * https://www.acmicpc.net/problem/2310
 */
public class Boj2310 {

    static int n; // 방의 수
    static List<Integer>[] room;
    static boolean isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while((n = Integer.parseInt(st.nextToken())) != 0) {
            room = new List[n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                room[i] = new ArrayList<>();

                // 방 종류
                String roomKind = st.nextToken();
                if (roomKind.equals("E")) {
                    room[i].add(1);
                } else if (roomKind.equals("L")) {
                    room[i].add(2);
                } else if (roomKind.equals("T")) {
                    room[i].add(3);
                }

                // 방 금액
                room[i].add(Integer.parseInt(st.nextToken()));

                // 갈 수 있는 방 목록들
                while (st.hasMoreTokens()) {
                    int cur = Integer.parseInt(st.nextToken());
                    if(cur == 0)
                        break;

                    room[i].add(cur);
                }
            }

            isPossible = false;
            dfs(0, new boolean[n], 0);
            if(isPossible)
                sb.append("Yes").append("\n");
            else
                sb.append("No").append("\n");

            st = new StringTokenizer(br.readLine());
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int cur, boolean[] visited, int money) {
        if(isPossible)
            return;

        if(cur == n - 1) {
            if(room[cur].get(0) == 3) {
                if(money < room[n-1].get(1))
                    return;
            }

            isPossible = true;

            return;
        }

        for(int i = 2; i < room[cur].size(); i++) {
            int next = room[cur].get(i) - 1;
            if(room[cur].get(0) == 1) {
                if(visited[next])
                    continue;
                visited[next] = true;
                dfs(next, visited, money);
            } else if(room[cur].get(0) == 2) {
                if(visited[next])
                    continue;
                visited[next] = true;
                if(room[cur].get(1) > money)
                    dfs(next, visited, room[cur].get(1));
                else
                    dfs(next, visited, money);
            } else if(room[cur].get(0) == 3) {
                if(visited[next] || room[cur].get(1) > money)
                    continue;

                visited[next] = true;
                dfs(next, visited, money - room[cur].get(1));
            }
            visited[next] = false;
        }
    }
}
