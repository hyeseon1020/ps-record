package level0;

import java.util.Arrays;

public class day6_last_two_elements {
/*정수 리스트 num_list가 주어질 때, 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을 마지막 원소가 그전 원소보다 크지 않다면 마지막 원소를 두 배한 값을 추가하여 return하도록 solution 함수를 완성해주세요.
배열경우 자리를 먼저 만들어주고 값을 변경하는 형식으로 해야해서 복제하고 자리맞추고 나서 그 위치에 값을 넣어줘야함 자리만 있는 곳은 기본으로 0으로 표시 됨*/
    // 1. 작성하신 풀이 (Arrays.copyOf 활용 - 가장 추천하는 방식!)
    static class SolutionMy {
        public int[] solution(int[] num_list) {
            int last_num = num_list[num_list.length - 1];
            int secondlist_num = num_list[num_list.length - 2];

            // 기존 배열보다 크기가 1 큰 배열을 만들고 원소 복사
            int[] answer = Arrays.copyOf(num_list, num_list.length + 1);

            // 마지막 자리에 조건식 결과값 대입
            answer[answer.length - 1] = (last_num > secondlist_num) ? (last_num - secondlist_num) : (last_num * 2);

            return answer;
        }
    }

    // 2. 다른 사람의 풀이 (new int[] 생성 후 for문으로 복사)
    static class SolutionLoop {
        public int[] solution(int[] num_list) {
            int len = num_list.length;
            int[] answer = new int[len + 1];

            for (int i = 0; i < len; i++) {
                answer[i] = num_list[i];
            }

            answer[len] = num_list[len - 1] > num_list[len - 2]
                    ? num_list[len - 1] - num_list[len - 2]
                    : num_list[len - 1] * 2;

            return answer;
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: [2, 1, 6] -> 마지막(6) > 그전(1) 이므로 6 - 1 = 5 추가 -> [2, 1, 6, 5]
        int[] numList1 = {2, 1, 6};
        int[] res1 = sol.solution(numList1);
        System.out.println("테스트 1 결과: " + Arrays.toString(res1) + " (기대값: [2, 1, 6, 5])");

        // 테스트 케이스 2: [5, 2, 1, 7, 5] -> 마지막(5) <= 그전(7) 이므로 5 * 2 = 10 추가 -> [5, 2, 1, 7, 5, 10]
        int[] numList2 = {5, 2, 1, 7, 5};
        int[] res2 = sol.solution(numList2);
        System.out.println("테스트 2 결과: " + Arrays.toString(res2) + " (기대값: [5, 2, 1, 7, 5, 10])");
    }
}