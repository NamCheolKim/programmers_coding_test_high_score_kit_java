package stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 level 2 기능개발
public class FunctionalDevelopment {
    static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            // 개발 완료까지 남은기간
            queue.add(
                    (100 - progresses[i]) % speeds[i] == 0 ?
                    (100 - progresses[i]) / speeds[i] :
                    (100 - progresses[i]) / speeds[i] + 1
            );
        }

        // 결과 값을 담을 list
        ArrayList<Integer> resultList = new ArrayList<>();

        // 첫 작업의 남은기간을 꺼내 저장
        // * poll 은 queue 에 가장 먼저 보관한 값을 꺼내고 반환
        int prevFunc = queue.poll();

        // 모든 개발작업은 완료시 최소 1개의 작업이 완료 되기때문에 카운트 1
        int cntFunc = 1;

        // 배포시 몇개의 기능이 배포되는지
        while (!queue.isEmpty()){

            // 첫 작업의 남은기간과 비교할 다음 작업의 남은기간을 저장
            int nextFunc = queue.poll();

            // 다음 작업의 남은기간이 첫 작업의 남은기간보다 짧거나 같을 경우(다음 작업의 남은기간이 첫 작업의 남은기간에 포함될 경우)
            if(prevFunc >= nextFunc){
                // 첫 작업이 완료 된 뒤 같이 배포 될 작업이므로 카운트
                cntFunc++;
            }
            // 첫 작업의 남은기간 보다 길 경우 더 늦게 완료될 작업이므로 카운트를 멈춤
            else{
                // list 에 카운트된 작업들을 추가
                resultList.add(cntFunc);
                // 카운트를 새로 초기화
                cntFunc = 1;
                // 새로운 비교값으로 다음 남은기간을 지정
                prevFunc = nextFunc;
            }
        }

        // 값을 모두 꺼냈을때 마지막 카운트 저장
        resultList.add(cntFunc);

        // list 에 저장된 값들을 배열에 하나씩 저장
        int[] answer = new int[resultList.size()];

        for(int j = 0; j < resultList.size(); j++){
            answer[j] = resultList.get(j);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] progress = {93, 30, 55};
        int[] speed = {1, 30, 5};

        int[] progress2 = {95, 90, 99, 99, 80, 99};
        int[] speed2 = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progress,speed)));
        System.out.println(Arrays.toString(solution(progress2,speed2)));
    }
}
