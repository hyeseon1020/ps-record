package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day12_area_of_2 {
    /*정수 배열 arr가 주어집니다. 배열 안의 2가 모두 포함된 가장 작은 연속된 부분 배열을 return 하는 solution 함수를 완성해 주세요.

    단, arr에 2가 없는 경우 [-1]을 return 합니다.

    arr result
    [1, 2, 1, 4, 5, 2, 9] [2, 1, 4, 5, 2]
    [1, 2, 1] [2]
    [1, 1, 1] [-1]
    [1, 2, 1, 2, 1, 10, 2, 1] [2, 1, 2, 1, 10, 2]*/
    // 1. 작성하신 풀이 (2가 등장하는 모든 인덱스를 기록한 뒤 start ~ end 구간 추출 - 직관적이고 명확한 방식!)
    static class SolutionMy {
        public int[] solution(int[] arr) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 2) {
                    list.add(i);
                }
            }

            if (list.isEmpty()) {
                return new int[]{-1};
            }

            int start = list.get(0);
            int end = list.get(list.size() - 1);

            int[] answer = new int[end - start + 1];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = arr[start + i];
            }

            return answer;
        }
    }

    // 2. 다른 접근법 (양 끝 인덱스만 직접 탐색해 Arrays.copyOfRange로 복사)
    static class SolutionTwoPointer {
        public int[] solution(int[] arr) {
            int start = -1;
            int end = -1;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 2) {
                    if (start == -1) {
                        start = i;
                    }
                    end = i;
                }
            }

            if (start == -1) {
                return new int[]{-1};
            }

            return Arrays.copyOfRange(arr, start, end + 1);
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: [1, 2, 1, 4, 5, 2, 9] -> 결과: [2, 1, 4, 5, 2]
        System.out.println("테스트 1 결과: " + Arrays.toString(sol.solution(new int[]{1, 2, 1, 4, 5, 2, 9})) + " (기대값: [2, 1, 4, 5, 2])");

        // 테스트 케이스 2: [1, 2, 1] -> 결과: [2]
        System.out.println("테스트 2 결과: " + Arrays.toString(sol.solution(new int[]{1, 2, 1})) + " (기대값: [2])");

        // 테스트 케이스 3: [1, 1, 1] -> 결과: [-1]
        System.out.println("테스트 3 결과: " + Arrays.toString(sol.solution(new int[]{1, 1, 1})) + " (기대값: [-1])");

        // 테스트 케이스 4: [1, 2, 1, 2, 1, 10, 2, 1] -> 결과: [2, 1, 2, 1, 10, 2]
        System.out.println("테스트 4 결과: " + Arrays.toString(sol.solution(new int[]{1, 2, 1, 2, 1, 10, 2, 1})) + " (기대값: [2, 1, 2, 1, 10, 2])");
    }
}