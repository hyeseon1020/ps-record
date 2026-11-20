package level0;

import java.util.Arrays;
import java.util.stream.IntStream;

public class day11_countdown {
/*카운트 다운
정수 start_num와 end_num가 주어질 때, start_num에서 end_num까지 1씩 감소하는 수들을 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.

start_num	end_num	result
10	3	[10, 9, 8, 7, 6, 5, 4, 3]*/
    // 1. 작성하신 풀이 (배열 크기 사전 계산 + 감소값 대입 - 메모리 및 속도 모두 최적인 모범 풀이!)
    static class SolutionMy {
        public int[] solution(int start_num, int end_num) {
            int count = start_num - end_num + 1;
            int[] answer = new int[count];
            for (int i = 0; i < count; i++) {
                answer[i] = start_num - i;
            }
            return answer;
        }
    }

    // 2. 다른 사람의 풀이 (IntStream.rangeClosed + 부호 반전 트릭)
    static class SolutionStream {
        public int[] solution(int start, int end) {
            // rangeClosed는 오름차순만 지원하므로 -start부터 -end까지 생성 후 다시 -1을 곱함
            return IntStream.rangeClosed(-start, -end).map(i -> -i).toArray();
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스: start_num = 10, end_num = 3 -> 결과: [10, 9, 8, 7, 6, 5, 4, 3]
        int start_num = 10;
        int end_num = 3;

        int[] result = sol.solution(start_num, end_num);
        System.out.println("테스트 결과: " + Arrays.toString(result) + " (기대값: [10, 9, 8, 7, 6, 5, 4, 3])");
    }
}