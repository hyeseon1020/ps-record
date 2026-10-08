package level0;

import java.util.Arrays;

public class day6_sequence_queries_2 {
/*수열과 구간 쿼리2
정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다.
각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 k보다 크면서 가장 작은 arr[i]를 찾습니다.
각 쿼리의 순서에 맞게 답을 저장한 배열을 반환하는 solution 함수를 완성해 주세요.
단, 특정 쿼리의 답이 존재하지 않으면 -1을 저장합니다.*/
    // 1. 작성하신 풀이 (Integer.MAX_VALUE 활용 - 가장 직관적이고 정석적인 방식!)
    static class SolutionMy {
        public int[] solution(int[] arr, int[][] queries) {
            int[] answer = new int[queries.length];

            for (int q = 0; q < queries.length; q++) {
                int s = queries[q][0];
                int e = queries[q][1];
                int k = queries[q][2];

                int minVal = Integer.MAX_VALUE;

                for (int i = s; i <= e; i++) {
                    if (arr[i] > k && arr[i] < minVal) {
                        minVal = arr[i];
                    }
                }
                answer[q] = (minVal == Integer.MAX_VALUE) ? -1 : minVal;
            }
            return answer;
        }
    }

    // 2. 다른 사람의 풀이 (Arrays.fill(-1) + Math.min 활용)
    static class SolutionFill {
        public int[] solution(int[] arr, int[][] queries) {
            int[] answer = new int[queries.length];
            Arrays.fill(answer, -1); // 미리 -1로 초기화

            for (int idx = 0; idx < queries.length; idx++) {
                int[] query = queries[idx];
                int s = query[0], e = query[1], k = query[2];

                for (int i = s; i <= e; i++) {
                    if (k < arr[i]) {
                        answer[idx] = (answer[idx] == -1) ? arr[i] : Math.min(answer[idx], arr[i]);
                    }
                }
            }

            return answer;
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스: arr = [0, 1, 2, 4, 3], queries = [[0, 4, 2], [0, 3, 2], [0, 2, 2]]
        int[] arr = {0, 1, 2, 4, 3};
        int[][] queries = {
                {0, 4, 2},
                {0, 3, 2},
                {0, 2, 2}
        };

        int[] result = sol.solution(arr, queries);
        System.out.println("테스트 결과: " + Arrays.toString(result) + " (기대값: [3, 4, -1])");
    }
}