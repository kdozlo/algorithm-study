package programmers;

import java.util.*;

/**
 * 프로그래머스 92341
 * 주차 요금 계산
 * lv2
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */
public class Pg92341 {

    static Map<Integer, List<Integer>> m; //  차량 번호, 입 출차 리스트

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        m = new HashMap<>();
        splitRecords(records);

        int size = m.size();
        int[] answer = new int[size];
        List<Integer> keys = makeKeys(m.keySet());

        for(int i = 0; i < size; i++) {
            answer[i] = calculateFees(fees, keys.get(i));
        }

        System.out.println(Arrays.toString(answer));
    }

    public static void splitRecords(String[] records) {

        for(String s : records) {
            String[] ss = s.split(" ");

            int carNum = Integer.parseInt(ss[1]);
            int t = makeTime(ss[0]);
            int dir = ss[2].equals("IN") ? -1 : 1;

            if(!m.containsKey(carNum)) {
                List<Integer> l = new ArrayList<>();
                l.add(t * dir);
                m.put(carNum, l);
            } else {
                m.get(carNum).add(t * dir);
            }
        }
    }

    public static int makeTime(String s) {
        String[] ss = s.split(":");

        return Integer.parseInt(ss[0]) * 60 + Integer.parseInt(ss[1]);
    }

    public static List<Integer> makeKeys(Set<Integer> keySet) {

        List<Integer> l = new ArrayList<>();

        for(Integer i : keySet)
            l.add(i);

        Collections.sort(l);

        return l;
    }

    public static int calculateFees(int[] fees, Integer key) {

        int sum = 0;

        for(int i = 0; i < m.get(key).size(); i += 2) {

            int in = m.get(key).get(i);
            int out = i == m.get(key).size() - 1 ? 60 * 23 + 59 : m.get(key).get(i + 1);

            sum += in + out;
        }

        if(sum > fees[0]) {
            return fees[1] + (int) Math.ceil((sum - fees[0]) / (double)fees[2]) * fees[3];
        }

        return fees[1];
    }
}
