package level0;

import java.util.ArrayList;
import java.util.Arrays;

public class day11_making_array_1 {
/*11day 배열만들기1

정수 n과 k가 주어졌을 때, 1 이상 n이하의 정수 중에서 k의 배수를 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
n	k	result
10	3	[3, 6, 9]
15	5	[5, 10, 15]*/
    // 1. 작성하신 풀이 (1부터 n까지 순회하며 k의 배수를 리스트에 담는 방식)
    static class SolutionMy {
        public int[] solution(int n, int k) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i % k == 0) {
                    list.add(i);
                }
            }
            return list.stream().mapToInt(i -> i).toArray();
        }
    }

    // 2. 다른 사람의 풀이 (배열 크기를 미리 계산하여 k의 배수를 바로 대입 - 성능 최적화)
    static class SolutionOptimized {
        public int[] solution(int n, int k) {
            int count = n / k;
            int[] answer = new int[count];

            for (int i = 1; i <= count; i++) {
                answer[i - 1] = k * i;
            }

            return answer;
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: n = 10, k = 3 -> 결과: [3, 6, 9]
        int n1 = 10;
        int k1 = 3;
        System.out.println("테스트 1 결과: " + Arrays.toString(sol.solution(n1, k1)) + " (기대값: [3, 6, 9])");

        // 테스트 케이스 2: n = 15, k = 5 -> 결과: [5, 10, 15]
        int n2 = 15;
        int k2 = 5;
        System.out.println("테스트 2 결과: " + Arrays.toString(sol.solution(n2, k2)) + " (기대값: [5, 10, 15])");
    }
}