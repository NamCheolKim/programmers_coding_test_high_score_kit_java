package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    static String solution(int[] numbers) {
        String answer = "";

        // 숫자 배열 numbers 를 문자열 배열로 변환
        String[] result = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            // * String.valueOf 는 어떠한 값이라도 항상 String 형태로 출력
            // ex) 값이 null 이라면 문자열 "null"을 반환
            result[i] = String.valueOf(numbers[i]);
        }

        // o2 + o1 과 o1 + o2 중 더 큰 쪽이 우선순위가 되도록 정렬
        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 내림차순 정렬
                return ((o2 + o1).compareTo(o1 + o2));
            }
        });

        // 리턴 값이 0으로만 존재하는 배열이라면 0 하나만 리턴
        if(result[0].equals("0")){
            return "0";
        }

        // 정렬된 문자를 하나로 합치기
        for (String j: result) {
            answer += j;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[]num = {6, 10, 2};
        System.out.println(solution(num));
    }
}
