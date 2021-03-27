class Solution {
    static int solution(String name) {

        int answer = 0;
        int len = name.length();
        int minMove = len - 1;

        for(int i = 0; i < len; i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int nextChar = i + 1;

            while (nextChar < len && name.charAt(nextChar) == 'A'){
                nextChar += 1;
            }
            int move = i * 2 + len - nextChar;
            minMove = Math.min(minMove, move);
        }
        answer += minMove;
        return answer;
    }
}