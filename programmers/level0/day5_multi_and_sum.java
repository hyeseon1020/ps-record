package level0;

import java.util.Arrays;

public class day5_multi_and_sum {
    /*원소들의 곱과 합
    정수가 담긴 리스트 num_list가 주어질 때, 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 크면 0을 return하도록 solution 함수를 완성해주세요*/

    // 1. 작성하신 풀이 (향상된 for문 방식 - 가장 빠르고 깔끔함)
    static class SolutionMy {
        public int solution(int[] num_list) {
            int sum = 0;
            int multiply = 1;

            for (int num : num_list) {
                sum += num;
                multiply *= num;
            }

            // sum * sum 방식이 Math.pow보다 직관적이고 연산 속도가 빠릅니다.
            return (multiply < sum * sum) ? 1 : 0;
        }
    }

    // 2. 다른 사람의 풀이 (Stream / reduce 활용 방식)
    static class SolutionStream {
        public int solution(int[] num_list) {
            int sum = Arrays.stream(num_list).sum();
            int product = Arrays.stream(num_list).reduce((i, j) -> i * j).getAsInt();

            return product < sum * sum ? 1 : 0;
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: [3, 4, 5, 2, 1] -> 곱: 120, 합의 제곱: 15^2 = 225 (곱 < 합의 제곱이므로 1)
        int[] numList1 = {3, 4, 5, 2, 1};
        int res1 = sol.solution(numList1);
        System.out.println("테스트 1 결과: " + res1 + " (기대값: 1)");

        // 테스트 케이스 2: [5, 7, 8, 3] -> 곱: 840, 합의 제곱: 23^2 = 529 (곱 > 합의 제곱이므로 0)
        int[] numList2 = {5, 7, 8, 3};
        int res2 = sol.solution(numList2);
        System.out.println("테스트 2 결과: " + res2 + " (기대값: 0)");
    }
}