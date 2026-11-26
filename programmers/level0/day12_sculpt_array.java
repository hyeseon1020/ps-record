package level0;

import java.util.Arrays;

public class day12_sculpt_array {
/*정수 배열 arr와 query가 주어집니다.
query를 순회하면서 다음 작업을 반복합니다.
짝수 인덱스에서는 arr에서 query[i]번 인덱스를 제외하고 배열의 query[i]번 인덱스 뒷부분을 잘라서 버립니다.
홀수 인덱스에서는 arr에서 query[i]번 인덱스는 제외하고 배열의 query[i]번 인덱스 앞부분을 잘라서 버립니다.
위 작업을 마친 후 남은 arr의 부분 배열을 return 하는 solution 함수를 완성해 주세요.

arr	query	result
[0, 1, 2, 3, 4, 5]	[4, 1, 2]	[1, 2, 3]*/
    // 1. 작성하신 풀이 (매 쿼리마다 Arrays.copyOfRange로 배열 갱신 - 직관적이고 이해하기 쉬운 방식!)
    static class SolutionMy {
        public int[] solution(int[] arr, int[] query) {
            int[] answer = arr;

            for (int i = 0; i < query.length; i++) {
                if (i % 2 == 0) {
                    // 짝수 인덱스: query[i]번 인덱스 뒷부분(query[i] + 1부터 끝까지)을 잘라냄
                    answer = Arrays.copyOfRange(answer, 0, query[i] + 1);
                } else {
                    // 홀수 인덱스: query[i]번 인덱스 앞부분(0부터 query[i] - 1까지)을 잘라냄
                    answer = Arrays.copyOfRange(answer, query[i], answer.length);
                }
            }

            return answer;
        }
    }

    // 2. 다른 사람의 풀이 (start, end 경계 인덱스만 이동 후 마지막에 한 번만 복사 - 배열 생성 비용 절감)
    static class SolutionBoundary {
        public int[] solution(int[] arr, int[] query) {
            int start = 0;
            int end = arr.length - 1;

            for (int i = 0; i < query.length; i++) {
                if (i % 2 == 0) {
                    end = start + query[i];
                } else {
                    start += query[i];
                }
            }

            return Arrays.copyOfRange(arr, start, end + 1);
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스: arr = [0, 1, 2, 3, 4, 5], query = [4, 1, 2] -> 결과: [1, 2, 3]
        int[] arr = {0, 1, 2, 3, 4, 5};
        int[] query = {4, 1, 2};

        int[] result = sol.solution(arr, query);
        System.out.println("테스트 결과: " + Arrays.toString(result) + " (기대값: [1, 2, 3])");
    }
}