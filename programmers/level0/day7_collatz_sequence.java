package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class day7_collatz_sequence {

    // 1. 작성하신 풀이 (ArrayList + while 문 + stream 변환)
    static class SolutionMy {
        public int[] solution(int n) {
            ArrayList<Integer> list = new ArrayList<>();

            // 1. 시작 값 n을 리스트에 먼저 추가
            list.add(n);

            // 2. n이 1이 될 때까지 반복 연산
            while (n != 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = 3 * n + 1;
                }
                list.add(n);
            }

            // 3. Stream의 mapToInt를 사용하여 int[] 변환
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    // 2. 다른 사람의 풀이 (IntStream.iterate 활용 - 함수형 프로그래밍 스타일)
    static class SolutionStream {
        public int[] solution(int n) {
            return IntStream.concat(
                    IntStream.iterate(n, i -> i > 1, i -> i % 2 == 0 ? i / 2 : i * 3 + 1),
                    IntStream.of(1)
            ).toArray();
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스: n = 10 -> 결과: [10, 5, 16, 8, 4, 2, 1]
        int n = 10;

        int[] result = sol.solution(n);
        System.out.println("테스트 결과: " + Arrays.toString(result));
    }
}