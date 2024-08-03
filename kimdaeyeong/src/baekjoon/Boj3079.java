package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 백준 3079
 * 입국심사
 * 골드5
 * https://www.acmicpc.net/problem/3079
 */
public class Boj3079 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 입국심사대 개수
        int M = Integer.parseInt(st.nextToken()); // 친구들 수
        int[] t = new int[N]; // 입국심사대별 걸리는 시간

        int max = 1;
        for(int i = 0; i < N; i++) {
            t[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, t[i]);
        }

        long left = 1;
        long right = (long) max * M; // 초
        long answer = right;
        while(left <= right) {
            long mid = left + ((right - left) / 2);

            long sum = 0; // 처리할 수 있는 사람 수

            for(int i : t) {
                sum += mid / i;
                if(sum > M)
                    break;
            }

            if(sum >= M) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);

    }
}
