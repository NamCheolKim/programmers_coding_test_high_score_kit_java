package greedy;

import java.util.Arrays;

// 프로그래머스 level 3 단속카메라
public class SpeedCamera {
    static int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int answer = 0;
        int camera = Integer.MIN_VALUE;

        for (int[] a : routes) {
            if (camera < a[0]) {
                camera = a[1];
                ++answer;
            }
        }
        return answer;

    }
}
