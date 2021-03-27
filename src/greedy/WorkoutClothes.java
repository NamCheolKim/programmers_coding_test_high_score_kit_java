package greedy;

public class WorkoutClothes {
    static int solution(int n, int[] lost, int[] reserve) {

        int[] student = new int[n]; // 전체 학생 수
        int answer = n;

        // 체육복을 잃어버린 학생
        for(int lo : lost){
            student[lo - 1]--;
        }
        // 여분의 체육복을 가지고 있는 학생
        for(int re : reserve){
            student[re - 1]++;
        }

        for(int i = 0; i < student.length; i++){
            // 체육복을 잃어버린 학생이 여분의 체육복이 있는 앞 뒤 번호 학생들에게 빌릴 수 있는 지 판단
            if(student[i] == -1){
                // 잃어버린 학생의 앞 번호 학생이 여분의 체육복을 가지고 있다면
                if(i - 1 >= 0 && student[i - 1] == 1){
                    student[i]++; // 체육복을 잃어버린 학생에게 빌려준다.
                    student[i - 1]--; // 여분의 체육복을 빌려 주었기 때문에 빌려준 학생은 자신의 체육복만 가지고 있음
                }
                // 잃어버린 학생 수가 전체 학생보다 적고 뒷 번호 학생이 여분의 체육복을 가지고 있다면
                else if(i + 1 < student.length && student[i + 1] == 1){
                    student[i]++; // 체육복을 잃어버린 학생에게 빌려준다.
                    student[i + 1]--; // 여분의 체육복을 빌려 주었기 때문에 빌려준 학생은 자신의 체육복만 가지고 있음
                }
                // 앞 뒤 번호 학생이 여분의 체육복을 모두 빌려주었기 때문에 체육복을 빌리지 못한 학생을 제외한 체육수업을 들을 수 있는 학생의 수
                else{
                    answer--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int a = 5;
        int[] l = {2,4};
        int[] r = {3};

        System.out.println(solution(a,l,r));

    }
}
