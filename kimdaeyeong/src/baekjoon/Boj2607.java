package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 백준 2607
 * 비슷한 단어
 * 실버2
 * https://www.acmicpc.net/problem/2607
 */
public class Boj2607 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 단어 개수
        st = new StringTokenizer(br.readLine());
        Map<Character, Integer> first = makeMap(st.nextToken());// 첫번째 단어 문자 종류와 개수

        int answer = 0;
        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            Map<Character, Integer> next = makeMap(temp); // 비교할 단어 문자 종류와 개수

            Map<Character, Integer> dif = new HashMap<>(); // 첫번째 단어와 비교 단어 차이

            // first쪽이 많으면 +, next쪽이 많으면 -
            for(Character c : first.keySet()) {
                if(next.containsKey(c)) {
                    if(!Objects.equals(first.get(c), next.get(c))) {
                        dif.put(c, first.get(c) - next.get(c));
                    }
                } else {
                    dif.put(c, first.get(c));
                }
            }

            for(Character c : next.keySet()) {
                if(!dif.containsKey(c) && !first.containsKey(c)) {
                    dif.put(c, next.get(c) * -1);
                }
            }

            if(dif.isEmpty()) {
                // 둘의 구성이 아예 같은 경우
                answer++;
            } else if(dif.size() == 1) {
                // 문자 하나가 다른 경우
                for(Character c : dif.keySet())
                    if(dif.get(c) == 1 || dif.get(c) == -1) {
                        answer++;
                    }
            } else if(dif.size() == 2) {
                // 문자 하나를 바꿀 때 비슷한 단어가 될 수 있는 경우
                int sum = 0;
                for(Character c : dif.keySet()) {
                    if(dif.get(c) == 1 || dif.get(c) == -1) {
                        sum += dif.get(c);
                    } else {
                        sum = 2;
                        break;
                    }
                }

                if(sum == 0) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    public static Map<Character, Integer> makeMap(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(Character c : s.toCharArray()) {
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        return map;
    }
}
