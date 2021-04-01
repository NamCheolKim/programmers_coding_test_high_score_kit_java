package stack_queue;

import java.util.Collections;
import java.util.PriorityQueue;

// 프로그래머스 level 2 프린터
public class Printer {
    static int solution(int[] priorities, int location) {
        int answer = 1;

        // 우선 순위 큐
        // * PriorityQueue<>(Collections.reverseOrder()) 는 최댓값 기준으로 우선순위가 정렬
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int priority : priorities){
            // * offer 는 큐에 값이 가득 차서 더이상 추가할 수 없는 경우 false 를 반환하고 추가되면 true 를 반환
            // 특정 예외를 던지지 않음
            queue.offer(priority);
        }

        while (!queue.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                // 프린트 하려는 문서의 우선순위 보다 높은 우선순위의 문서가 있는지 없는지 확인
                if(queue.peek() == priorities[i]){
                    if(location == i){
                        return answer;
                    }
                    queue.poll();
                    answer++;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int[]priorities = {2, 1, 3, 2};
        int location = 2;

        int[]priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;

        System.out.println(solution(priorities,location));
        System.out.println(solution(priorities2,location2));

    }
}
