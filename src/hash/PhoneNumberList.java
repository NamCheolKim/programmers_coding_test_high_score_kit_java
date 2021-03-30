package hash;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 level 2 전화번호 목록
public class PhoneNumberList {
    static boolean solution(String[] phone_book) {
        Map<String, Integer> hash = new HashMap<>();

        for(String phoneBook : phone_book) {
            hash.put(phoneBook, 0);
        }

        // 키와 target 의 접두어가 같은지 비교
        for(String target : phone_book){
            for(int i = 0; i < target.length(); i++){
                // * containsKey 는 맵에서 인자로 보낸 키가 있으면 true 없으면 false
                if(hash.containsKey(target.substring(0, i))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] phoneBook = {"119", "11276743", "1125524421"};

        System.out.println(solution(phoneBook));
    }
}
