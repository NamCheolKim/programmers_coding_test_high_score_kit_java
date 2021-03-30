package hash;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 level 1 완주하지 못한 선수
public class UnfinishedRunner {
    static String solution(String[] participant, String[] completion) {
        Map<String, Integer> hash = new HashMap<>();

        // 마라톤에 참여하는 선수명단
        // * getOrDefault 는 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환
        for(String part : participant ){
            hash.put(part, hash.getOrDefault(part, 0) + 1);
        }

        // 완주한 명단에 있는 선수는 제외
        for(String comp : completion){
            hash.put(comp, hash.get(comp) - 1);
        }
        for(String key : hash.keySet()){
            // 남아있다면 완주하지 못한 선수
            if(hash.get(key) != 0){
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] part = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] comp = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(part, comp));
    }
}
