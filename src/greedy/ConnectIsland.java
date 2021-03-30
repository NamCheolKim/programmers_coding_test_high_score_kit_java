package greedy;

import java.util.Arrays;
import java.util.Comparator;

// 프로그래머스 level 3 섬 연결하기
public class ConnectIsland {
    static int solution(int n, int[][] costs) {
        Comparator<int[]> comparator = (a, b) ->{
            return a[2] - b[2];
        };

        Arrays.sort(costs, comparator);

        boolean[] bridge = new boolean[costs.length]; // 다리 건설 여부
        boolean[] visit = new boolean[n]; // 섬의 가능 여부

        visit[costs[0][0]] = true;
        visit[costs[0][1]] = true;

        bridge[0] = true;

        int answer = costs[0][2];
        int island = 2;

        while (island < n){
            for(int i = 1; i < bridge.length; i++) {
                if(!bridge[i] && ((visit[costs[i][0]] && !visit[costs[i][1]]) || (visit[costs[i][1]] && !visit[costs[i][0]]))) {
                    bridge[i] = true;

                    visit[costs[i][0]] = true;
                    visit[costs[i][1]] = true;

                    island ++;

                    answer += costs[i][2];
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][]cost = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(4,cost));
    }
}
