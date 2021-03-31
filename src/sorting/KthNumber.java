package sorting;

import java.util.Arrays;

// 프로그래머스 level 1 K번째 수
public class KthNumber {
    static int[] solution(int[] array, int[][] commands) {
        // K번째 수를 담아 반환시킬 배열
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {

            // i번째 숫자부터 j번째 숫자까지 배열 자르기
            // * copyOfRange 는 배열의 특정 범위에 해당하는 요소만을 새로운 배열로 복사하여 반환
            // * Arrays.copyOfRange(배열, 시작 인덱스, 종료 인덱스)
            int[] result = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);

            // 배열을 정렬
            Arrays.sort(result);

            // k번째 숫자를 answer 배열에 저장
            answer[i] = result[commands[i][2] - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] comm = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(arr, comm)));
    }
}
