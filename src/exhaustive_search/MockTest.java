package exhaustive_search;

import java.util.*;

// 프로그래머스 level 1 모의고사
public class MockTest {
    static int[] solution(int[] answers) {
        int[]students = new int[3]; // 가장 정답을 많이 맞힌 수포자 비교하기 위한 배열
        int[]student1 = {1, 2, 3, 4, 5}; // 수포자1의 찍는 방식
        int[]student2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 수포자2의 찍는 방식
        int[]student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 수포자3의 찍는 방식

        // 정답과 수포자들이 찍은 답이 동일한 경우
        for(int i = 0; i < answers.length; i++){
            // 1번 수포자의 답이 정답과 동일하다면
            if(answers[i] == student1[i % student1.length]){
                students[0]++;
            }
            // 2번 수포자의 답이 정답과 동일하다면
            if(answers[i] == student2[i % student2.length]){
                students[1]++;
            }
            // 3번 수포자의 답이 정답과 동일하다면
            if(answers[i] == student3[i % student3.length]){
                students[2]++;
            }
        }
        // 누가 가장 많이 맞혔는지 비교 하기위한 리스트
        List<Integer> winner = new ArrayList<>();

        // 3명의 수포자들 중 가장 많이 맞힌 갯수
        int maxScore = Math.max(Math.max(students[0],students[1]),students[2]);

        // 1번 수포자가 가장 많이 맞혔다면
        if(maxScore == students[0]){
            winner.add(0);
        }
        // 2번 수포자가 가장 많이 맞혔다면
        if(maxScore == students[1]){
            winner.add(1);
        }
        // 3번 수포자가 가장 많이 맞혔다면
        if(maxScore == students[2]){
            winner.add(2);
        }

        // 가장 많이 맞힌 사람이 여러명일 경우 오름차순 정렬
        Collections.sort(winner);

        int[]answer = new int[winner.size()];

        // 가장 많이 맞힌 사람 저장
        for(int j = 0; j < answer.length; j++){
            answer[j] = winner.get(j) + 1;

        }

        return answer;
    }

    public static void main(String[] args) {
        int[]answers = {1,2,3,4,5};
        int[]answers2 = {1,3,2,4,2};


        System.out.println(Arrays.toString(solution(answers)));
        System.out.println(Arrays.toString(solution(answers2)));

    }
}
