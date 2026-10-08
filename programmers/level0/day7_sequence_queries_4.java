package level0;

import java.util.Arrays;

public class day7_sequence_queries_4 {
/*
수열과 구간 쿼리 4
정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다.
각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 i가 k의 배수이면 arr[i]에 1을 더합니다.
위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.
*/
    // 1. 작성하신 풀이 (향상된 for문 활용 - 변수 선언이 명확해서 가독성이 매우 뛰어남)
    static class SolutionMy {
        public int[] solution(int[] arr, int[][] queries) {
            for (int[] query : queries) {
                int s = query[0];
                int e = query[1];
                int k = query[2];

                for (int i = s; i <= e; i++) {
                    // i(인덱스)가 k의 배수인지 확인 (0도 k의 배수로 처리됨: 0 % k == 0)
                    if (i % k == 0) {
                        arr[i] += 1;
                    }
                }
            }
            return arr;
        }
    }

    // 2. 다른 사람의 풀이 (인덱스 기반 for문)
    static class SolutionLoop {
        public int[] solution(int[] arr, int[][] queries) {
            for (int i = 0; i < queries.length; i++) {
                for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                    if (j % queries[i][2] == 0) arr[j] += 1;
                }
            }
            return arr;
        }
    }

    // 3. 반복 스텝 최적화 방식 (k의 배수로만 증가)
    static class SolutionOptimized {
        public int[] solution(int[] arr, int[][] queries) {
            for (int[] query : queries) {
                int s = query[0];
                int e = query[1];
                int k = query[2];

                // s 이상에서 시작하는 첫 번째 k의 배수 찾기
                int start = (s % k == 0) ? s : s + (k - s % k);

                // i를 1씩 증가시키며 조건문 검사 대신, k만큼씩 바로 점프
                for (int i = start; i <= e; i += k) {
                    arr[i]++;
                }
            }
            return arr;
        }
    }

    // 4. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스: arr = [0, 1, 2, 4, 3], queries = [[0, 4, 1], [0, 3, 2], [0, 3, 3]]
        int[] arr = {0, 1, 2, 4, 3};
        int[][] queries = {
                {0, 4, 1},
                {0, 3, 2},
                {0, 3, 3}
        };

        int[] result = sol.solution(arr, queries);
        System.out.println("테스트 결과: " + Arrays.toString(result) + " (기대값: [3, 2, 4, 6, 4])");
    }
}