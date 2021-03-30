package hash;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 level 2 위장
public class Camouflage {
    static int solution(String[][] clothes) {
        Map<String, Integer> hash = new HashMap<>();
        int answer = 1;

        // 스파이의 의상 종류
        // * getOrDefault 는 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환
        for(String[] ware : clothes){
            // 의상의 종류를 키캆으로 지정
            hash.put(ware[1], hash.getOrDefault(ware[1], 0) + 1);
        }

        // 의상의 종류를 입은 경우의 수(입지 않은 경우 포함)
        for(String key : hash.keySet()){
            answer *= hash.get(key) + 1;
        }

        // 아무것도 입지 않은 경우는 제외
        answer -= 1;

        return answer;
    }

    public static void main(String[] args) {
        String[][]clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

}
