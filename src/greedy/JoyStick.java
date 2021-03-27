package greedy;
// 프로그래머스 조이스틱
public class JoyStick {
    static int solution(String name) {

        int answer = 0;
        int len = name.length();

        // 최소 이동은 마지막 위치까지 이동한 횟수
        int min_move = len - 1;

        for(int i = 0; i < len; i++) {

            // A에서 입력할 알파벳까지 정방향(A -> B -> C 순) 이동 횟수 와 A에서 입력 할 알파벳까지 역방향(A -> Z -> Y 순) 이동 횟수중 최소로 이동 한 횟수
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int nextChar = i + 1; // 현재 입력한 알파벳의 다음 위치부터

            // 다음 위치가 A라면 최소 이동횟수가 달라짐
            while(nextChar < len && name.charAt(nextChar) == 'A')
                nextChar += 1;

            // 역방향 이동 횟수
            int move = i * 2 + len - nextChar;
            // 정방향과 역방향중 가장 적게 이동하면 최소 횟수
            min_move = Math.min(min_move, move);
        }
        answer += min_move;

        return answer;
    }


    public static void main(String[] args) {
        String n = "KAIN";
        System.out.println(solution(n));

    }


}
