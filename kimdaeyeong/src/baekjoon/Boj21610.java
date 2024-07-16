package baekjoon;

import java.util.*;
import java.io.*;

/**
 * 백준 21610
 * 마법사 상어와 비바라기
 * 골드5
 * https://www.acmicpc.net/problem/21610
 */
public class Boj21610 {

    static int n; // size of array
    static int m; // number of move
    static int[][] a; // amount of water
    static int d; // diraction
    static int s; // move distance
    static boolean[][] cloud; // current cloud location

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][n];
        cloud = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloud[n - 2][0] = true;
        cloud[n - 2][1] = true;
        cloud[n - 1][0] = true;
        cloud[n - 1][1] = true;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            moveCloud(d, s);

            makeCloud();
        }

        int sum = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sum += a[i][j];
            }
        }

        System.out.println(sum);
    }

    public static void moveCloud(int d, int s) {
        boolean[][] temp = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!cloud[i][j])
                    continue;

                int nextI = i + dx[d - 1] * s;
                int nextJ = j + dy[d - 1] * s;

                if(nextI > 0)
                    nextI = nextI % n;
                if(nextJ > 0)
                    nextJ = nextJ % n;
                if(nextI < 0)
                    nextI = n - (nextI * -1 % n);
                if(nextJ < 0)
                    nextJ = n - (nextJ * -1 % n);

                if(nextI == n)
                    nextI %= n;
                if(nextJ == n)
                    nextJ %= n;

                temp[nextI][nextJ] = true;
                a[nextI][nextJ] += 1;
            }
        }

        for(int i = 0; i < n; i++)
            cloud[i] = temp[i].clone();

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!cloud[i][j])
                    continue;

                a[i][j] += waterCopy(i, j);
            }
        }
    }

    public static int waterCopy(int x, int y) {
        int cnt = 0;

        for(int i = 1; i < 8; i += 2) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextX >= n | nextY < 0 || nextY >= n)
                continue;

            if(a[nextX][nextY] > 0)
                cnt++;
        }

        return cnt;
    }

    public static void makeCloud() {
        boolean[][] temp = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!cloud[i][j] && a[i][j] > 1) {
                    a[i][j] -= 2;
                    temp[i][j] = true;
                }
            }
        }

        for(int i = 0; i < n; i++)
            cloud[i] = temp[i].clone();
    }
}
