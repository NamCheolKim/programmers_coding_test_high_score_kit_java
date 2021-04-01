package stack_queue;

import java.util.Arrays;

// 프로그래머스 level 2 주식가격
public class StockPrice {
    static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++){
            int secCnt = 0;
            for(int j = i + 1; j < prices.length; j++){
                // 각 초 시점의 가격이 1초가 지날때 떨어지지 않았으면
                if(prices[i] <= prices[j]){
                    // 1초 증가
                    secCnt++;
                }else{
                    // 각 초 시점의 가격이 1초가 지날때 떨어졌으면
                    // 1초 증가 후 탈출
                    secCnt++;
                    break;
                }
            }
            answer[i] = secCnt;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] price = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(price)));
    }
}
