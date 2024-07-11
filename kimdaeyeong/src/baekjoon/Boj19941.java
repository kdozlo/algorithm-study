package baekjoon;

import java.util.*;
import java.io.*;

public class Boj19941 {

    static int n;
    static int k;
    static char[] c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 식탁의 길이
        k = Integer.parseInt(st.nextToken()); // 햄버거를 선택할 수 있는 거리

        st = new StringTokenizer(br.readLine());
        c = st.nextToken().toCharArray();

        System.out.println(divide());
    }

    public static int divide() {
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            if(c[i] == 'P') {
                int cur = i - k;
                boolean check = false;

                while(cur < i) {
                    if(cur < 0) {
                        cur++;
                        continue;
                    }

                    if(c[cur] == 'H') {
                        check = true;
                        c[cur] = 'X';
                        cnt++;
                        break;
                    }
                    cur++;
                }

                if(check)
                    continue;

                cur = i;
                for(int j = 1; j <= k; j++) {
                    cur += 1;
                    if(cur < n && c[cur] == 'H') {
                        c[cur] = 'X';
                        cnt++;
                        break;
                    }
                }
            }
        }

        return cnt;
    }
}
