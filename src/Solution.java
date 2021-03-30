import java.util.HashMap;
import java.util.Map;

class Solution {
    static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hash = new HashMap<>();

        for(String[] ware : clothes){
            hash.put(ware[1], hash.getOrDefault(ware[1], 0) + 1);
        }
        for(String key : hash.keySet()){
            answer *= hash.get(key) + 1;
        }
        answer -= 1;

        return answer;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));

    }
}