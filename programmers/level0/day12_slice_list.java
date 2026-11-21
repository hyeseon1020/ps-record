package level0;

import java.util.Arrays;

public class day12_slice_list {
/*정수 n과 정수 3개가 담긴 리스트 slicer 그리고 정수 여러 개가 담긴 리스트 num_list가 주어집니다. slicer에 담긴 정수를 차례대로 a, b, c라고 할 때, n에 따라 다음과 같이 num_list를 슬라이싱 하려고 합니다.
n = 1 : num_list의 0번 인덱스부터 b번 인덱스까지
n = 2 : num_list의 a번 인덱스부터 마지막 인덱스까지
n = 3 : num_list의 a번 인덱스부터 b번 인덱스까지
n = 4 : num_list의 a번 인덱스부터 b번 인덱스까지 c 간격으로
올바르게 슬라이싱한 리스트를 return하도록 solution 함수를 완성해주세요.

n	slicer	num_list	result
3	[1, 5, 2]	[1, 2, 3, 4, 5, 6, 7, 8, 9]	[2, 3, 4, 5, 6]
4	[1, 5, 2]	[1, 2, 3, 4, 5, 6, 7, 8, 9]	[2, 4, 6]*/
    // 1. 작성하신 풀이 (switch 분기 + Arrays.copyOfRange 활용 - 조건별 의도가 명확한 방식!)
    static class SolutionMy {
        public int[] solution(int n, int[] slicer, int[] num_list) {
            int a = slicer[0];
            int b = slicer[1];
            int c = slicer[2];
            int[] answer = {};

            switch (n) {
                case 1:
                    // copyOfRange의 두 번째 인자는 '끝 인덱스 + 1'이므로 b + 1 지정
                    answer = Arrays.copyOfRange(num_list, 0, b + 1);
                    break;
                case 2:
                    answer = Arrays.copyOfRange(num_list, a, num_list.length);
                    break;
                case 3:
                    answer = Arrays.copyOfRange(num_list, a, b + 1);
                    break;
                case 4:
                    answer = new int[(b - a) / c + 1];
                    int idx = 0;
                    for (int i = slicer[0]; i <= slicer[1]; i += slicer[2]) {
                        answer[idx++] = num_list[i];
                    }
                    break;
            }

            return answer;
        }
    }

    // 2. 다른 사람의 풀이 (start, end, step으로 일반화해 단일 반복문으로 처리)
    static class SolutionUnified {
        public int[] solution(int n, int[] slicer, int[] num_list) {
            int start = n == 1 ? 0 : slicer[0];
            int end = n == 2 ? num_list.length - 1 : slicer[1];
            int step = n == 4 ? slicer[2] : 1;
            int[] answer = new int[(end - start + step) / step];
            for (int i = start, j = 0; i <= end; i += step) {
                answer[j++] = num_list[i];
            }
            return answer;
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        int[] slicer = {1, 5, 2};
        int[] numList = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // 테스트 케이스 1: n = 3 -> 결과: [2, 3, 4, 5, 6]
        System.out.println("테스트 1 결과: " + Arrays.toString(sol.solution(3, slicer, numList)) + " (기대값: [2, 3, 4, 5, 6])");

        // 테스트 케이스 2: n = 4 -> 결과: [2, 4, 6]
        System.out.println("테스트 2 결과: " + Arrays.toString(sol.solution(4, slicer, numList)) + " (기대값: [2, 4, 6])");
    }
}