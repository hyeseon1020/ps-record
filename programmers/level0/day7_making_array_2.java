package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day7_making_array_2 {
/*
정수 l과 r이 주어졌을 때, l 이상 r이하의 정수 중에서 숫자 "0"과 "5"로만 이루어진 모든 정수를 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
만약 그러한 정수가 없다면, -1이 담긴 배열을 return 합니다. ex)[5, 50, 55, 500, 505, 550, 555]
*/
    // 1. 작성하신 풀이 (문자열 변환 및 정규식 검사 - 직관적이고 이해하기 쉬운 방식!)
    static class SolutionMy {
        public int[] solution(int l, int r) {
            List<Integer> list = new ArrayList<>();

            for (int i = l; i <= r; i++) {
                // i를 문자열로 바꿔서 0과 5로만 이루어져 있는지 체크
                if (String.valueOf(i).matches("^[05]+$")) {
                    list.add(i);
                }
            }
            // 조건에 맞는 수가 없으면 -1 담아 반환
            if (list.isEmpty()) {
                return new int[]{-1};
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    // 2. 다른 사람의 풀이 (이진법 활용 - 성능 최적화 및 수학적 아이디어)
    static class SolutionBinary {
        public int[] solution(int l, int r) {
            ArrayList<Integer> list = new ArrayList<>();

            // 이진법(1, 10, 11, 100...)에 5를 곱하면 0과 5로 이루어진 수(5, 50, 55, 500...)가 만들어짐
            for (int i = 1; i < 64; i++) {
                int num = Integer.parseInt(Integer.toBinaryString(i)) * 5;
                if (l <= num && num <= r) {
                    list.add(num);
                }
            }

            return list.isEmpty() ? new int[]{-1} : list.stream().mapToInt(i -> i).toArray();
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스: l = 5, r = 555 -> 결과: [5, 50, 55, 500, 505, 550, 555]
        int l = 5;
        int r = 555;

        int[] result = sol.solution(l, r);
        System.out.println("테스트 결과: " + Arrays.toString(result));
    }
}