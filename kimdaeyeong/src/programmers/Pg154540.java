package programmers;

import java.util.*;

/**
 * 프로그래머스 154540
 * 무인도 여행
 * lv2
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540
 */
public class Pg154540 {
    private static char[][] m; // 지도 정보
    private static int r; // 지도의 행 사이즈
    private static int c; // 지도의 열 사이즈
    private static int days; // 총 머무를 수 있는 일수

    private static int[] dx = {-1, 0, 1, 0}; // x 방향
    private static int[] dy = {0, -1, 0, 1}; // y 방향

    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        List<Integer> answer = new ArrayList<>();

        r = maps.length;
        c = maps[0].length();
        m = new char[r][c];

        for(int i = 0; i < r; i++)
            m[i] = maps[i].toCharArray(); // 지도 2차원 배열화

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                // 갈 수 있는 경우
                if(m[i][j] != 'X') {
                    days = Character.getNumericValue(m[i][j]); // 현재 노드의 일수로 초기화
                    m[i][j]= 'X'; // 방문 체크
                    dfs(i, j);
                    answer.add(days);
                }
            }
        }

        if(answer.isEmpty()) {
            answer.add(-1); // 비어있는 경우 -1
            System.out.println(answer);
        } else {
            Collections.sort(answer); // 섬별 stay days 오름차순 정렬

            System.out.println(answer);
        }
    }

    private static void dfs(int x, int y) {

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i]; // 다음 x좌표
            int ny = y + dy[i]; // 다음 y좌표

            // 범위 체크
            if(nx >= r || nx < 0 || ny >= c || ny < 0)
                continue;

            // 방문 여부 체크
            if(m[nx][ny] == 'X')
                continue;

            days += Character.getNumericValue(m[nx][ny]); // 머무를수 있는 일수 업데이트
            m[nx][ny] = 'X'; // 방문 체크

            dfs(nx, ny); // 다음 노드로!
        }
    }
}
