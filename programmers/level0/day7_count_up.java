package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class day7_count_up {

    // 1. 작성하신 풀이 (ArrayList + stream 변환)
    static class SolutionMy {
        public int[] solution(int start_num, int end_num) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = start_num; i <= end_num; i++) {
                list.add(i);
            }
            return list.stream().mapToInt(i -> i).toArray();
        }
    }

    // 2. 다른 사람의 풀이 1 (크기가 정해진 배열에 직접 인덱스 대입 - 가장 메모리 효율적)
    static class SolutionArray {
        public int[] solution(int start, int end) {
            int[] answer = new int[end - start + 1];
            for (int i = 0; i <= end - start; i++) {
                answer[i] = start + i;
            }
            return answer;
        }
    }

    // 3. 다른 사람의 풀이 2 (IntStream.rangeClosed 활용 - 가장 코드가 간결함)
    static class SolutionStream {
        public int[] solution(int start, int end) {
            return IntStream.rangeClosed(start, end).toArray();
        }
    }

    // 4. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스: start_num = 3, end_num = 10 -> 결과: [3, 4, 5, 6, 7, 8, 9, 10]
        int start_num = 3;
        int end_num = 10;

        int[] result = sol.solution(start_num, end_num);
        System.out.println("테스트 결과: " + Arrays.toString(result));
    }
}