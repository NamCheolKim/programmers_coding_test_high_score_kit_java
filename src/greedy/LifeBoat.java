package greedy;

import java.util.Arrays;

// 프로그래머스 level 2 큰 수 만들기
public class LifeBoat {
    static int solution(int[] people, int limit) {
        int answer = 0;
        int min = 0;

        // 보트를 타야할 사람들의 index 번호
        int peoples = people.length - 1;

        // 앞뒤로 몸무게가 적게 나가는 사람과 많이 나가는 사람으로 비교하기 위해 오름차순 정렬
        Arrays.sort(people);

        // 몸무게가 가장 적게 나가는 사람과 가장 많이 나가는 사람의 몸무게의 합과 보트의 무게제한을 비교
        for(int i = peoples; min <= i; i-- ){
            // 두사람의 몸무게가 보트의 무게제한을 초과한다면
            // 몸무게가 무거운 사람을 혼자 보내야 하기 때문에 보트(answer) 추가
            if(people[min] + people[i] > limit){
                answer ++;
            }else{
                // 두사람의 몸무게가 보트의 무게제한을 초과하지 않는다면
                // 보트 추가 후 현재 몸무게가 가장 적게 나가는 사람은 태워 보냈기 때문에 다음 몸무게가 적게 나가는 사람과 비교하기 위해 min++
                answer++;
                min++;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] peo = {20, 30, 30, 50, 60, 70, 80, 90, 100};
        int li = 100;
        System.out.println(solution(peo, li));
    }
}
