package level0;

import java.util.Arrays;

public class day6_sequence_queries_3 {
/*정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [i, j] 꼴입니다.
각 query마다 순서대로 arr[i]의 값과 arr[j]의 값을 서로 바꿉니다.
위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.
*/
    // 1. 작성하신 풀이 (기본 for문 활용)
    static class SolutionMy {
        public int[] solution(int[] arr, int[][] queries) {
            int[] answer = arr; // 참고: 원본 arr 배열의 참조(주소)를 같이 가리킵니다.

            for (int i = 0; i < queries.length; i++) {
                int idx1 = queries[i][0];
                int idx2 = queries[i][1];

                int temp = answer[idx1];
                answer[idx1] = answer[idx2];
                answer[idx2] = temp;
            }

            return answer;
        }
    }

    // 2. 다른 사람의 풀이 (Arrays.copyOf + 향상된 for문)
    static class SolutionForEach {
        public int[] solution(int[] arr, int[][] queries) {
            // 원본 배열 복사 (원본 불변성 유지)
            int[] answer = Arrays.copyOf(arr, arr.length);

            for (int[] query : queries) {
                int i = query[0];
                int j = query[1];

                int temp = answer[i];
                answer[i] = answer[j];
                answer[j] = temp;
            }

            return answer;
        }
    }

    // 3. 리팩토링 풀이 (Swap 메서드 분리로 가독성 향상)
    static class SolutionClean {
        public int[] solution(int[] arr, int[][] queries) {
            for (int[] query : queries) {
                swap(arr, query[0], query[1]);
            }
            return arr;
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // 4. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스: arr = [0, 1, 2, 3, 4], queries = [[0, 3], [1, 2], [1, 4]]
        int[] arr = {0, 1, 2, 3, 4};
        int[][] queries = {{0, 3}, {1, 2}, {1, 4}};

        int[] result = sol.solution(arr, queries);
        System.out.println("테스트 결과: " + Arrays.toString(result) + " (기대값: [3, 4, 1, 0, 2])");
    }
}