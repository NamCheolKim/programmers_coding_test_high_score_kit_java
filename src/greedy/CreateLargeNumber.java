package greedy;

import java.util.Stack;

// 프로그래머스 level 2 큰 수 만들기
public class CreateLargeNumber {
    static String solution(String number, int k) {

        // 입력 된 문자열 형식 숫자의 길이에서 제거 할 갯수를 뺀 만큼 결과 값을 넣을 배열 생성
        char[] result = new char[number.length() - k];

        // 값을 비교 할 스택 생성(Char형)
        Stack<Character> stack = new Stack<>();

        // 모든 문자를 비교해야 하기 때문에 입력 된 숫자의 길이만큼 반복
        for (int i = 0; i < number.length(); i++) {
            // 모든 숫자를 하나씩 비교
            char ch = number.charAt(i);
            // 스택이 비어있지 않고 마지막 스택을 뽑았을때 현재(i) 숫자보다 작고 k에서 1을 뺀 숫자가 0보다 크면 뽑은 숫자를 스택에서 제거.
            while (!stack.isEmpty() && stack.peek() < ch && k -- > 0) {
                stack.pop();
            }
            // 위의 while 의 조건이 맞지 않으면 스택에 추가
            stack.push(ch);
        }

        // 최종적으로 스택에 들어가있는 숫자를 결과값에 입력
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {

        System.out.println(solution("1231234", 3));
    }
}

