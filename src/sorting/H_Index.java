package sorting;

import java.util.Arrays;

// 프로그래머스 level 2 H-Index
public class H_Index {
    static int solution(int[] citations) {

        int answer = citations.length;

        for(int i = 0; i < citations.length; i++){

            Arrays.sort(citations);

            // h번 이상 인용된 논문이 h편 이상을 구함
            if(citations[i] >= answer - i){
                return answer - i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[]n = {7, 6, 1, 5};
        System.out.println(solution(n));

    }
}
