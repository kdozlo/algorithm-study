package programmers;

import java.util.*;

/**
 * 프로그래머스 81302
 * 거리두기 확인하기
 * lv2
 * https://school.programmers.co.kr/learn/courses/30/lessons/81302
 */
public class Pg81302 {

    static int[] dx = {-1, 0, 1 ,0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static int result;

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        int[] answer = new int[5];

        for(int k = 0; k < 5; k++) {
            char[][] cur = makePlace(places[k]);
            visited = new boolean[5][5];
            result = 1;

            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(cur[i][j] == 'P' && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j, i, j, visited, cur);
                    }
                    if(result == 0)
                        break;
                }
                if(result == 0)
                    break;
            }
            answer[k] = result;
        }

        System.out.println(Arrays.toString(answer));
    }

    public static char[][] makePlace(String[] place) {
        char[][] cur = new char[5][5];

        for(int j = 0; j < 5; j++) {
            cur[j] = place[j].toCharArray();
        }

        return cur;
    }

    public static void dfs(int x, int y, int curX, int curY, boolean[][] visited, char[][] cur) {

        for(int i = 0; i < 4; i++) {
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];

            if(nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5 || visited[nextX][nextY])
                continue;

            if(cur[nextX][nextY] == 'X')
                continue;

            if(Math.abs(x - nextX) + Math.abs(y - nextY) > 2)
                continue;

            if(cur[nextX][nextY] == 'P') {
                result = 0;
                return;
            }

            visited[nextX][nextY] = true;
            dfs(x, y, nextX, nextY, visited, cur);
            visited[nextX][nextY] = false;
        }
    }
}
