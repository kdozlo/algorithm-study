package baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 18429
 * 근손실
 * 실버3
 * https://www.acmicpc.net/problem/18429
 */
public class Boj18429 {

    static int n; // number of kit
    static int k; // decrease per day
    static int[] kit; // exercise kit
    static int answer = 0; // number of over 500 everyday

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        kit = new int[n];
        for(int i = 0; i < n; i++)
            kit[i] = Integer.parseInt(st.nextToken());

        permutation(new boolean[n], new int[n], 0);

        System.out.println(answer);
    }

    public static void permutation(boolean[] checked, int[] array, int depth) {
        if(depth == n) {

            // check over 500 everyday
            if(checkingOver500(array))
                answer++;

            return;
        }

        for(int i = 0; i < n; i++) {
            if(checked[i])
                continue;

            checked[i] = true;
            array[depth] = i;
            permutation(checked, array, depth + 1);
            checked[i] = false;
        }
    }

    public static boolean checkingOver500(int[] array) {

        int cur = 500;
        for(int i : array) {
            cur += kit[i] - k;

            if(cur < 500)
                return false;
        }

        return true;
    }
}
