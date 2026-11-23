package level0;

public class day12_first_negative {
/*첫번째로 나오는 음수
정수 리스트 num_list가 주어질 때, 첫 번째로 나오는 음수의 인덱스를 return하도록 solution 함수를 완성해주세요. 음수가 없다면 -1을 return합니다.
num_list	result
[12, 4, 15, 46, 38, -2, 15]	5
[13, 22, 53, 24, 15, 6]	-1*/
    // 1. 작성하신 풀이 (기본값 -1 설정 + 첫 음수 발견 시 break - 의도가 분명한 안정적인 방식!)
    static class SolutionMy {
        public int solution(int[] num_list) {
            int answer = -1;
            for (int i = 0; i < num_list.length; i++) {
                if (num_list[i] < 0) {
                    answer = i;
                    break; // 첫 번째 음수가 나오면 멈춤
                }
            }
            return answer;
        }
    }

    // 2. 다른 사람의 풀이 (조기 반환 활용 - 루프 탈출 변수가 필요 없어 더 간결함)
    static class SolutionEarlyReturn {
        public int solution(int[] num_list) {
            for (int i = 0; i < num_list.length; i++) {
                if (num_list[i] < 0) {
                    return i;
                }
            }
            return -1;
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: [12, 4, 15, 46, 38, -2, 15] -> 결과: 5
        int[] list1 = {12, 4, 15, 46, 38, -2, 15};
        System.out.println("테스트 1 결과: " + sol.solution(list1) + " (기대값: 5)");

        // 테스트 케이스 2: [13, 22, 53, 24, 15, 6] -> 결과: -1
        int[] list2 = {13, 22, 53, 24, 15, 6};
        System.out.println("테스트 2 결과: " + sol.solution(list2) + " (기대값: -1)");
    }
}