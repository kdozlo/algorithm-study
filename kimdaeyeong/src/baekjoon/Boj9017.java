package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 백준 9017
 * 크로스 컨트리
 * 실버3
 * https://www.acmicpc.net/problem/9017
 */
public class Boj9017 {

    static int t; // 테스트 케이스 수
    static int n; // 팀원 점수 수
    static Map<Integer, List<Integer>> m; // 팀원 등수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(st.nextToken());

        while(t-- > 0) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] team = new int[n];
            for(int i = 0; i < n; i++) {
                team[i] = Integer.parseInt(st.nextToken());
            }
            Map<Integer, Integer> teamCnt = new HashMap<>();

            for(int cur : team) {

                if(teamCnt.containsKey(cur)) {
                    teamCnt.put(cur, teamCnt.get(cur) + 1);
                } else {
                    teamCnt.put(cur, 1);
                }
            }

            m = new HashMap<>();
            int rank = 1;
            for(int cur : team) {
                if(teamCnt.get(cur) != 6)
                    continue;

                if(m.containsKey(cur)) {
                    m.get(cur).add(rank);
                } else {
                    m.put(cur, new ArrayList<>());
                    m.get(cur).add(rank);
                }

                rank++;
            }
            int answer = 0;
            int min = Integer.MAX_VALUE;
            int fiveRank = 1001;
            for(int key : m.keySet()) {

                if(m.get(key).size() == 6) {
                    int score = 0;

                    for(int i = 0; i < 4; i++)
                        score += m.get(key).get(i);

                    if(score < min) {
                        min = score;
                        answer = key;
                        fiveRank = m.get(key).get(4);
                    } else if(score == min) {
                        if(m.get(key).get(4) < fiveRank) {
                            answer = key;
                            fiveRank = m.get(key).get(4);
                        }
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
