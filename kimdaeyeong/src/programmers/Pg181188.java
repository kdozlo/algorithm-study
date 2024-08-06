package programmers;


import java.util.Arrays;

/**
 * 프로그래머스 181188
 * 요격 시스템
 * lv2
 * https://school.programmers.co.kr/learn/courses/30/lessons/181188
 */
public class Pg181188 {

    public static void main(String[] args) {
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};

        // 끝값 기준으로 오름차순, 끝값 같으면 시작값 기준으로 오름차순
        Arrays.sort(targets, (o1, o2) -> (o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]));

        int answer = 1;
        int end = targets[0][1];
        for(int i = 1; i < targets.length; i++) {
            // 이전 끝값과 현재 시작값 비교
            if(targets[i][0] >= end) {
                answer++; // 시작값이 큰 경우 새로운 미사일 발사 필요
                end = targets[i][1]; // 끝값 갱신
            }
        }

        System.out.println(answer);
    }
}
