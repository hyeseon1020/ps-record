package level0;

import java.util.Arrays;
import java.util.stream.Collectors;

public class day5_concat_number {
/*정수가 담긴 리스트 num_list가 주어집니다.
num_list의 홀수만 순서대로 이어 붙인 수와 짝수만 순서대로 이어 붙인 수의 합을 return하도록 solution 함수를 완성해주세요.*/
    // 1. 작성하신 풀이 (문자열 연결 + Integer.parseInt)
    static class SolutionMy {
        public int solution(int[] num_list) {
            String n2 = ""; // 짝수 연결용
            String n = "";  // 홀수 연결용

            for (int num : num_list) {
                if (num % 2 == 0) {
                    n2 = n2 + num;
                } else {
                    n = n + num;
                }
            }

            return Integer.parseInt(n2) + Integer.parseInt(n);
        }
    }
    // 2. 다른 사람의 풀이 (수학적 연산 * 10 활용 - 추천 방식!)
    static class SolutionMath {
        public int solution(int[] num_list) {
            int even = 0; // 짝수
            int odd = 0;  // 홀수

            for (int num : num_list) {
                if (num % 2 == 0) {
                    even = (even * 10) + num;
                } else {
                    odd = (odd * 10) + num;
                }
            }

            return even + odd;
        }
    }

    // 3. 다른 사람의 풀이 (Stream + Collectors.joining 활용)
    static class SolutionStream {
        public int solution(int[] numList) {
            int odd = Integer.parseInt(
                    Arrays.stream(numList)
                            .filter(value -> value % 2 != 0)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining())
            );

            int even = Integer.parseInt(
                    Arrays.stream(numList)
                            .filter(value -> value % 2 == 0)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining())
            );

            return odd + even;
        }
    }

    // 4. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: [3, 4, 5, 2, 1] -> 홀수(351) + 짝수(42) = 393
        int[] numList1 = {3, 4, 5, 2, 1};
        int res1 = sol.solution(numList1);
        System.out.println("테스트 1 결과: " + res1 + " (기대값: 393)");

        // 테스트 케이스 2: [5, 7, 8, 3] -> 홀수(573) + 짝수(8) = 581
        int[] numList2 = {5, 7, 8, 3};
        int res2 = sol.solution(numList2);
        System.out.println("테스트 2 결과: " + res2 + " (기대값: 581)");
    }
}