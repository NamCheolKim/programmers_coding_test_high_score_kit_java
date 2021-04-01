package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 level 2 다리를 지나는 트럭
public class TruckPassingThroughBridge {
    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int weights_sum = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int truck : truck_weights){
            while (true){
                // 다리를 트럭이 한대도 건너지 않은 경우
                if(queue.isEmpty()){
                    // 첫번째 트럭 진입
                    queue.add(truck);
                    weights_sum += truck;
                    answer ++;
                    break;
                }

                // 먼저 진입한 트럭이 다리의 끝까지 이동한 경우
                // * poll 은 queue 에 가장 먼저 보관한 값을 꺼내고 반환
                else if (queue.size() == bridge_length){
                    // 끝까지 이동한 트럭은 다리 밖으로 빠져나감
                    weights_sum -= queue.poll();
                }

                // 이미 다리를 지나는 중인 트럭의 무게와 진입 할 트럭의 무게를 다리가 견딜 수 있는 무게인지 아닌지 확인
                else{
                    // 두 트럭의 무게를 다리의 견디는 무게가 견딜 수 없다면
                    if(weights_sum + truck > weight){
                        // 지나는 중인 트럭 혼자 빠져 나갈 수 있게 대기
                        queue.add(0);
                        answer ++;
                    }else{
                        // 대기중인 트럭 다리에 진입
                        queue.add(truck);
                        weights_sum += truck;
                        answer ++;
                        break;
                    }
                }
            }
        }

        return answer + bridge_length;
    }

    public static void main(String[] args) {
        int bridge = 2;
        int weight = 10;
        int[] truck = {7,4,5,6};

        System.out.println(solution(bridge, weight, truck));

    }
}
